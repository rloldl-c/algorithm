import sys
input = sys.stdin.readline

def star(n):
    if n == 1:
        paper[((N-1)*4)//2][((N-1)*4)//2] = "*"
        return
    else:
        for i in range((n-1)*4+1):
            paper[i+2*(N-n)][2*(N-n)] = "*"
            paper[i+2*(N-n)][(n-1)*4+2*(N-n)] = "*"
            paper[2*(N-n)][i+2*(N-n)] = "*"
            paper[(n-1)*4+2*(N-n)][i+2*(N-n)] = "*"

    return star(n-1)


N = int(input())
paper = [[" "] * ((N-1)*4+1)for _ in range((N-1)*4+1)]

star(N)

for i in range(len(paper)):
    print(*paper[i], sep="")