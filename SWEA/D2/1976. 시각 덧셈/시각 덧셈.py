test = int(input())

for i in range(test):
    hour1, minute1, hour2, minute2 = map(int, input().split())

    minute = (minute1 + minute2) % 60
    hour = hour1  + hour2 + (minute1 + minute2) // 60
    
    if hour > 12:
        hour -= 12
    
    print(f"#{i+1} {hour} {minute}")
