import sys
input = sys.stdin.readline

string = ["" for i in range(5)]
max_len = 0
res = ""

for i in range(5):
    string[i] = input().strip()
    max_len = max(max_len, len(string[i]))

for i in range(max_len):
    for j in range(5):
        if i < len(string[j]):
            res += string[j][i]

print(res)