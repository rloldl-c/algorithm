import sys
from collections import deque
input = sys.stdin.readline

gear = [deque(list(map(int, input().strip()))) for _ in range(4)]
n = int(input())

for _ in range(n):
    num, d = map(int ,input().split())
    num -= 1
    # 초기 톱니 상태
    left = gear[num][6]
    right = gear[num][2]
    gear[num].rotate(d)

    now = d # 회전 방향
    # 왼쪽 톱니
    for i in range(num-1, -1, -1):
        if gear[i][2] != left: # 인접한 톱니 바퀴와 다른 극
            left = gear[i][6]
            gear[i].rotate(now * -1)
            now *= -1 # 방향 바꿔주기
        else:
            break

    now = d # 회전 방향
    # 오른쪽 톱니
    for i in range(num+1, 4):
        if gear[i][6] != right:
            right = gear[i][2]
            gear[i].rotate(now * -1)
            now *= -1
        else:
            break

ans = 0
for i in range(4):
    if gear[i][0] == 1:
        ans += (2 ** i)

print(ans)