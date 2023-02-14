test = int(input())

for t in range(test):
    n = int(input())
    farm = [0 for _ in range(n)]
    total = 0

    for i in range(n):
        farm[i] = input().strip()

    for i in range(n//2+1):
        for j in range(n//2-i, n//2+i+1):
            if i == n//2:
                total += int(farm[i][j])
            else:
                total += int(farm[i][j])
                total += int(farm[-i-1][j])

    print(f"#{t+1} {total}")
