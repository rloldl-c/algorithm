test = int(input())

for i in range(test):
    arr = list(input())
    cnt = 0
    sum = 0
    for j in range(len(arr)):
        if arr[j] == "O":
            cnt += 1
            sum += cnt
        else:
            cnt = 0
    print(sum)