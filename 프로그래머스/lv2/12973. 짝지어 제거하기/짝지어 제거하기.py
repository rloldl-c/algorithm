def solution(s):
    answer = -1
    stack = [s[0]]

    for i in range(1, len(s)):
        if stack:
            tmp = stack.pop() 

            if tmp != s[i]:
                stack.append(tmp)
                stack.append(s[i])
        else:
            stack.append(s[i])
            
    if stack:
        answer = 0
    else:
        answer = 1
        
    return answer