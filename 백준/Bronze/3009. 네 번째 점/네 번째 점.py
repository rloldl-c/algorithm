x = {}
y = {}

for i in range(3):
    num1, num2 = map(int, input().split())
    
    if num1 not in x:
        x[num1] = 1
    else:
        x[num1] += 1
    
    if num2 not in y:
        y[num2] = 1
    else:
        y[num2] += 1

for i in x:
    if x.get(i) != 2:
        print(i, end=" ")

for i in y:
    if y.get(i) != 2:
        print(i)