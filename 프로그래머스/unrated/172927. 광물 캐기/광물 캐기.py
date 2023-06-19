def solution(picks, minerals):
    if sum(picks) < len(minerals)/5:
        minerals = minerals[:sum(picks)*5]

    hp = [[] for _ in range(len(minerals)//5+1)]
    answer = 0
    
    if sum(picks) == 0:
        return 0

    if picks[2]:
        for i in range(len(minerals)//5+1):
            tmp = 0
            for j in range(i*5, i*5+5):
                if j >= len(minerals):
                    break

                if minerals[j] == 'diamond':
                    tmp += 25
                elif minerals[j] == 'iron':
                    tmp += 5
                else:
                    tmp += 1
            
            hp[i] = [i, tmp]
    
    elif picks[1]:
        for i in range(len(minerals)//5+1):
            tmp = 0
            for j in range(i*5, i*5+5):
                if j >= len(minerals):
                    break

                if minerals[j] == 'diamond':
                    tmp += 5
                else:
                    tmp += 1

            hp[i] = [i, tmp]

    else:
        for i in range(len(minerals)//5+1):
            tmp = 0
            for j in range(i*5, i*5+5):
                if j >= len(minerals):
                    break

                tmp += 1

            hp[i] = [i, tmp]
    

    hp = sorted(hp, key=lambda x: x[1], reverse=True)

    for i in range(len(hp)):
        idx = hp[i][0]

        if picks[0]:
            for j in range(idx*5, idx*5+5):
                if j >= len(minerals):
                    break

                answer += 1

            picks[0] -= 1

        elif picks[1]:
            for j in range(idx*5, idx*5+5):
                if j >= len(minerals):
                    break

                if minerals[j] == 'diamond':
                    answer += 5
                else:
                    answer += 1

            picks[1] -= 1

        elif picks[2]:
            for j in range(idx*5, idx*5+5):
                if j >= len(minerals):
                    break

                if minerals[j] == 'diamond':
                    answer += 25
                elif minerals[j] == 'iron':
                    answer += 5
                else:
                    answer += 1

            picks[2] -= 1

    return answer