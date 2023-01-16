import sys

num = int(sys.stdin.readline().strip())
cnt = 0

if num >= 100:
    cnt = 99

    for i in range(100, num+1):
        hun = i // 100
        ten = i // 10 % 10
        one = i % 10

        if hun - ten == ten - one:
            cnt += 1

else:
    cnt = num

print(cnt)