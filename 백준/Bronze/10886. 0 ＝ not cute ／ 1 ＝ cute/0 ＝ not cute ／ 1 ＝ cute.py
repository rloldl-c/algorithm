test = int(input())
cute_cnt = 0

for i in range(test):
    s = int(input())
    
    if s == 1:
        cute_cnt += 1

print("Junhee is cute!" if cute_cnt > test//2 else "Junhee is not cute!")