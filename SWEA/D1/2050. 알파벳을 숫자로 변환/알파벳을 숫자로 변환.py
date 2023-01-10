char = input().lower()

for i in range(len(char)):
    print(ord(char[i])-96, end=" ")