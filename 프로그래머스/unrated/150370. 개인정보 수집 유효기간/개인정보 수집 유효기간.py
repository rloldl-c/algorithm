def solution(today, terms, privacies):
    answer = []
    for i in range(len(privacies)):
        for j in range(len(terms)):
            char, month = terms[j].split()
            if privacies[i][-1] == terms[j][0]:
                cur_date = 12*28*int(today[:4]) + 28*int(today[5:7]) + int(today[8:])
                pri_date = 12*28*int(privacies[i][:4]) + 28*int(privacies[i][5:7]) + int(privacies[i][8:10])
                diff = cur_date - pri_date

                print(diff, int(month)*28)
                if diff >= int(month) * 28:
                    answer.append(i+1)
    
    return answer
