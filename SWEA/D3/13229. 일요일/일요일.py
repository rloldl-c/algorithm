test = int(input())
day = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']

for i in range(test):
    s = input().strip()

    if s == 'SUN':
        print(f"#{i+1} 7")

    else:
        print(f"#{i+1} {6 - day.index(s)}")