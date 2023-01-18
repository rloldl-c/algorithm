test = int(input())

for i in range(test):
    num = int(input())
    numbers = list(map(int, input().split()))
    numbers.sort()

    print(f"#{i+1}", end=" ")
    print(*numbers)