money = 1000 - int(input())
coin = [500, 100, 50, 10, 5, 1]
idx = 0
cnt = 0

while True:
    if money >= coin[idx]:
        cnt += money // coin[idx]
        money %= coin[idx]
    
    idx += 1

    if money == 0:
        break

print(cnt)