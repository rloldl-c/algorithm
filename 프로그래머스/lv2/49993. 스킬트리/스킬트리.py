from collections import deque

def solution(skill, skill_trees):
    answer = 0
    
    for tree in skill_trees:
        skill_lst = deque(skill)
        tree = deque(tree)
        flag = True
        
        for now_skill in skill_lst:
            if not flag:
                break
                
            if not tree:
                break
                
            while tree:
                if tree[0] in skill_lst and now_skill != tree[0]:
                    flag = False
                    break
                
                if now_skill == tree[0]:
                    tree.popleft()
                    break
                
                if tree[0] not in skill_lst:
                    tree.popleft()
                
        if flag:
            answer += 1        
    
    return answer