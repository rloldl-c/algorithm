import sys
input = sys.stdin.readline

a = int(input())
b = int(input())
c = int(input())
total = a + b + c

if total == 180:
    if a == b == c:
        print("Equilateral")
    elif a == b or a == c or b == c:
        print("Isosceles")
    else:
        print("Scalene")
else:
    print("Error")