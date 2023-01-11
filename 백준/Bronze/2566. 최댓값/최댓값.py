arr = []

for i in range(9):
    arr.append(list(map(int, input().split())))

maxi = 0

for i in range(9):
    for j in range(9):
        if maxi <= arr[i][j]:
            maxi = arr[i][j]
            col = i
            row = j

print(maxi)
print(col+1, row+1)