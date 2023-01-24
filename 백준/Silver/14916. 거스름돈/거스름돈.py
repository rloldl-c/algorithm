import sys
input = sys.stdin.readline

money = int(input())
cnt_2 = 0
cnt_5 = 0

while True:
    if money == 0 or money == 1 or money == 3:
        break

    if money % 5 == 0:
        money -= 5
        cnt_5 += 1
    else:
        money -= 2
        cnt_2 += 1


if money != 0:
    print(-1)
else:
    print(cnt_2 + cnt_5)