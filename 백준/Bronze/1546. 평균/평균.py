test = int(input())
arr = list(map(int, input().split()))
max = 0
sum = 0

for i in range(test):
    if max < arr[i]:
        max = arr[i]

for i in range(test):
    arr[i] = arr[i] / max * 100
    sum += arr[i]

print(sum/test)