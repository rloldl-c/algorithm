num1 = int(input())
num2 = int(input())

num1 = num1//100 * 100

while True:
    if num1 % num2 == 0:
        break
    
    num1 += 1

print(str(num1)[-2:])