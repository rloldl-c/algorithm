a = int(input())
b = int(input())
c = int(input())
num = a * b * c
numbers = [0 for i in range(10)]

while num > 0:
    n = num % 10
    numbers[n] += 1
    num //= 10

for i in range(10):
    print(numbers[i])