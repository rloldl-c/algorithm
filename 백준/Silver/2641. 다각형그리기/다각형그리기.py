import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
reverse_arr = []
m = int(input())
cnt = 0
res = []

for i in range(n-1, -1, -1):
    if arr[i] == 1:
        reverse_arr.append(3)
    elif arr[i] == 2:
        reverse_arr.append(4)
    elif arr[i] == 3:
        reverse_arr.append(1)
    else:
        reverse_arr.append(2)


for i in range(m):
    tmp = list(map(int, input().split()))

    for j in range(n):
        flag = True
        for k in range(j, j+n):
            if arr[k-j] != tmp[k%n]:
                flag = False
                break

        if not flag:
            flag = True
            for k in range(j, j+n):
                if reverse_arr[k-j] != tmp[k%n]:
                    flag = False
                    break
    
        if flag:
            cnt+=1 
            res.append(tmp)
            break

print(len(res))
for i in res:
    print(*i)