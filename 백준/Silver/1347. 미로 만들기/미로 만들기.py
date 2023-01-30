import sys
input = sys.stdin.readline

n = int(input())
route = input().strip()

# n = 5
# route = "RRFRF"
x = y = 0
tmp = [[0, 0]]
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
now = 0

for char in route:
    if char == "R":
        now += 1
    elif char == "L":
        now += 3
    else:
        x += dx[now % 4]
        y += dy[now % 4]
        tmp.append([x, y])

x_min = min(tmp)[0]
y_min = min(tmp, key=lambda x: x[1])[1]

x_max = max(tmp)[0]
y_max = max(tmp, key=lambda x: x[1])[1]

for val in tmp:
    val[0] += abs(x_min)
    val[1] += abs(y_min)

maze = [[0 for _ in range(y_max-y_min+1)] for _ in range(x_max-x_min+1)]

for val in tmp:
    maze[val[0]][val[1]] = "."

for i in range(x_max-x_min+1):
    for j in range(y_max-y_min+1):
        if maze[i][j] == 0:
            print("#", end ="")
        else:
            print(maze[i][j], end="")

    print()
