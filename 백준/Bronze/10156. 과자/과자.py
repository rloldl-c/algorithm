price, num, money = map(int, input().split())

if money >= price * num:
    print(0)
else:
    print(price * num - money)