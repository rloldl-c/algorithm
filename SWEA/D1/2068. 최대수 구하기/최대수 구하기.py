test = int(input())

for i in range(test):
    num = list(map(int, input().split()))
    print(f"#{i+1} {max(num)}")