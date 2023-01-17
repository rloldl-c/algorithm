test = int(input())
grades = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

for i in range(test):
    stu, num = map(int, input().split())
    score = [0 for k in range(stu)]

    for j in range(stu):
        mid, final, homework = map(int, input().split())
        score[j] = mid * 0.35 + final * 0.45 + homework * 0.2

    num_score = score[num-1]
    score.sort(reverse=True)
    g_index = score.index(num_score)//(stu//10)

    print(f"#{i+1} {grades[g_index]}")