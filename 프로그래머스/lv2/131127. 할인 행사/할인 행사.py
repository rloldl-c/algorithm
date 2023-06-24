def count(number, dic):
    tmp = list(dic.values())
    flag = True
    
    for i in range(len(tmp)):
        if tmp[i] != number[i] :
            flag = False
            break
            
    return flag


def solution(want, number, discount):
    answer = 0
    buy = {}
    
    for product in want:
        buy[product] = 0

    for i in range(10):
        if discount[i] in want:
            buy[discount[i]] += 1

    if buy and count(number, buy):
        answer += 1
    
    if len(discount) > 10:
        for i in range(len(discount) - 10):
            if discount[i] in want:
                buy[discount[i]] -= 1
                    
            if discount[i+10] in want:
                buy[discount[i+10]] += 1
            
            if count(number, buy):
                answer += 1
            
    return answer