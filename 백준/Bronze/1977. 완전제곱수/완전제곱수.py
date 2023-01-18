num1 = int(input())
num2 = int(input())
total = 0
mini = num2

n1 = int(num1**0.5)
n2 = int(num2**0.5)

for i in range(n1, n2+1):
    if num1 <= i**2 and num2 >= i**2:
        total += i**2
        mini = min(mini, i**2)

if total == 0:
    print(-1)
else:
    print(total, mini)