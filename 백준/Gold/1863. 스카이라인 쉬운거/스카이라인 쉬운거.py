import sys, copy
input = sys.stdin.readline

n = int(input())
building = list()
cnt = 0

for i in range(n + 1):
    if i == n:
        y = 0
    else:
        x, y = map(int, input().split())

    if not building:
        building.append(y)

    # 현재 빌딩 높이보다 다음 빌딩 높이가 낮으면
    elif building[-1] > y:
        while building:
            if building[-1] > y:
                cnt += 1
                building.pop()
            else:
                break
        
        if y != 0 and y not in building:
            building.append(y)

    # 현재 빌딩 높이보다 다음 빌딩 높이가 높으면
    elif building[-1] < y:
        building.append(y)

print(cnt)

