import sys
input = sys.stdin.readline

board = input().strip()
res = ''
cnt = 0

for i in range(len(board)):
    if board[i] == 'X':
        cnt += 1
    elif board[i] == '.':
        while cnt != 0:
            if cnt >= 4:
                res += 'AAAA'
                cnt -= 4
            elif cnt >= 2:
                res += 'BB'
                cnt -= 2
            else:
                res = '-1'
                break

        res += '.'
        cnt = 0

    if '-1' in res:
        res = '-1'
        cnt = 0
        break

while cnt != 0:
    if cnt >= 4:
        res += 'AAAA'
        cnt -= 4
    elif cnt >= 2:
        res += 'BB'
        cnt -= 2
    else:
        res = '-1'
        break

print(res)
