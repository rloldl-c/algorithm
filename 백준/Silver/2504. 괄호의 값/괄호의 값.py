import sys
input = sys.stdin.readline

string = list(input().strip())
stack = []
tmp = 1
ans = 0

for i in range(len(string)):
    if string[i] == '(':
        tmp *= 2
        stack.append(string[i])
    elif string[i] == '[':
        tmp *= 3
        stack.append(string[i])

    if string[i] == ')':
        if stack:
            k = stack.pop()
            if k != '(':
                ans = 0
                break
            else:
                if string[i-1] == '(':
                    ans += tmp
                tmp //= 2
        else:
            ans = 0
            break

    elif string[i] == ']':
        if stack:
            k = stack.pop()
            if k != '[':
                ans = 0
                break
            else:
                if string[i-1] == '[':
                    ans += tmp
                tmp //= 3
        else:
            ans = 0
            break

if stack:
    ans = 0

print(ans)