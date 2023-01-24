test = int(input())

for i in range(test):
    p, q, r, s, w = map(int, input().split())

    a = p * w

    if r >= w:
        b = q
    else:
        b = q + s * (w - r)

    print(f"#{i+1} {min(a, b)}")