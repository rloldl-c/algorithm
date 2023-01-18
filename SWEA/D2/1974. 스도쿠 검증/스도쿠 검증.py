test = int(input())

for i in range(test):
    sudoku = [0 for j in range(9)]
    is_correct = True

    for j in range(9):
        sudoku[j] = list(map(int, input().split()))

    for n in range(9):
        check = [0 for j in range(9)]

        for m in range(9):
            check[sudoku[n][m]-1] = 1
        
        for j in range(9):
            if check[j] == 0:
                is_correct = False
                break
        
    for n in range(9):
        check = [0 for j in range(9)]

        for m in range(9):
            check[sudoku[m][n]-1] = 1
        
        for j in range(9):
            if check[j] == 0:
                is_correct = False
                break
        
    for n in range(3):
        n *= 3
        check = [0 for j in range(9)]

        for m in range(3):
            m *= 3
            for k in range(3):
                for l in range(3):
                    check[sudoku[m+k][n+l]-1] = 1

            for j in range(9):
                if check[j] == 0:
                    is_correct = False
                    break

    if is_correct:
        print(f"#{i+1} 1")
    else:
        print(f"#{i+1} 0")