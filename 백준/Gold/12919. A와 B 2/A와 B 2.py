import sys
input = sys.stdin.readline

def game(s):
    global zero

    if len(s) == len(S):
        if s == S:
            zero = True
        return
    
    if s[0] == 'B':
        tmp = s[::-1]
        tmp = tmp[:-1]
        game(tmp)

    if s[-1] == 'A':
        tmp = s[:-1]
        game(tmp)


S = input().strip()
T = input().strip()
zero = False
game(T)

if zero:
    print(1)
else:
    print(0)