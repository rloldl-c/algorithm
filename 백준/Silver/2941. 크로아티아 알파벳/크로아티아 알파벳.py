s = input()
cnt = 0

for i in range(len(s)):
    if s[i] == 'c':
        if i < len(s)-1:
            if s[i+1] == '=' or s[i+1] == '-':
                continue  
    
    if s[i] == 'd':
        if i < len(s)-1:
            if s[i+1] == 'z':
                if i < len(s)-2:
                    if s[i+2] == '=':
                        continue
            elif s[i+1] == '-':
                continue

    if s[i] == 'l' or s[i] == 'n':
        if i < len(s)-1:
            if s[i+1] == 'j':
                continue  
    
    if s[i] == 's' or s[i] == 'z':
        if i < len(s)-1:
            if s[i+1] == '=':
                continue
    
    cnt += 1  

print(cnt)