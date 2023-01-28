import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))
numbers = sorted(numbers)
m = int(input())
search = list(map(int, input().split()))

for i in range(m):
    s = 0
    e = len(numbers) - 1

    while True:
        if s > e:
            print(0)
            break

        mid = (s + e) // 2

        if numbers[mid] == search[i]:
            print(1)
            break
        elif numbers[mid] > search[i]:
            e = mid - 1
        else:
            s = mid + 1