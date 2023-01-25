import sys

input = sys.stdin.readline

while True:
    s = input().rstrip()

    if s == ".":
        break
    
    stack = []

    for ch in s:
        if ch == "[" or ch == "]" or ch == "(" or ch == ")":
            if len(stack) != 0:
                a = stack[-1]
                if a == "[" and ch == "]":
                    stack.pop()
                elif a == "(" and ch == ")":
                    stack.pop()
                else:
                    stack.append(ch)
            else:
                stack.append(ch)

    if len(stack) == 0:
        print("yes")
    else:
        print("no")
