test = int(input())

for i in range(test):
    origin = int(input())
    num = origin
    cnt = 1
    numbers = []

    while True:
        n = num % 10

        if n not in numbers:
            numbers.append(n)
        
        num //= 10

        if num == 0:
            cnt += 1
            num = origin * cnt

            if len(numbers) == 10:
                break

    print(f"#{i+1} {num-origin}")