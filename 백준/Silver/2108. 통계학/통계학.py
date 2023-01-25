import sys

input = sys.stdin.readline

num = int(input())
numbers = [0 for i in range(num)]
num_dict = {}

for i in range(num):
    numbers[i] = int(input())

numbers = sorted(numbers)

for number in numbers:
    if number not in num_dict:
        num_dict[number] = 1
    else:
        num_dict[number] += 1

num_dict = sorted(num_dict.items(), key=lambda x: x[1], reverse=True)
mode_list = [num_dict[0][0]]

for i in range(1, len(num_dict)):
    if num_dict[0][1] == num_dict[i][1]:
        mode_list.append(num_dict[i][0])

if len(mode_list) != 1:
    mode_list = sorted(mode_list)
    mode = mode_list[1]
else:
    mode = mode_list[0]

avg = round(sum(numbers) / num)
median = numbers[num//2]
range = max(numbers) - min(numbers)

print(avg, median, mode, range, sep="\n")