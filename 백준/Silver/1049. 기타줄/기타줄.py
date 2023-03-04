import sys
input = sys.stdin.readline

n, m = map(int, input().split())
price_6 = [0] * m
price_1 = [0] * m
total = 0

for i in range(m):
    a, b = map(int, input().split())
    price_6[i] = a
    price_1[i] = b

while n > 0:
    if n < 6:
        tmp_1 = min(price_1) * n
        tmp_6 = min(price_6)
        total += min(tmp_1, tmp_6)
        n = 0
    else:    
        tmp_1 = min(price_1) * 6
        tmp_6 = min(price_6)
        total += min(tmp_1, tmp_6)
        n -= 6

print(total)