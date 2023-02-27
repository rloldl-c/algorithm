import sys
input = sys.stdin.readline

s = input().strip()
alpha_dict = {}
res = ""
odd = ""

for i in s:
    if i not in alpha_dict:
        alpha_dict[i] = 1
    else:
        alpha_dict[i] += 1

tmp = sorted(list(alpha_dict.keys()))
sorted_alpha = {i : alpha_dict[i] for i in tmp}

for char, num in sorted_alpha.items():
    while num > 1:
        res += char
        num -= 2
        
    if num == 1:
        if len(s) % 2 == 0:
            print("I'm Sorry Hansoo")
            break
        else:
            if not odd:
                odd = char
            else:
                print("I'm Sorry Hansoo")
                break
else:
    if len(s) == 0:
        print(res, res[::-1], sep="")
    else:
        print(res, odd, res[::-1], sep="")