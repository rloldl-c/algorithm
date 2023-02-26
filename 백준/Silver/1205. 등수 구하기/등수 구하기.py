import sys
input = sys.stdin.readline

n, new, max_ = map(int, input().split())

if n == 0:
    print(1)
else:
    ranking = list(map(int, input().split()))
    cnt = 1

    if ranking[-1] >= new and len(ranking) == max_:
        print(-1)
    else:
        ranking.append(new)
        ranking = sorted(ranking, reverse=True)

        for i in range(1, min(max_, len(ranking))):
            if new >= ranking[0]:
                print(1)
                break
            else:
                if ranking[i] < ranking[i-1]:
                    cnt = i + 1
                    if ranking[i] == new:
                        print(cnt)
                        break