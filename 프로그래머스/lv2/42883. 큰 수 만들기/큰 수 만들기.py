def solution(number, k):
    answer = []
    ans_len = len(number) - k
    
    for i in range(len(number)):
        if len(answer) < ans_len:
            answer.append(number[i])
        
        if i+1 < len(number) and int(number[i]) < int(number[i+1]):
            if k > 0:
                while answer and k:
                    if len(answer) + len(number[i:]) <= ans_len:
                        break
                        
                    if int(answer[-1]) >= int(number[i+1]):
                        break
                        
                    answer.pop()
                    k -= 1

    
    return ''.join(answer)