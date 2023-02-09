import sys
input = sys.stdin.readline

n, m = map(int, input().split())
# [A C G T]
order = [[0] * 4 for _ in range(m)]

for i in range(n):
    s = input().strip()

    for j in range(m):
        if s[j] == "A":
            order[j][0] += 1
        elif s[j] == "C":
            order[j][1] += 1
        elif s[j] == "G":
            order[j][2] += 1
        elif s[j] == "T":
            order[j][3] += 1

dna = []
cnt = 0
for i in range(m):
    max_index = order[i].index(max(order[i]))
    for j in range(4):
        if j != max_index:
            cnt += order[i][j]
    
    if max_index == 0:
        dna.append("A")
    elif max_index == 1:
        dna.append("C")
    elif max_index == 2:
        dna.append("G")
    elif max_index == 3:
        dna.append("T")

print("".join(dna))
print(cnt)