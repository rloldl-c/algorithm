def dfs(x, y, is_construct, distance):
    global cnt
    
    if distance > cnt:
        cnt = distance

    visited[x][y] = True

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
            continue

        if path[nx][ny] < path[x][y]:
            visited[nx][ny] = True
            dfs(nx, ny, is_construct, distance+1)
            visited[nx][ny] = False

        elif path[nx][ny] >= path[x][y] and not is_construct:
            for k in range(1, K+1):
                path[nx][ny] -= k
                is_construct = True

                if path[nx][ny] < path[x][y]:
                    visited[nx][ny] = True
                    dfs(nx, ny, is_construct, distance+1)
                    visited[nx][ny] = False

                path[nx][ny] += k
                is_construct = False


test = int(input())
for t in range(test):

    N, K = map(int, input().split())
    path = []
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    cnt = 0


    for _ in range(N):
        path.append(list(map(int, input().split())))

    max_h = max(map(max, path))

    for i in range(N):
        for j in range(N):
            if path[i][j] == max_h:
                visited = [[False] * N for _ in range(N)]
                dfs(i, j, False, 1)

    print(f"#{t+1} {cnt}")