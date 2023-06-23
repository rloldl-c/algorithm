from collections import deque

def bfs(x, y, maps, visited):
    dxy = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    day = int(maps[x][y])
    que = deque()
    que.append((x, y))
    visited[x][y] = True
    
    while que:
        x, y = que.popleft()
        
        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and not visited[nx][ny]:
                if maps[nx][ny] != 'X':
                    visited[nx][ny] = True
                    day += int(maps[nx][ny])
                    que.append((nx, ny))
    
    return day


def solution(maps):
    answer = []
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != 'X' and not visited[i][j]:
                answer.append(bfs(i, j, maps, visited))
    
    if answer:
        answer = sorted(answer)
    else:
        answer = [-1]
    
    return answer