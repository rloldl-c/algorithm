test = int(input())

for i in range(test):
    numbers = list(map(int, input().split()))
    total = 0

    for num in numbers:
        total += num
    
    total -= max(numbers) + min(numbers)
    total = round(total/8)
    
    print(f"#{i+1} {total}")