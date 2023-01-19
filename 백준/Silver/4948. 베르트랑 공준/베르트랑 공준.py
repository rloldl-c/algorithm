prime = []

for i in range(2, 246913):
    cnt = 0
    for j in range(2, int(i**0.5)+1):
        if i % j == 0:
            cnt += 1
            break
    
    if cnt == 0:
        prime.append(i)

while True:
    n = int(input())
    cnt = 0

    if n == 0:
        break
    else:
        for i in prime:
            if n < i < 2*n+1:
                cnt += 1

    print(cnt)