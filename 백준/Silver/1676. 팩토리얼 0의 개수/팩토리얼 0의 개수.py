import sys
input = sys.stdin.readline

n = int(input())

if n == 0:
    print(0)
else:
    numbers = [0] * (n+1)
    numbers[1] = 1

    for i in range(2, n+1):
        numbers[i] = numbers[i-1] * i

    cnt = 0
    reverse_n = str(numbers[n])[::-1]

    for i in reverse_n:
        if i == "0":
            cnt += 1
        else:
            break

    print(cnt)