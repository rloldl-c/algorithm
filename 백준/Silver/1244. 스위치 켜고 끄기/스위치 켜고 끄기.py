import sys
input = sys.stdin.readline

n = int(input())
switch = list(map(int, input().split()))
stu = int(input())

for _ in range(stu):
    students = list(map(int, input().split()))

    if students[0] == 1: # 남자
        for j in range(n):
            if (j+1) % students[1] == 0:
                if switch[j] == 1:
                    switch[j] = 0
                else:
                    switch[j] = 1
    else: # 여자
        students[1] -= 1
        s = e = n+1
        for i in range(1, n//2+1):
            if students[1] - i < 0 or  students[1] + i > n-1:
                break
            else:
                if switch[students[1] - i] == switch[students[1] + i]:
                    s = students[1] - i
                    e = students[1] + i
                else:
                    break

        if s != e:
            for i in range(s, e+1):
                if switch[i] == 1:
                    switch[i] = 0
                else:
                    switch[i] = 1
        else:
            if switch[students[1]] == 1:
                switch[students[1]] = 0
            else:
                switch[students[1]] = 1

if len(switch) > 20:
    for i in range(len(switch)):
        print(switch[i], end=" ")
        if (i+1) % 20 == 0:
            print()
else:
    print(*switch)