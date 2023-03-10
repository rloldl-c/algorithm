import sys
input = sys.stdin.readline

s1, s2 = input().split()

if len(s1) == len(s2):
    cnt = 0
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            cnt += 1
else:
    cnt = int(1e9)
    for i in range(len(s2)-len(s1)+1):
        tmp = 0
        for j in range(len(s1)):
            if s1[j] != s2[i+j]:
                tmp += 1

        cnt = min(cnt, tmp)

print(cnt)