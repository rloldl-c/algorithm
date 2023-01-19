chess = [0 for i in range(8)]
cnt = 0

for i in range(8):
    chess[i] = input()
    for j in range(8):
        if i % 2 == 0:
            if j % 2 == 0:
                if chess[i][j] == "F":
                    cnt += 1
        else:
            if j % 2 == 1:
                if chess[i][j] == "F":
                    cnt += 1

print(cnt)