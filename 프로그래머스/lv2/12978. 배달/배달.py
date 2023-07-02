def solution(N, road, K):
    answer = 0
    towns = [[int(1e9) for _ in range(N+1)] for _ in range(N+1)]
    
    for i in range(N+1):
        towns[i][i] = 0
    
    for i in range(len(road)):
        towns[road[i][0]][road[i][1]] = min(towns[road[i][0]][road[i][1]], road[i][2])
        towns[road[i][1]][road[i][0]] = min(towns[road[i][1]][road[i][0]], road[i][2])

    for k in range(1, N+1):
        for i in range(1, N+1):
            for j in range(1, N+1):
                towns[i][j] = min(towns[i][j], towns[i][k] + towns[k][j])
                
    for distance in towns[1]:
        if distance <= K:
            answer += 1
            
    return answer