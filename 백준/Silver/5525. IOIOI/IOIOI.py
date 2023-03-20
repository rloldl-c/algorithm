import sys
input = sys.stdin.readline

def check(start):
    flag = True

    for i in range(pn):
        if start % 2 == 0:
            if (start+i) % 2 == 0:
                if string[start+i] == "O":
                    flag = False
                    break
            else:
                if string[start+i] == "I":
                    flag = False
                    break
        else:
            if (start+i) % 2 == 0:
                if string[start+i] == "I":
                    flag = False
                    break
            else:
                if string[start+i] == "O":
                    flag = False
                    break
    return flag


n = int(input())
s = int(input())
string = input().strip()
pn = 2*n + 1
cnt = 0

for i in range(s-pn+1):
    if string[i] == "I":
        if check(i):
            cnt += 1

print(cnt)