test = int(input())
avg = 0

for i in range(test):
    num = list(map(int, input().split()))
    avg = sum(num) / 10
    print(f"#{i+1} {round(avg)}")