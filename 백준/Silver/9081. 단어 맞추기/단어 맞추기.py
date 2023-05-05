import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    word = list(input().strip())
    flag = True # 마지막 단어면 True, 아니면 False
    idx = 0
    ans = ''

    for i in range(len(word)-1, 0, -1):
        if word[i] > word[i-1]:
            idx = i # 바뀌기 시작하는 위치
            flag = False
            break

    if flag:
        print(''.join(word))
        continue


    min_char = max(word)
    for i in range(idx-1, len(word)):
        if word[i] > word[idx-1]:
            min_char = min(min_char, word[i])
            min_idx = i

    word[idx-1], word[min_idx] = word[min_idx], word[idx-1]
    ans = word[:idx] + sorted(word[idx:])
    print(''.join(ans))