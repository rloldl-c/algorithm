import sys

num1, num2 = map(int, sys.stdin.readline().split())
a = max(num1, num2)
b = min(num1, num2)
div = 1

while True:
    if div == 0:
        break

    div = a % b
    a = max(b, div)
    b = min(b, div)
    
print(a)
print(num1*num2//a)
