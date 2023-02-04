import sys
input = sys.stdin.readline

bingo = [] # 입력으로 들어오는 빙고판
bingo_dict = {} # 좌표를 저장하기 위한 딕셔너리
order = [] # 사회자가 불러주는 수
check = [[0] * 5 for _ in range(5)] # 빙고판에서 사회자가 부른 수를 체크하기 위한 매트릭스
num = cnt = res = 0
breaker = False

for i in range(5):
    bingo.append(list(map(int, input().split())))
    for j in range(5):
        bingo_dict[bingo[i][j]] = (i, j)

for _ in range(5):
    order.append(list(map(int, input().split())))

# 사회자가 불러주는 숫자에 대응하는 좌표를 check에 기록
# 사회자가 부른 수는 1, 아직 부르지 않은 수는 0
for i in range(5):
    for j in range(5):
        x = bingo_dict[order[i][j]][0]
        y = bingo_dict[order[i][j]][1]
        check[x][y] = 1
        num += 1
        res = 0
        
        # 빙고가 되기 위해서는 사회자가 최소 12번 불러줘야 함
        if num >= 12:
            # 0,0에서 4,4까지 대각선 확인
            cnt = 0
            for k in range(5):
                if check[k][k] == 1:
                    cnt += 1
                if cnt == 5:
                    res += 1
            
            # 0,4에서 4,0까지 대각선 확인
            cnt = 0
            for k in range(5):
                if check[k][4-k] == 1:
                    cnt += 1
                if cnt == 5:
                    res += 1
            
            # 가로 확인
            for k in range(5):
                if check[k][0] == 1:
                    if sum(check[k]) == 5:
                        res += 1

            # 세로 확인
            for k in range(5):
                tmp = 0
                for l in range(5):
                    if check[l][k] == 1:
                        tmp += 1
                        if tmp == 5:
                            res += 1
                    
            if res >= 3:
                print(num)
                breaker = True
                break

    if breaker:
        break

