test = int(input())

for i in range(test):
    a, b = map(int, input().split())
    print(f"Case #{i+1}: {a} + {b} = {a+b}")