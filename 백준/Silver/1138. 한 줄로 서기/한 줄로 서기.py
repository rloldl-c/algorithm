import sys
input = sys.stdin.readline

n = int(input())
ans = [0] * (n+1)
order = [0] + list(map(int, input().split()))

for i in range(1, n+1):
    cnt = order[i]
    idx = 1

    while cnt > -1:
        if cnt == 0:
            if ans[idx] == 0:
                ans[idx] = i
                break

        if ans[idx] == 0 or ans[idx] > i:
            cnt -= 1
        
        idx += 1

print(' '.join(map(str, ans[1:])))