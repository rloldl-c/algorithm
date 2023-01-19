s = input()
start = 0
end = len(s) - 1
res = True

while True:
    if s[start] != s[end]:
        res = False
        break

    start += 1
    end -= 1

    if start > end:
        break

print(1 if res else 0)