s = input()
ringt = 0
left = 0

for i in range(len(s)):
    l_idx = s.index("(")

    
    if s[i] == "@":
        if i < l_idx:
            left += 1
        else:
            ringt += 1

print(left, ringt)