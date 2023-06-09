import sys
input = sys.stdin.readline

def sum_num(num):
    tmp = 0
    for i in num:
        if i in '0123456789':
            tmp += int(i)

    return tmp


n = int(input())
numbers = [input().strip() for _ in range(n)]

numbers = sorted(numbers, key=lambda x:(len(x), sum_num(x), x))

print('\n'.join(numbers))