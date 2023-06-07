import sys
input = sys.stdin.readline

n = int(input())
cnt = 0

for i in range(n):
    word = input().strip()
    check = []
    is_group = True

    for j in range(len(word)):
        if word[j] not in check:
            check.append(word[j])
        else:
            if word[j] == word[j-1]:
                continue
            else:
                is_group = False
                break

    if is_group:
        cnt += 1

print(cnt)
        