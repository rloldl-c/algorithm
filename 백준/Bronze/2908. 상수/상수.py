num1, num2 = map(int, input().split())

r_num1 = (num1//100) + (((num1//10)%10)*10) + (((num1%100)%10)*100)
r_num2 = (num2//100) + (((num2//10)%10)*10) + (((num2%100)%10)*100)

print(max(r_num1, r_num2))