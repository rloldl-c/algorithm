import sys
input = sys.stdin.readline

n = int(input())
room = []
r_ans = 0
c_ans = 0

for _ in range(n):
    room.append(input().strip())

for i in range(n):
    r_cnt = 0
    for j in range(n):
        if room[i][j] == ".":
            r_cnt += 1
        else:
            if r_cnt >= 2:
                r_ans += 1

            r_cnt = 0
    
    if r_cnt >= 2:
        r_ans += 1

for i in range(n):
    c_cnt = 0
    for j in range(n):
        if room[j][i] == ".":
            c_cnt += 1
        else:
            if c_cnt >= 2:
                c_ans += 1

            c_cnt = 0
    
    if c_cnt >= 2:
        c_ans += 1

print(r_ans, c_ans)