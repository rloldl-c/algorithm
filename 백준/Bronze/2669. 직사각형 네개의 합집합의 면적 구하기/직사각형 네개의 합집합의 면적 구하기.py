import sys
input = sys.stdin.readline

ans = 0
arr = [[0 for _ in range(101)] for _ in range(101)]

for _ in range(4):
    numbers = list(map(int, input().split()))

    for i in range(numbers[1], numbers[3]):
        for j in range(numbers[0], numbers[2]):
            arr[i][j] = 1

for i in range(101):
    ans += sum(arr[i])

print(ans)