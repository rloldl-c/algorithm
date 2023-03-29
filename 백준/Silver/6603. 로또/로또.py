import sys
input = sys.stdin.readline

def lotto(idx, cnt):
    if cnt == 6:
        print(*tmp)
        return

    for i in range(idx, k):
        tmp.append(s[i])
        lotto(i+1, cnt+1)
        tmp.pop()


while True:
    num = list(map(int ,input().split()))
    k = num[0]
    s = num[1:]
    tmp = []
    
    if k == 0:
        break

    lotto(0, 0)
    print()