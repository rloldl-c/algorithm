import sys
input = sys.stdin.readline

def check(stack, cnt):
    now_cnt = cnt
    tmp = []
    
    for i in stack:
        if not tmp:
            if i == '}':
                now_cnt += 1
                tmp.append('{')
            else:
                tmp.append(i)
        else:
            if tmp[-1] == '{':
                if i == '{':
                    now_cnt += 1
                tmp.pop()
            else:
                if i == '}':
                    now_cnt += 1
                    tmp.pop()

    if tmp:
        check(tmp, now_cnt)
    else:
        return now_cnt
        
test = 0
while True:
    s = input().strip()
    stack = []
    ans = 0

    if s[0] == '-':
        break

    for i in s:
        if stack and i == '}' and stack[-1] == '{':
            stack.pop()
        else:
            stack.append(i)

    if stack:
        ans = check(stack, 0)
        
    test += 1
    print(f"{test}. {ans}")