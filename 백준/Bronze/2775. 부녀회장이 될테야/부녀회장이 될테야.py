test = int(input())

for i in range(test):
    floor = int(input()) + 1
    num = int(input())
    apartment = [[0]*num for i in range(floor)]
    people = 0

    for n in range(1, num+1): # 0층 num호에는 num명이 산다
        apartment[0][n-1] = n
    
    for n in range(floor):
        apartment[n][0] = 1 # floor층 0호에는 1명이 산다

    for n in range(1, floor):
        for m in range(1, num):
            apartment[n][m] = apartment[n][m-1] + apartment[n-1][m]

    print(apartment[floor-1][num-1])