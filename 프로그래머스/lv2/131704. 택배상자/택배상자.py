from collections import deque

def solution(order):
    answer = 0
    container = deque([i for i in range(1, len(order)+1)])
    tmp = []
    idx = 0

    while container or tmp:

        if container:
            if order[idx] == container[0]:
                answer += 1
                container.popleft()
                idx += 1
                continue
        else:
            if tmp[-1] != order[idx]:
                break

        if tmp:
            if tmp[-1] == order[idx]:
                tmp.pop()
                answer += 1
                idx += 1
                continue

        while container:
            tmp_n = container.popleft()
            tmp.append(tmp_n)

            if order[idx] == tmp_n:
                answer += 1
                idx += 1
                tmp.pop()
                break

    return answer