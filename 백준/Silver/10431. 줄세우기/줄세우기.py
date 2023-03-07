import sys
input = sys.stdin.readline

test = int(input())

for t in range(test):
    stu = list(map(int, input().split()))
    sorted_stu = [stu[1]]
    cnt = 0
    m = stu[1]
    
    for i in range(2, 21):
        if m > stu[i]:
            for j in range(len(sorted_stu)):
                if sorted_stu[j] > stu[i]:
                    cnt += len(sorted_stu) - j
                    sorted_stu.insert(j, stu[i])
                    break

        else:
            sorted_stu.append(stu[i])
            m = stu[i]

    print(t+1, cnt)