def backtracking(order, menus, cnt, tmp, idx, visited):
    if len(tmp) == cnt:
        tmp = ''.join(sorted(tmp))
        menus.add(tmp)
        return
    
    for i in range(idx, len(order)):
        if not visited[ord(order[i])-65]:
            visited[ord(order[i])-65] = True
            backtracking(order, menus, cnt, tmp+order[i], i+1, visited)
            visited[ord(order[i])-65] = False


def solution(orders, course):
    answer = []
    menus = set()
    menu_cnt = []
    
    for n in course:
        for order in orders:
            visited = [False for _ in range(26)]
            backtracking(order, menus, n, "", 0, visited)
    
    for menu in menus:
        menu_cnt.append([menu, 0])
    
    
    for i in range(len(menu_cnt)):
        order_cnt = 0
        for order in orders:
            tmp = 0
            for j in menu_cnt[i][0]:
                if j in order:
                    tmp += 1
                    
                if tmp == len(menu_cnt[i][0]):
                    break
                    
            if tmp == len(menu_cnt[i][0]):
                order_cnt += 1
                
        if order_cnt > 1:
            menu_cnt[i][1] = order_cnt
            
    menu_cnt = sorted(menu_cnt, key=lambda x: x[1], reverse=True)  
    max_cnt = []
    
    for i in course:
        max_cnt.append([i, 0])
        
    for i in range(len(max_cnt)):
        for menu, cnt in menu_cnt:
            if max_cnt[i][0] == len(menu):
                max_cnt[i][1] = cnt
                break

    for menu_len, cnt in max_cnt:
        if cnt == 0:
            continue 
            
        for i in range(len(menu_cnt)):
            if len(menu_cnt[i][0]) == menu_len and menu_cnt[i][1] == cnt:
                answer.append(menu_cnt[i][0])
    
    answer = sorted(answer)
    return answer