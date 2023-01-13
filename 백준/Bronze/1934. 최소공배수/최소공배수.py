test = int(input())

for i in range(test):
    a, b = map(int, input().split())
    num1 = max(a, b)
    num2 = min(a, b)
    mod = 1

    while True:
        if mod == 0:
            break

        mod = num1 % num2
        num1 = num2
        num2 = mod

    print(a * b // num1)