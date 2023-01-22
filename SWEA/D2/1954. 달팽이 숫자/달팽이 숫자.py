test = int(input())

for i in range(test):
    n = int(input())
    arr = [[0]*n for l in range(n)]
    row = [0, 1, 0, -1]
    col = [1, 0, -1, 0]
    row_idx = 0
    col_idx = 0
    idx = 0

    for k in range(1, n*n+1):
        arr[row_idx][col_idx] = k
        row_idx += row[idx]
        col_idx += col[idx]

        if row_idx < 0 or col_idx < 0 or row_idx >= n or col_idx >= n or arr[row_idx][col_idx] != 0:
            row_idx -= row[idx]
            col_idx -= col[idx]
            idx = (idx + 1) % 4

            row_idx += row[idx]
            col_idx += col[idx]
            
    print(f"#{i+1}")
    for j in range(n):
        print(*arr[j])