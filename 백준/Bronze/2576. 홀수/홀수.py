total = 0
mini = 100

for i in range(7):
    num = int(input())

    if num % 2 == 1:
        total += num
        mini = min(mini, num)

if total != 0:
    print(total)
    print(mini)
else:
    print(-1)