stu = int(input())
numbers = list(map(int, input().split()))
order = []

for i in range(stu):
    order.insert(i-numbers[i], i+1)

print(*order)