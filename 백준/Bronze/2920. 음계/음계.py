numbers = list(map(int, input().split()))
ans = False

for i in range(7):
    if numbers[i+1] == numbers[i] + 1:
        ans = True
    elif numbers[i+1] == numbers[i] - 1:
        ans = False
    else:
        ans = "mixed"
        break


if ans == True:
    print("ascending")
elif ans == False:
    print("descending")
else:
    print(ans)