
test = int(input())

exam = list(map(int, input().split()))
cnt = exam[0]
score = exam[0]

for i in range(1, test):
    if exam[i] == 0:
        cnt = 0
    else:
        cnt += 1

    score += cnt

print(score)
