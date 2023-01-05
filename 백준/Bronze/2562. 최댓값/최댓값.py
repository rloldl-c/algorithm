arr = [0] * 9
max = 0
index = 0

for i in range(9):
    arr[i] = int(input())
    if max < arr[i]:
        max = arr[i]
        index = i

print(max)
print(index+1)