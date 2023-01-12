num = int(input())
cnt = 1
res = 0

while cnt*(cnt+1) <= 2*num:
    cnt += 1

print(cnt-1)