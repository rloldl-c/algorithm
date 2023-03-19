import sys
input = sys.stdin.readline

def recursion(cnt):
    global ans 

    if cnt == n:
        total = 500

        for i in tmp:
            total += weight[i] - k
            if total < 500:
                break

        if total >= 500:
            ans += 1
        
        return
    
    for i in range(n):
        if i not in tmp:
            tmp.append(i)
            recursion(cnt+1)
            tmp.pop()


n, k = map(int, input().split())
weight = list(map(int, input().split()))
tmp = []
ans = 0

recursion(0)

print(ans)