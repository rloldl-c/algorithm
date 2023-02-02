import sys
input = sys.stdin.readline

s = input().strip()
new_s = []


for j in range(1, len(s)-1):
    for k in range(j+1, len(s)):
        sub1 = s[:j]
        sub2 = s[j:k]
        sub3 = s[k:]

        sub1 = sub1[::-1]
        sub2 = sub2[::-1]
        sub3 = sub3[::-1]
        
        new_s.append(sub1+sub2+sub3)

new_s = sorted(new_s)

print(new_s[0])