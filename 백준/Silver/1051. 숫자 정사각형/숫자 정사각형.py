import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []

for _ in range(n):
    arr.append(list(input().strip()))

# 정사각형 넓이의 최대값을 저장할 변수
max_ = 1
# 입력으로 들어온 두 수 중 작은 수가 만들 수 있는 정사각형의 최대 길이
min_ = min(n, m)

# 정사각형의 길이
for i in range(1, min_):
    # 정사각형을 만들 때 리스트 범위에서 벗어나지 않도록 입력받은 수에서 i만큼 빼주기
    for j in range(n - i):
        for k in range(m - i):
            # 4개의 꼭짓점이 같은 수면 이전에 찾은 넓이와 비교해서 최대값으로 갱신
            if arr[j][k] == arr[j+i][k] == arr[j][k+i] == arr[j+i][k+i]:
                max_ = max(max_, ((i+1)*(i+1)))
            
print(max_)