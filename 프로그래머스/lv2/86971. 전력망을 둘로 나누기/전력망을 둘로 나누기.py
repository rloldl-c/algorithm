from collections import deque

def bfs(graph, visited):
    que = deque()
    cnt = 1
    
    for i in range(1, len(graph)):
        if graph[i]:
            que.append(graph[i][0])
            break
            
    while que:
        now = que.popleft()
        visited[now] = True
        
        for next in graph[now]:
            if not visited[next]:
                que.append(next)
                cnt += 1
    
    return cnt


def solution(n, wires):
    answer = int(1e9)

    for i in range(len(wires)):
        graph = [[] for _ in range(n+1)]
        for a, b in wires:
            if a == wires[i][0] and b == wires[i][1]:
                continue
                
            graph[a].append(b)
            graph[b].append(a)
            
        visited = [False] * (n+1)
        cnt = bfs(graph, visited)
        
        answer = min(answer, abs((n-cnt) - cnt))
        
    return answer