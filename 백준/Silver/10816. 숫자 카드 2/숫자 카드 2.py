import sys

input = sys.stdin.readline

num = int(input())
sk_cards = list(map(int, input().split()))
num2 = int(input())
cards = list(map(int, input().split()))
sk_dict = {}

for card in sk_cards:
    if card not in sk_dict:
        sk_dict[card] = 1
    else:
        sk_dict[card] += 1

for card in cards:
    print(sk_dict.get(card, 0), end=" ")
