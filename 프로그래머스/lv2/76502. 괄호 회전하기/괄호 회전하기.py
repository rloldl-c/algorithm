def solution(s):
    answer = 0
    s += s
    
    for i in range(len(s)//2):
        now_s = s[i: i+len(s)//2]
        stack = []
        flag = True
        
        if now_s[0] in ')}]' or now_s[-1] in '({[':
            continue
        
        for j in range(len(now_s)):
            if now_s[j] in '({[':
                stack.append(now_s[j])
            else:
                if not stack:
                    flag = False
                    break
                else:
                    if (now_s[j] == ')' and stack[-1] == '(') or (now_s[j] == '}' and stack[-1] == '{') or (now_s[j] == ']' and stack[-1] == '['):
                        stack.pop()
            
        if not stack and flag:
            answer += 1
                
    return answer