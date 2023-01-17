test = int(input())

for i in range(test):
    num = int(input())
    numbers = list(map(int, input().split()))
    print(sum(numbers))