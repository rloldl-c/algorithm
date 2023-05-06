import sys
input = sys.stdin.readline

c, p = map(int, input().split())
field = list(map(int, input().split())) + [0] * 4
cnt = 0

for i in range(c):
    if p == 1:
        # 0도
        cnt += 1
        # 90도
        if i+3 < c and field[i] == field[i+1] == field[i+2] == field[i+3]:
            cnt +=1
    
    elif p == 2:
        if i+1 < c and field[i] == field[i+1]:
            cnt += 1

    elif p == 3:
        # 0도
        if i+2 < c and field[i] == field[i+1] == field[i+2] - 1:
            cnt += 1
        # 90도
        if i+1 < c and field[i] - 1 == field[i+1]:
            cnt += 1

    elif p == 4:
        # 0도
        if i+2 < c and field[i] - 1 == field[i+1] == field[i+2]:
            cnt += 1
        # 90도
        if i+1 < c and field[i] == field[i+1] - 1:
            cnt += 1

    elif p == 5:
        # 0도
        if i+2 < c and field[i] == field[i+1] == field[i+2]:
            cnt += 1
        # 90도
        if i+1 < c and field[i] == field[i+1] - 1:
            cnt += 1
        # 180도
        if i+2 < c and field[i] - 1 == field[i+1] == field[i+2] - 1:
            cnt += 1
        # 270도
        if i+1 < c and field[i] - 1 == field[i+1]:
            cnt += 1

    elif p == 6:
        # 0도
        if i+2 < c and field[i] == field[i+1] == field[i+2]:
            cnt += 1
        # 90도
        if i+1 < c and field[i] == field[i+1]:
            cnt += 1
        # 180도
        if i+2 < c and field[i] == field[i+1] - 1 == field[i+2] - 1:
            cnt += 1
        # 270도
        if i+1 < c and field[i] - 2 == field[i+1]:
            cnt += 1

    else:
        # 0도
        if i+2 < c and field[i] == field[i+1] == field[i+2]:
            cnt += 1
        # 90도
        if i+1 < c and field[i] == field[i+1] - 2:
            cnt += 1
        # 180도
        if i+2 < c and field[i] - 1 == field[i+1] - 1 == field[i+2]:
            cnt += 1
        # 270도
        if i+1 < c and field[i] == field[i+1]:
            cnt += 1

print(cnt)