word = input()

alph = [-1] * 26

for i in range(len(word)):
    if alph[ord(word[i])-97] == -1:
        alph[ord(word[i])-97] = i

print(*alph)