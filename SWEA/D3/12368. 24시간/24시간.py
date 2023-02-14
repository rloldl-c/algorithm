test = int(input())

for i in range(test):
    a, b = map(int, input().split())
    ans = (a + b) % 24
    print(f"#{i+1} {ans}")