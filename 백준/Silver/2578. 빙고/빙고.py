import sys
input = sys.stdin.readline

bingo = [list(map(int, input().split())) for _ in range(5)]
host = [list(map(int, input().split())) for _ in range(5)]
board = {}
check = [[0] * 5 for _ in range(5)]
n = 0
breaker = False

for i in range(5):
    for j in range(5):
        board[bingo[i][j]] = (i, j)

for i in range(5):
    for j in range(5):
        r, c = board[host[i][j]]
        check[r][c] = 1
        n += 1

        if n > 11:
            res = 0
            for a in range(5):
                if sum(check[a]) == 5:
                    res += 1

            for a in range(5):
                cnt = 0
                for b in range(5):
                    if check[b][a] == 1:
                        cnt += 1

                if cnt == 5:
                    res += 1

            cnt = 0
            for a in range(5):
                if check[a][5-a-1] == 1:
                    cnt += 1

                if cnt == 5:
                    res += 1

            cnt = 0
            for a in range(5):
                if check[a][a] == 1:
                    cnt += 1

                if cnt == 5:
                    res += 1

            if res > 2:
                print(n)
                breaker = True
                break

    if breaker:
        break