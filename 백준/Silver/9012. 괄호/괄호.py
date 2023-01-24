import sys

input = sys.stdin.readline

num = int(input())

for i in range(num):
    string = input().strip()
    stack = []
    is_VPS = True

    for s in string:
        if s == "(":
            stack.append(s)
        else:
            if len(stack) == 0:
                is_VPS = False
                break
            else:
                stack.pop()

    if len(stack) != 0:
        print("NO")
    elif is_VPS:
        print("YES")
    else:
        print("NO")