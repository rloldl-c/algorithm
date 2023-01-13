while True:
    num1, num2 = map(int, input().split())
    if num1 + num2 == 0:
        break

    print("Yes" if num1 > num2 else "No")