import sys
input = sys.stdin.readline

n = int(input())
stu = [input().strip()[::-1] for _ in range(n)]
stu_len = len(stu[0])
idx = 0

while True:
    tmp = {}
    idx += 1

    for num in stu:
        if num[:idx] in tmp:
            tmp[num[:idx]] += 1
        else:
            tmp[num[:idx]] = 1

    if len(tmp) == n:
        print(idx)
        break