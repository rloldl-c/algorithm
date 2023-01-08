import sys

test = int(input())
cnt = 0

for i in range(test):
    word = sys.stdin.readline().strip()
    check = False
    char = {}
    for j in range(len(word)):
        if word[j] not in char:
            check = True
            char[word[j]] = 1
        else:
            check = False
            if j-1 > -1:
                if word[j-1] == word[j]:
                    check = True
                else:
                    break
        
    if check == True:
        cnt += 1

print(cnt)