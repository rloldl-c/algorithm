import sys
input = sys.stdin.readline

def is_same(num, idx, now):
    flag = False
    for i in range(n):
        if i != int(now) and num == stu[i][:idx+1]:
            flag = True
    
    return flag
    

n = int(input())
stu = [input().strip()[::-1] for _ in range(n)]
stu_len = len(stu[0])

for i in range(stu_len):
    flag = True
    for j in range(n):
        if is_same(stu[j][:i+1], i, j):
            flag = False
        else:
            continue
    
    if flag:
        print(i+1)
        break