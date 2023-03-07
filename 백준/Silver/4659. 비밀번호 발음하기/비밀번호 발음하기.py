import sys
input = sys.stdin.readline

while True:
    s = input().strip()
    acceptable = True

    if s == 'end':
        break

    for ch in s:
        if ch in 'aeiou':
            break
    else:
        print(f"<{s}> is not acceptable.")
        acceptable = False
        continue

    for i in range(len(s)-2):
        if s[i] in 'aeiou':
            for j in range(3):
                if s[i+j] in 'aeiou':
                    acceptable = False
                else:
                    acceptable = True
                    break
            
            if not acceptable:
                print(f"<{s}> is not acceptable.")
                break
        else:
            for j in range(3):
                if s[i+j] in 'aeiou':
                    acceptable = True
                    break
                else:
                    acceptable = False
            
            if not acceptable:
                print(f"<{s}> is not acceptable.")
                break
    
    for i in range(len(s) - 1):
        if s[i] not in 'eo':
            if s[i] == s[i+1]:
                print(f"<{s}> is not acceptable.")
                acceptable = False
                break
            
    if acceptable:
        print(f"<{s}> is acceptable.")