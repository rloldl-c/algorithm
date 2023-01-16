import sys

month_list = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
day_list = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
total_day = 0

month, day = map(int, sys.stdin.readline().split())

for i in range(month-1):
    total_day += month_list[i]

total_day += day

print(day_list[total_day%7-1])