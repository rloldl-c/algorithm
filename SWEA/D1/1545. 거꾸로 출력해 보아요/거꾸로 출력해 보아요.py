num = int(input())
reverse_num = [0] * (num+1)

for i in range(num+1):
    reverse_num[i] = num - i

print(*reverse_num)