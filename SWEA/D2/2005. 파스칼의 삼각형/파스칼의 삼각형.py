test = int(input())

for m in range(test):
    num = int(input())
    tri = [[0 for j in range(i+1)] for i in range(num)]
    tri[0][0] = 1
    
    for i in range(1, num):
        for j in range(i+1):
            if i == 1:
                tri[i][j] = 1
            elif j == 0 or j == i:
                tri[i][j] = 1
            else:
                tri[i][j] = tri[i-1][j-1] + tri[i-1][j]

    print(f"#{m+1}")
    for j in range(num):
        print(*tri[j])