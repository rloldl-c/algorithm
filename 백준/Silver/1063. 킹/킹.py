import sys
input = sys.stdin.readline

delta = {
    "R": (0, 1),
    "L": (0, -1),
    "B": (-1, 0),
    "T": (1, 0),
    "RT": (1, 1),
    "LT": (1, -1),
    "RB": (-1, 1),
    "LB": (-1, -1)
}

king, stone, n = input().split()
board = [[0] * 9 for _ in range(9)]
king_r = int(king[1])
king_c = ord(king[0]) - 64
stone_r = int(stone[1])
stone_c = ord(stone[0]) - 64

for _ in range(int(n)):
    move = delta[input().strip()]

    if 0 < king_r + move[0] < 9 and 0 < king_c + move[1] < 9:
        king_r += move[0]
        king_c += move[1]

    if king_r == stone_r and king_c == stone_c:
        if 0 < stone_r + move[0] < 9 and 0 < stone_c + move[1] < 9:
            stone_r += move[0]
            stone_c += move[1]
        else:
            king_r -= move[0]
            king_c -= move[1]
        
print(chr(king_c+64)+str(king_r))
print(chr(stone_c+64)+str(stone_r))