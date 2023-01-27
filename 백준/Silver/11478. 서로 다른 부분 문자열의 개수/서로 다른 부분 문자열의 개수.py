import sys
input = sys.stdin.readline

string = input().strip()
part = {}

for i in range(len(string)):
    for j in range(len(string)):
        if i + j < len(string) + 1:
            part[string[j:j+i]] = 1

print(len(part))