import sys
input = sys.stdin.readline

string = []

max_len = 0

for _ in range(5):
    s = input().strip()
    string.append(s)
    max_len = max(max_len, len(s))

for i in range(max_len):
    for j in range(5):
        if i <len(string[j]):
            print(string[j][i], end="")