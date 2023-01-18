numbers = [0 for i in range(10)]
res = 0

for i in range(10):
    numbers[i] = int(input())

total = numbers[0]

for i in range(1, 10):
    total += numbers[i]

    if total >= 100:
        if total == 100:
            res = total
        elif total - 100 == abs(total - numbers[i] - 100):
            res = max(total, total-numbers[i])
        elif total - 100 > abs(total-numbers[i] - 100):
            res = total-numbers[i]
        else:
            res = total
        break
    else:
        res = total

print(res)