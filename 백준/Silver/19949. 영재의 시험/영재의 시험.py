import sys
input = sys.stdin.readline

def exam(cnt, correct):
    global ans

    if cnt == 10:
        ans += 1
        return
    
    for i in range(1, 6):
        if len(yj) < 2 or (yj[-1] != i or yj[-2] != yj[-1]):
            yj.append(i)
            if num[len(yj)-1] == i:
                exam(cnt+1, correct+1)
            else:
                if len(yj) - correct > 5:
                    yj.pop()
                    continue
                
                exam(cnt+1, correct)
            yj.pop()


num = list(map(int, input().split()))
yj = []
ans = 0
exam(0, 0)

print(ans)