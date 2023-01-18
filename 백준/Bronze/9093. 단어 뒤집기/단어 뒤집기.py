test = int(input())

for i in range(test):
    words = list(input().split())

    for j in range(len(words)):
        for k in range(1, len(words[j])+1):
            print(words[j][-k], end="")
        print(" ", end="")

    print()        