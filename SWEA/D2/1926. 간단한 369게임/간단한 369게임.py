num = int(input())

for i in range(1, num+1):
    cnt = 0
    cnt += str(i).count("3")
    cnt += str(i).count("6")
    cnt += str(i).count("9")
    
    if cnt != 0:
        print("-"*cnt, end=" ")
    else:
        print(i, end=" ")