def backtracking(l, n, idx, tmp, idx_list):
    if len(tmp) == n:
        tmp = sorted(tmp)
        if tmp not in idx_list:
            idx_list.append(tmp)

        return
    
    for i in range(idx, l):
        if i not in tmp:
            tmp.append(i)
            backtracking(l, n, i+1, tmp, idx_list)
            tmp.pop()
    

def solution(relation):
    answer = []
    idx_list = []
    fail = set()
    
    for i in range(len(relation[0])):
        backtracking(len(relation[0]), i+1, 0, [], idx_list)

    for i in range(len(idx_list)):
        candidate_key = set()
        for j in range(len(relation)):
            tmp = ""
            for k in range(len(idx_list[i])):
                tmp += str(relation[j][idx_list[i][k]])
                
            candidate_key.add(tmp)
        
        if len(candidate_key) == len(relation):
            answer.append(idx_list[i])
    
    for i in range(len(answer)):
        if answer[i] == 0:
            continue
            
        for j in range(len(answer)):
            if i == j:
                continue
                
            if answer[j] == 0:
                continue
            
            same = 0
            
            for k in answer[i]:
                if k in answer[j]:
                    same += 1
                    
            if same == len(answer[i]):
                answer[j] = 0
    
    return len(answer) - answer.count(0)