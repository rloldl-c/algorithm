test = int(input())

for i in range(test):
    string = input()
    for j in range(2, len(string)):
        for k in range(int(string[0])):
            print(string[j], end='')
    print()