import sys
input = sys.stdin.readline

p, m = map(int, input().split())
player = []
game = []

for _ in range(p):
    a, b = input().split()
    player.append((int(a), b))

for lv, name in player:
    flag = False

    for i in range(len(game)):
        if len(game[i][1]) == m:
            continue

        if not flag and game[i][0] - 10 <= lv and game[i][0] + 10 >= lv:
            flag = True
            game[i][1].append((lv, name))

    if not flag:
        game.append([lv, [(lv, name)]])

for i in range(len(game)):
    if len(game[i][1]) == m:
        print('Started!')
    else:
        print('Waiting!')

    tmp = sorted(game[i][1], key=lambda x: x[1])
    for j in range(len(tmp)):
        print(*tmp[j])