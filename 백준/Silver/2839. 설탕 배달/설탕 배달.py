num = int(input())

cnt = 0

if num % 5 == 0:
    cnt = num // 5
    print(cnt)
else:
    while num > 0:
        num -= 3
        cnt += 1
        if num % 5 == 0:
            cnt += num // 5
            print(cnt)
            break
        elif num == 0:
            cnt += num // 3
            print(cnt)
            break
        elif num == 1 or num == 2:
            print(-1)
            break
