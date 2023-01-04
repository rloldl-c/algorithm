test = int(input())

for i in range(1, test+1):
    print(" " * (test-int(i)), end="")
    print("*" * int(i))