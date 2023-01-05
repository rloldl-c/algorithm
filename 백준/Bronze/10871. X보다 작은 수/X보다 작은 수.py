n, min = map(int, input().split())
arr = list(map(int, input().split()))
cnt = 0

for i in range(len(arr)):
    if arr[i] < min:
        print(arr[i], end=" ")