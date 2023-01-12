while True:
    num = input()
    if num == "0":
        break
    
    ans = "yes"

    index = len(num) // 2

    for i in range(index):
        if int(num[i]) != int(num[len(num)-i-1]):
            ans = "no"
            break
        
    print(ans)