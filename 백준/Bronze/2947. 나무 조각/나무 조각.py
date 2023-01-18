sticks  = list(map(int, input().split()))

while True:

    for i in range(4):
        if sticks[i] > sticks[i+1]:
            tmp = sticks[i]
            sticks[i] = sticks[i+1]
            sticks[i+1] = tmp 
            print(*sticks)

    is_ordered = False

    for i in range(5):
        if sticks[i] != i+1:
            is_ordered = False
            break
        else:
            is_ordered = True
    
    if is_ordered:
        break
