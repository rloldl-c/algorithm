import sys

s = sys.stdin.readline()

for i in range(len(s)):
    index = ord(s[i])

    if 65 <= index <= 90:
        if index > 77:
            index -= 26

        print(chr(index+13), end="")
    elif 97 <= index <= 122:
        if index > 109:
            index -= 26

        print(chr(index+13), end="")

    else:
        print(s[i], end="")
