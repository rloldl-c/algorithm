n = int(input())
arr = list(map(int, input().split()))
key = int(input())
cnt = 0

for i in range(len(arr)):
    if arr[i] == key:
        cnt += 1

print(cnt)