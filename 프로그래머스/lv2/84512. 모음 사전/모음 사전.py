def solution(word):
    global answer
    answer = 0
    
    def backtracking(tmp):
        global answer
        answer += 1
        
        if tmp == word:
            return True
        
        if len(tmp) == 5:
            return False
        
        for i in "AEIOU":
            flag = backtracking(tmp+i)
            if flag:
                return True
    
    for i in "AEIOU":
        flag = backtracking(i)
        if flag:
            break
                
    return answer