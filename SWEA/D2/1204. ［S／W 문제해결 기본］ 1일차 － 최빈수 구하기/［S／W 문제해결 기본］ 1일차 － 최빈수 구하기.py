test = int(input())

for i in range(test):
    tc = int(input())
    stu = list(map(int, input().split()))
    grade = {}

    for n in stu:
        if n not in grade:
            grade[n] = 1
        else:
            grade[n] += 1

    grade = sorted(grade.items(), key=lambda x: x[1], reverse=True)
    
    print(f"#{tc} {grade[0][0]}")
