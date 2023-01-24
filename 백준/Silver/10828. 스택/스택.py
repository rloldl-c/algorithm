import sys
input = sys.stdin.readline

num = int(input())
stack = []

for i in range(num):
    cmd = input().split()

    if cmd[0] == "push":
        stack.append(cmd[1])
    elif cmd[0] == "pop":
        if len(stack) == 0:
            print(-1)
        else:
            a = stack.pop()
            print(a)
    elif cmd[0] == "size":
        print(len(stack))
    elif cmd[0] == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])