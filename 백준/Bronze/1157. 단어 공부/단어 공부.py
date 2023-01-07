word = input()
word = word.upper()
alph = {}
max = 0

for char in word:
    if char not in alph:
        alph[char] = 1
    elif char in alph:
        alph[char] += 1

for char in alph:
    if max < alph[char]:
        max = alph[char]
        max_char = char
    elif max == alph[char]:
        max_char = "?"

print(max_char)