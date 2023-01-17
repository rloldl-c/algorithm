test = int(input())

for i in range(test):
    s = input()
    is_palin = True

    for j in range(len(s)//2):
        if s[j] != s[-j-1]:
            is_palin = False
            break

    if is_palin == True:
        print(f"#{i+1} 1")
    else:
        print(f"#{i+1} 0")