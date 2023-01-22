test = int(input())
last_day = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31]

for i in range(test):
    month1, day1, month2, day2 = map(int, input().split())
    total = 0

    if month1 == month2:
        print(f"#{i+1} {day2 - day1 + 1}")
    else:
        for j in range(month1, month2):
            total += last_day[j]
        
        total -= day1 - day2 - 1

        print(f"#{i+1} {total}")