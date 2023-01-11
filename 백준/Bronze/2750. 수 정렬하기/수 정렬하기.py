test = int(input())
numbers = []

for i in range(test):
    n = int(input())
    numbers.append(n)

for i in range(test):
    mini = max(numbers)
    for j in range(i, test):
        if mini >= numbers[j]:
            mini = numbers[j]
            index = j
    
    tmp = numbers[i]
    numbers[i] = numbers[index]
    numbers[index] = tmp
    
for i in range(test):
    print(numbers[i])