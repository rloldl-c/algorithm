def solution(targets):
    targets = sorted(targets, key=lambda x: x[1])

    now = -1
    answer = 0

    for i in range(len(targets)):
        if now < targets[i][0]:
            print(targets[i])
            now = targets[i][1] - 0.5
            answer += 1
    
    return answer