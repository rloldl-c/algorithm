numbers = []

for i in range(5):
    numbers.append(int(input()))

numbers = sorted(numbers)

print(int(sum(numbers)/5))
print(numbers[2])