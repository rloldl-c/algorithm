import sys
input = sys.stdin.readline

def zero(cnt):
    if cnt == n-1:
        s = '1'
        for i in range(n-1):
            s = s + lst[i]
            s = s + num[i+1]

        if eval(s) == 0:
            for i in range(n-1):
                print(i+1, end='')
                if lst[i] == '':
                    print(' ', end='')
                else:
                    print(lst[i], end='')
            print(n)

        return
        

    for i in range(3):
        lst.append(oper[i])
        zero(cnt+1)
        lst.pop()


test = int(input())
oper = ['', '+', '-']

for _ in range(test):
    n = int(input())
    num = [str(i) for i in range(1, n+1)]
    lst = []
    zero(0)
    print()