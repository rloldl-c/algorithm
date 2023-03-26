import sys
input = sys.stdin.readline

target = input().strip()
n = int(input())

if n == 0:
    ans = min(len(target), abs(100 - int(target)))
elif n == 10:
    btn = list(input().split())
    ans = abs(int(target) - 100)
elif int(target) == 100:
    ans = 0
else:
    btn = list(input().split())
    ans = int(1e9)
    
    for i in range(1000001):
        is_working = True
        for j in str(i):
            if j in btn:
                is_working = False
                break
        
        if is_working:
            ans = min(ans, abs(int(target) - i) + len(str(i)), abs(100 - int(target)))

print(ans)