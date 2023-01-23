test = int(input())

for i in range(test):
    num = int(input())
    a = b = c = d = e = 0
    cnt = 2

    while num != 1:
        if num % cnt == 0:
            num //= cnt
            if cnt == 2:
                a += 1
            elif cnt == 3:
                b += 1
            elif cnt == 5:
                c += 1
            elif cnt == 7:
                d += 1
            else:
                e += 1
        else:
            cnt += 1        
    
    print(f"#{i+1} {a} {b} {c} {d} {e}")