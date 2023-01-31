import sys
input = sys.stdin.readline

numbers = [int(input()) for _ in range(10)]
avg = sum(numbers) // 10
num_dict = {}

for num in numbers:
    if num in num_dict:
        num_dict[num] += 1
    else:
        num_dict[num] = 1

num_dict = sorted(num_dict.items(), key=lambda x: x[1], reverse=True)

print(avg, num_dict[0][0], sep="\n")