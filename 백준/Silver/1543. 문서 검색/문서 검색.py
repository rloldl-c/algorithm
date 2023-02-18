import sys
input = sys.stdin.readline

s = input().strip()
word = input().strip()
n = len(word)
idx = 0
cnt = 0

while idx < len(s)-n+1:
    if s[idx:idx+n] == word:
        cnt += 1
        idx += n
    else:
        idx += 1

print(cnt)