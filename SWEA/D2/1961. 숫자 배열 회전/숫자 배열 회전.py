test = int(input())

for i in range(test):
    n = int(input())
    arr = [0 for j in range(n)]

    for j in range(n):
        arr[j] = list(map(int, input().split()))

    arr_90 = [[0 for k in range(n)] for j in range(n)]
    arr_180 = [[0 for k in range(n)] for j in range(n)]
    arr_270 = [[0 for k in range(n)] for j in range(n)]

    for k in range(n):
        for l in range(n):
            arr_90[k][l] = arr[n-1-l][k]

    for k in range(n):
        for l in range(n):
            arr_180[k][l] = arr_90[n-1-l][k]

    for k in range(n):
        for l in range(n):
            arr_270[k][l] = arr_180[n-1-l][k]

    print(f"#{i+1}")
    for k in range(n):
        for l in range(n):
            print(arr_90[k][l], end="")
        print(end=" ")
        for l in range(n):
            print(arr_180[k][l], end="")
        print(end=" ")
        for l in range(n):
            print(arr_270[k][l], end="")
        print()    
