import sys
input = sys.stdin.readline

def contest(idx, time, size):
    global ans

    if time > m:
        return

    ans = max(ans, size)
    
    if idx+1 < n:
        contest(idx+1, time+1, size+snow[idx+1])
    else:
        return

    if idx+2 < n:
        contest(idx+2, time+1, size//2+snow[idx+2])
    else:
        return



n, m = map(int, input().split())
snow = list(map(int, input().split()))
ans = 0

contest(-1, 0, 1)

print(ans)