test = int(input())

for i in range(test):
    money = int(input())
    
    print(f"#{i+1}")

    if money >= 50000:
        print(money//50000, end=" ")
        money %= 50000
    else:
        print(0, end=" ")
    
    if money >= 10000:
        print(money//10000, end=" ")
        money %= 10000
    else:
        print(0, end=" ")
    
    if money >= 5000:
        print(money//5000, end=" ")
        money %= 5000
    else:
        print(0, end=" ")
    
    if money >= 1000:
        print(money//1000, end=" ")
        money %= 1000
    else:
        print(0, end=" ")
    
    if money >= 500:
        print(money//500, end=" ")
        money %= 500
    else:
        print(0, end=" ")
    
    if money >= 100:
        print(money//100, end=" ")
        money %= 100
    else:
        print(0, end=" ")
    
    if money >= 50:
        print(money//50, end=" ")
        money %= 50
    else:
        print(0, end=" ")

    if money >= 10:
        print(money//10, end=" ")
        money %= 10
    else:
        print(0, end=" ")
    
    print()
