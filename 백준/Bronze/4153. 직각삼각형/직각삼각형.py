while True:
    numbers = list(map(int, input().split()))

    if numbers[0] == numbers[1] == numbers[2] == 0:
        break

    max_index = numbers.index(max(numbers))
    side1 = side2 = 0

    for i in range(3):
        if i != max_index:
            side2 += numbers[i] ** 2
        else:
            side1 = numbers[i] ** 2
    
    if side1 == side2:
        print("right")
    else:
        print("wrong")