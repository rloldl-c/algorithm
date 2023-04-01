import sys
input = sys.stdin.readline

n = int(input())
left = list(map(int, input().split()))
ans = [0] * n
ans[left[0]] = 1

for i in range(1, n):
    cnt = 0
    
    for j in range(n):
        if left[i] == 0 and ans[j] == 0:
            ans[j] = i+1
            break
        
        else:
            if cnt == left[i] and ans[j] == 0:
                ans[j] = i+1
                break

            if ans[j] == 0:
                cnt += 1

print(*ans)