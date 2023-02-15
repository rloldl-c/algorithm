import sys
input = sys.stdin.readline

def check():
    max_x = 0
    for i in range(n):
        x_cnt = 1
        for j in range(n-1):
            if candy[i][j] == candy[i][j+1]:
                x_cnt += 1
            else:
                x_cnt = 1
            max_x = max(max_x, x_cnt)

    max_y = 0
    for i in range(n):
        y_cnt = 1
        for j in range(n-1):
            if candy[j][i] == candy[j+1][i]:
                y_cnt += 1
            else:
                y_cnt = 1

            max_y = max(max_y, y_cnt)

    tmp_cnt = max(max_x, max_y)
    return tmp_cnt


n = int(input())
candy = []
res = 0
cnt = 0

for _ in range(n):
    candy.append(list(input().strip()))

cnt = check()
res = max(cnt, res)

for i in range(n):
    for j in range(n-1):
        if candy[i][j] != candy[i][j+1]:
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]
            cnt = check()
            res = max(cnt, res)
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]

for i in range(n):
    for j in range(n-1):
        if candy[j][i] != candy[j+1][i]:
            candy[j][i], candy[j+1][i] = candy[j+1][i], candy[j][i]
            cnt = check()
            res = max(cnt, res)
            candy[j][i], candy[j+1][i] = candy[j+1][i], candy[j][i]

print(res)