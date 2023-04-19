import sys
input = sys.stdin.readline

def backtracking(cnt):
    if cnt == n:
        sum_ = 0
        for i in range(n-1):
            sum_ += abs(tmp[i] - tmp[i+1])

        ans.append(sum_)
        return 
    
    for i in range(n):
        if not visited[i]:
            tmp.append(num[i])
            visited[i] = True
            backtracking(cnt+1)
            tmp.pop()
            visited[i] = False


n = int(input())
num = list(map(int, input().split()))
visited = [False] * n
tmp = []
ans = []

backtracking(0)
print(max(ans))