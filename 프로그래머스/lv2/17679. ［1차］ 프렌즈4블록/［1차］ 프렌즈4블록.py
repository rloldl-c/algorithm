def check(x, y, board, block):
    for i in range(x, x+2):
        for j in range(y, y+2):
            if board[i][j] != block:
                return False
    
    return True


def solution(m, n, board):
    answer = 0
    board = [list(board[i]) for i in range(m)]
    while True:
        tmp = set()
        for i in range(m):
            for j in range(n):
                if board[i][j] != 0 and i+1 < m and j+1 < n:
                    flag = check(i, j, board, board[i][j])

                    if flag:
                        tmp.add((i, j))
                        tmp.add((i+1, j))
                        tmp.add((i, j+1))
                        tmp.add((i+1, j+1))

        if not tmp:
            return answer

        answer += len(tmp)

        for i in range(n):
            next_board = []
            for j in reversed(range(m)):

                if (j, i) in tmp:
                    continue

                next_board.append(board[j][i])

            if len(next_board) < m:
                for _ in range(m - len(next_board)):
                    next_board.append(0)

            for j in range(m):
                board[j][i] = next_board.pop()
