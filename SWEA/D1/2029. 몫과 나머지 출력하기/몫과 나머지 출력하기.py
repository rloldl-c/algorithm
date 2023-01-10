test = int(input())

for i in range(test):
    a, b = map(int, input().split())
    quotient = a // b
    remainder = a % b
    print(f"#{i+1} {a // b} {a % b}")