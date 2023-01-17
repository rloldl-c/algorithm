test = int(input())

for i in range(test):
    n, m = map(int, input().split())
    flies = [0 for a in range(n)]
    for j in range(n):
        flies[j] = list(map(int, input().split()))
    
    max_f = 0
    total = 0

    for a in range(n-m+1):
        for b in range(n-m+1):
            for c in range(m):
                for d in range(m):
                    total += flies[a+c][b+d]
        
            max_f = max(max_f, total)
            total = 0

    print(f"#{i+1} {max_f}")