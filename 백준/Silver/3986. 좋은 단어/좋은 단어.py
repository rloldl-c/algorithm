import sys

input = sys.stdin.readline

num = int(input())
cnt = 0

for i in range(num):
    word = input().strip()
    words = []

    for ch in word:
        if len(words) != 0:
            a = words[-1]
            if a == ch:
                words.pop()
            else:
                words.append(ch)
        else:
            words.append(ch)
    
    if len(words) == 0:
        cnt += 1

print(cnt)