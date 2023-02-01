import sys
input = sys.stdin.readline

day = int(input())
time = [0] * day # 상담에 걸리는 시간
money = [0] * day # 상담 비용
max_m = [0] * (day+1) # 비용 최대값들을 모은 리스트

for i in range(day):
    # 입력이 들어오면 시간과 비용을 나눠서 각각 리스트에 삽입
    time[i], money[i] = map(int, input().split())

for i in range(day):
    # 상담에 소요되는 기간이 퇴사 날짜 전이라면
    if i + time[i] <= day:
        # 상담이 종료되는 날짜(현재 날짜 + 소요 기간)에 비용을 넣는다
        # 계산된 값이 이미 있다면 현재 비용과 비교하여 더 큰 값을 넣는다
        max_m[i+time[i]] = max(max_m[i+time[i]], money[i]+max_m[i])
    
    # 아래 코드가 없으면 max_m을 출력했을 때 빈 곳이 있음
    # -> 해당 날짜까지 일하는 경우의 수가 없는 것
    # 그래서 그 이전까지 일했던 최대 비용을 넣어줘야 한다
    # 꼭 연속해서 일할 필요는 없는 것 같음!
    max_m[i+1] = max(max_m[i], max_m[i+1])

print(max_m[day])