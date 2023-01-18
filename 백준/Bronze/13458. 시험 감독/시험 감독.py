site = int(input())
person = list(map(int, input().split()))
first, second = map(int, input().split())
total = 0

for num in person:
    if num - first <= 0:
        continue
    elif num - first < second:
        total += 1
    elif (num - first) % second == 0:
        total += (num - first) // second 
    else:
        total += (num - first) // second + 1

print(total + site)