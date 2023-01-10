import sys

test = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
cnt = 0

for i in range(test):
    isPrime = True
    if num[i] == 1:
        isPrime = False
        continue

    for k in range(2, num[i]):
        if num[i] % k == 0:
            isPrime = False
            continue

    if isPrime == True:
        cnt += 1

print(cnt)