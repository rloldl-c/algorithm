import sys
input = sys.stdin.readline

def recursion(cnt):
    if cnt == (n+1):
        flag = True
        for i in range(n):
            if sign[i] == '<' and tmp[i] > tmp[i+1]:
                flag = False
                break
            if sign[i] == '>' and tmp[i] < tmp[i+1]:
                flag = False
                break
        
        if flag:
            if ans[0] == 0:
                ans[0] = ''.join(map(str, tmp))
            else:
                ans[1] = ''.join(map(str, tmp))
        return

    for i in range(10):
        if i not in tmp:
            tmp.append(i)
            recursion(cnt+1)
            tmp.pop()


n = int(input())
sign = list(input().split())
num = [i for i in range(0, 10)]
tmp = []
ans = [0, 0]
recursion(0)
print(ans[1])
print(ans[0])