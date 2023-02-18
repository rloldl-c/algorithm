def solution(s):
    answer = ''
    tmp = []
    idx = 0
    start = 0
    
    while True:
        if idx == len(s):
            tmp.append(s[start:idx])
            break
            
        if s[idx] == " ":
            tmp.append(s[start:idx])
            start = idx
        
        idx += 1
    
    for char in tmp:
        for i in range(len(char)):
            if char[i] == " ":
                answer += char[i]
            else:
                if char[i] in '0123456789':
                    answer += char[i] + char[i+1:].lower()
                else:
                    answer += char[i].upper() + char[i+1:].lower()
                break
                
    return answer