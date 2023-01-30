import sys
input = sys.stdin.readline

num, ques = map(int, input().split())
ranking = [list(map(int, input().split())) for _ in range(num)]
ranking_dict = {}
ans = 0

ranking = sorted(ranking, key=lambda x: (x[1], x[2], x[3]), reverse=True)

for rank in ranking:
    ranking_dict[rank[0]] = rank[1:4]

for rank in ranking_dict:
    ans += 1
    if ranking_dict[rank] == ranking_dict[ques]:
        break


print(ans)