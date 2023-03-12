import sys
input = sys.stdin.readline

n = int(input())
ques = []
ans = []
cnt = 0
mh = '123'

for _ in range(n):
    a, b, c = map(int, input().split())
    ques.append(str(a))
    ans.append((b, c))

while int(mh) != 999:
    if len(set(mh)) == 3 and '0' not in mh:
    
        tmp = 0

        for i in range(n):
            s = b = 0
            for j in range(3):
                if ques[i][j] == mh[j]:
                    s += 1

                elif mh[j] in ques[i] :
                    b += 1    

            if s == ans[i][0] and b == ans[i][1]:
                tmp += 1
        
        if tmp == n:
            cnt += 1

    mh = str(int(mh) + 1)
    
print(cnt)