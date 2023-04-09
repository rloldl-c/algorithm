import sys
input = sys.stdin.readline

color = {}
num = {}
ans = 0

for i in range(5):
    a, b = input().split()
    
    if a not in color:
        color[a] = 1
    else:
        color[a] += 1
    
    if int(b) not in num:
        num[int(b)] = 1
    else:
        num[int(b)] += 1

# 5장 모두 같은 색
if len(set(color)) == 1:
    tmp = sorted(list(num.keys()))
    flag = True

    for i in range(4):
        if tmp[i+1] - tmp[i] != 1:
            flag = False
            break
    # 규칙 1
    if flag:
        ans = max(tmp) + 900
    # 규칙 4
    else:
        ans = max(tmp) + 600

# 
if len(set(num)) == 2 and ans == 0:
    flag = False
    tmp = list(num.keys())
    
    # 규칙 2
    if num[tmp[0]] == 4:
        ans = 800 + tmp[0]
    elif num[tmp[1]] == 4:
        ans = 800 + tmp[1]

    # 규칙 3
    if num[tmp[0]] == 3 and num[tmp[1]] == 2:
        ans = tmp[0] * 10 + tmp[1] + 700
    elif num[tmp[0]] == 2 and num[tmp[1]] == 3:
        ans = tmp[1] * 10 + tmp[0] + 700

# 규칙 5
tmp = sorted(list(num.keys()))
if len(tmp) == 5 and ans == 0:
    flag = True
    for i in range(4):
        if tmp[i+1] - tmp[i] != 1:
            flag = False
            break
    if flag:
        ans = max(tmp) + 500

same = []

if ans == 0:
    for i in tmp:
        # 규칙 6
        if num[i] == 3:
            ans = 400 + i
            break
        
        if num[i] == 2:
            same.append(i)
    
    # 규칙 7
    if len(same) == 2:
        ans = max(same) * 10 + min(same) + 300
    # 규칙 8
    elif len(same) == 1:
        ans = same[0] + 200
        
# 규칙 9
if ans == 0:
    ans = max(tmp) + 100
    
print(ans)