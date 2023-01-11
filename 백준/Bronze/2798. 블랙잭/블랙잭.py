num, m = map(int, input().split())
cards = list(map(int, input().split()))
maxi = 0

for i in range(num):
    for j in range(i+1, num):
        for k in range(j+1, num):
            total = cards[i] + cards[j] + cards[k]
            if total <= m:
                maxi = max(total, maxi)

print(maxi)