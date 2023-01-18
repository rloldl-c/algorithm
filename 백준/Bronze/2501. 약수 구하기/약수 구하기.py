num, k = map(int, input().split())
cnt = 0

for i in range(1, num+1):
    if num % i == 0:
        cnt += 1
    
    if cnt == k:
        break

if cnt < k:
    print(0)
else:
    print(i)