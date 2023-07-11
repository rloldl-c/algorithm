def backtracking(l, idx, tmp, order):
    if len(tmp) == l:
        order.append(list(map(int, tmp)))
        return
    
    for i in range(l):
        if str(i) not in tmp:
            backtracking(l, i+1, tmp+str(i), order)


def solution(k, dungeons):
    answer = 0
    order = []
    
    dungeons = sorted(dungeons, key=lambda x: (x[0], x[1]), reverse=True)
    
    backtracking(len(dungeons), 0, "", order)
    
    for i in range(len(order)):
        now = k
        tmp = 0
        for j in range(len(order[i])):
            x = order[i][j]
            
            if now >= dungeons[x][0]:
                now -= dungeons[x][1]
                tmp += 1
            
        answer = max(answer, tmp)
        if answer == len(order[i]):
            break
            
    return answer