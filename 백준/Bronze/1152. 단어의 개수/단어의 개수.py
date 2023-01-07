s_list = input().split(" ")
cnt = 0

for word in s_list:
    if word == "":
        continue
    else:
        cnt += 1

print(cnt)