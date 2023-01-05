arr = [0] * 10
cnt = 0

for i in range(len(arr)):
    arr[i] = int(input()) % 42

for i in range(len(arr)):
    bool = False
    for j in range(i, len(arr)-1):
        if arr[i] == arr[j+1]:
            bool = True
            break
    if bool == False:
        cnt += 1
print(cnt)