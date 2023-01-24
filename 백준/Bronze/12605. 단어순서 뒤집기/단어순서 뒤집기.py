import sys

input = sys.stdin.readline

num = int(input())

for i in range(num):
    string = input().split()
    print(f"Case #{i+1}:", end=" ")
    for j in range(len(string)):
        a = string.pop()
        print(a, end=" ")
    print()