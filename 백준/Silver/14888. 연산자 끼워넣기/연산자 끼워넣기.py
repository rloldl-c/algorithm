import sys
input = sys.stdin.readline

def exp(cnt):
    if cnt == n-1:
        tmp = number[0]
        for i in range(n-1):
            if order[i] == 0:
                tmp += number[i+1]
            elif order[i] == 1:
                tmp -= number[i+1]
            elif order[i] == 2:
                tmp *= number[i+1]
            else:
                if tmp < 0:
                    tmp = (tmp * (-1) // number[i+1]) * (-1)
                else:
                    tmp //= number[i+1]

        res.append(tmp)
        return

    for i in range(4):
        if oper[i]:
            order.append(i)
            oper[i] -= 1
            exp(cnt+1)
            oper[i] += 1
            order.pop()
            

n = int(input())
number = list(map(int, input().split()))
oper = list(map(int, input().split()))
order = []
res = []

exp(0)

if len(res) == 1:
    print(*res, *res, sep="\n")
else:
    print(max(res))
    print(min(res))