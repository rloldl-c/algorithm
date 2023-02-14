for t in range(10):
    n = int(input())
    arr = [input().strip() for _ in range(8)]
    cnt = 0

    for i in range(8):
        for j in range(8-n+1):
            if arr[i][j] == arr[i][j+n-1]:
                for k in range(1, n//2):
                    if arr[i][j+k] != arr[i][j+n-1-k]:
                        break
                else:
                    # print(i, arr[i][j], arr[i][j+n-1])
                    cnt += 1

        for j in range(8-n+1):
            if arr[j][i] == arr[j+n-1][i]:
                for k in range(1, n//2):
                    if arr[j+k][i] != arr[j+n-1-k][i]:
                        break
                else:
                    cnt += 1

    print(f"#{t+1} {cnt}")