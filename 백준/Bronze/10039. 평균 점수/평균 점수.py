total = 0

for i in range(5):
    num = int(input())
    if num > 40:
        total += num
    else:
        total += 40
print(int(total/5))