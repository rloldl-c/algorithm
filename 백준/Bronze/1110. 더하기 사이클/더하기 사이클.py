num = int(input())
new = num
cnt = 0

while True:
    new = (new % 10) * 10 + (((new // 10) + (new % 10)) % 10)
    cnt += 1
    if new == num:
        break

print(cnt)