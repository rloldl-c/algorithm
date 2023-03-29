import sys
from itertools import permutations
input = sys.stdin.readline

def check(left, right, sign):
    if sign == '<':
        return left < right
    else:
        return left > right

def recursion(cnt):
    if cnt == (n+1):
        if ans[0] == 0:
            ans[0] = ''.join(map(str, tmp))
        else:
            ans[1] = ''.join(map(str, tmp))
        return

    for i in range(10):
        if visited[i] == False:
            if (cnt==0 or check(tmp[-1], i, sign[cnt-1])):
                visited[i] = True
                tmp.append(i)
                recursion(cnt+1)
                visited[i] = False
                tmp.pop()


n = int(input())
sign = list(input().split())
visited = [False] * 10
tmp = []
ans = [0, 0]
recursion(0)
print(ans[1])
print(ans[0])