def solution(prices):
    answer = []
    
    for i in range(len(prices)-1):
        sec = 0
        for j in range(i+1, len(prices)):
            if prices[i] > prices[j]:
                answer.append(sec+1)
                break
            else:
                sec += 1
                
        else:
            answer.append(sec)
    
    answer.append(0)
        
    return answer