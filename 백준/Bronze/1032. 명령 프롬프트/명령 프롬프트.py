test = int(input())
s = list(input())
len_s = len(s)

for i in range(test-1):
    s1 = input()
    for j in range(len_s):
        if s[j] != s1[j]:
            s[j] = "?"

print("".join(s))