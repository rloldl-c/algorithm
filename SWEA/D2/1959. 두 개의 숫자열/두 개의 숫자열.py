test = int(input())

for i in range(test):
    n, m = map(int, input().split())
    if n < m:
        short_idx = n
        long_idx = m
        short_arr = list(map(int, input().split()))
        long_arr = list(map(int, input().split()))
    else:
        short_idx = m
        long_idx = n
        long_arr = list(map(int, input().split()))
        short_arr = list(map(int, input().split()))

    max_total = 0

    for k in range(long_idx - short_idx + 1):
        total = 0
        for l in range(short_idx):
            total += long_arr[l+k] * short_arr[l]

        max_total = max(max_total, total)

    print(f"#{i+1} {max_total}")