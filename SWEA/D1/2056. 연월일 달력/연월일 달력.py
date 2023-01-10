test = int(input())

for i in range(test):
    date = input()
    year = date[0:4]
    month = date[4:6]
    day = date[6:]

    if int(month) > 12 or int(month) == 0:
        print(f"#{i+1} -1")
        continue

    if int(month) == [1, 3, 5, 7, 8, 10, 12]:
        if int(day) > 32:
            print(f"#{i+1} -1")
            continue
    elif int(month) == 2:
        if int(day) != 28:
            print(f"#{i+1} -1")
            continue
    else:
        if int(day) > 31:
            print(f"#{i+1} -1")
            continue

    print(f"#{i+1} {year}/{month}/{day}")