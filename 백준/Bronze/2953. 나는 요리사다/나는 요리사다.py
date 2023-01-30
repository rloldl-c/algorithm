import sys
input = sys.stdin.readline

winner = 0
winner_score = 0

for i in range(5):
    total = sum(list(map(int, input().split())))
    if total > winner_score:
        winner = i
        winner_score = total

print(winner+1, winner_score)