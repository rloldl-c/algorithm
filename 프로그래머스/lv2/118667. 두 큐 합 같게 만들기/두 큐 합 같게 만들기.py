from collections import deque

def solution(queue1, queue2):
    answer = 0
    sum_que1 = sum(queue1)
    sum_que2 = sum(queue2)
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    max_cnt = len(queue1) * 3
    
    if (sum_que1 + sum_que2) // 2 == 1:
        answer = -1
        return answer
    
    cnt = 0
    while cnt < max_cnt:
        if sum_que1 == sum_que2:
            break
        
        if sum_que1 > sum_que2:
            tmp = queue1.popleft()
            queue2.append(tmp)
            answer += 1
            sum_que1 -= tmp
            sum_que2 += tmp
        else:
            tmp = queue2.popleft()
            queue1.append(tmp)
            answer += 1
            sum_que2 -= tmp
            sum_que1 += tmp
            
        cnt += 1
        
    if cnt >= max_cnt:
        answer = -1
    
    return answer