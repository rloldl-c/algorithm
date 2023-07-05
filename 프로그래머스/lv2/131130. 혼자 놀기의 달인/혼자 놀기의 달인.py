def open_box(cards, visited, idx, now, group):
    if visited[idx]:
        group.append(now)
        return
    
    visited[idx] = True
    now.append(cards[idx-1])
    open_box(cards, visited, cards[idx-1], now, group)


def solution(cards):
    answer = 0
    group = []
    visited = [False] * (len(cards)+1)
    
    while True:
        if len(set(visited[1:])) == 1 and visited[1]:
            break
            
        for i in range(1, len(visited)):
            if not visited[i]:
                open_box(cards, visited, i, [], group)
    
    if len(group) > 1:
        group = sorted(group, key=lambda x: len(x))
        answer = len(group[-1]) * len(group[-2])
        
    else:
        answer = 0
        
    return answer