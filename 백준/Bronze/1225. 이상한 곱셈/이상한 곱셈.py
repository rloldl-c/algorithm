import sys
input = sys.stdin.readline

num1, num2 = input().split()
sum_num1 = 0
ans = 0

for i in num1:
    sum_num1 += int(i)

for i in num2:
    ans += sum_num1 * int(i)

print(ans)