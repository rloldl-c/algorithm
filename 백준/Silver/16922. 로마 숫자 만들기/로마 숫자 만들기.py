import sys
input = sys.stdin.readline

def roma_num(cnt, start):
    global tmp 

    if cnt == n:
        check[tmp] = 1
        return

    for i in range(start, 4):
        tmp += num[i]
        roma_num(cnt+1, i)
        tmp -= num[i]


n = int(input())
num = [1, 5, 10, 50]
check = [0] * 1001
tmp = 0

roma_num(0, 0)
print(sum(check))