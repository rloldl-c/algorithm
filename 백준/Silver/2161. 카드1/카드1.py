import sys
input = sys.stdin.readline

num = int(input())
card = [i for i in range(1, num+1)]
res = []

while len(card) != 1:
    res.append(card.pop(0))
    tmp = card.pop(0)
    card.append(tmp)

print(*res, *card)