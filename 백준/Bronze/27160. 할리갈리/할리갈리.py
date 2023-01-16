import sys

num = int(sys.stdin.readline().strip())
cards = {}
res = 0

for i in range(num):
    fruit, n = sys.stdin.readline().split()

    if fruit not in cards:
        cards[fruit] = int(n)
    else:
        cards[fruit] += int(n)

for card in cards:
    if cards[card] == 5:
        res = "YES"
        break
    else:
        res = "NO"

print(res)