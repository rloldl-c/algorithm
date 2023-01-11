stu, top = map(int, input().split())

grade = list(map(int, input().split()))

grade = sorted(grade)

print(grade[stu-top])