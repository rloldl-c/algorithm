word = input()
ans = 0

for char in word:
    if ord(char) < 68:
        ans += 3
    elif ord(char) < 71:
        ans += 4
    elif ord(char) < 74:
        ans += 5
    elif ord(char) < 77:
        ans += 6
    elif ord(char) < 80:
        ans += 7
    elif ord(char) < 84:
        ans += 8
    elif ord(char) < 87:
        ans += 9
    else:
        ans += 10

print(ans)