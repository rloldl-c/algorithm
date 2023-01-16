import sys

num = int(sys.stdin.readline().strip())
a = 0
b = 1
fibo = a + b

for i in range(2, num):
    a = b
    b = fibo
    fibo = a + b

print(fibo)