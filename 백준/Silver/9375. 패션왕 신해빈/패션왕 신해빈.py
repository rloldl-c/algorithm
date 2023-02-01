import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    num = int(input())
    dress = {}

    if num == 0:
        print(0)
    else:    
        for __ in range(num):
            name, category = input().split()

            if category not in dress:
                dress[category] = 1
            else:
                dress[category] += 1

        total = 1
        for i in dress:
            # 해당 아이템을 착용 안 하는 경우를 추가해주기 위한 + 1
            total *= (dress[i] + 1)

        # 알몸으로 외출하면 안되니까 -1
        print(total - 1)
