test = int(input())

for i in range(test):
    stu_list = list(map(int, input().split()))
    sum = 0
    avg = 0
    stu = 0

    for j in range(1, len(stu_list)):
        sum += stu_list[j]

    avg = sum / stu_list[0]

    for j in range(1, len(stu_list)):
        if stu_list[j] > avg:
            stu += 1
    
    print(f"{stu/stu_list[0]*100:.3f}%")
