import sys
input = sys.stdin.readline

n = int(input())

for i in range(n):
    tmp = list(map(int, input().split()))

    num = tmp[0]
    grade = sorted(tmp[1:], reverse=True)
    gap = 0
    for j in range(1, num):
        gap = max(gap, grade[j-1]-grade[j])

    print(f"Class {i+1}")
    print(f"Max {grade[0]}, Min {grade[num-1]}, Largest gap {gap}")