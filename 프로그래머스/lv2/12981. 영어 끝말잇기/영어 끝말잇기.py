def solution(n, words):
    answer = [0, 0]
    turn = []
    turn.append(words[0])
    
    for i in range(1, len(words)):
        if words[i-1][-1] != words[i][0] or words[i] in turn:
            if (i+1)%n == 0:
                answer[0] = n
            else:
                answer[0] = (i+1)%n
                
            answer[1] = i//n+1
            break
        turn.append(words[i])
        
    return answer