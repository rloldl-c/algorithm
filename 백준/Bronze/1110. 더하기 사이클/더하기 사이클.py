num = int(input())
cnt = 1

a = num // 10
b = num % 10
c = a + b
if c > 10:
    c %= 10
    new = b * 10 + c       
elif c % 10 == 0:
    new = b * 10
else:
    new = b * 10 + c  
if num != new:
    while True:
        a = new // 10
        b = new % 10
        c = a + b
        if c > 10:
            c %= 10
            new = b * 10 + c       
        elif c % 10 == 0:
            new = b * 10
        else:
            new = b * 10 + c  
            
        cnt += 1

        if num == new:
            break

print(cnt)
