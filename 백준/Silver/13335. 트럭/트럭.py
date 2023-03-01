import sys
input = sys.stdin.readline

n, w, l = map(int, input().split())
truck = list(map(int, input().split()))
bridge = [0] * w
cnt = 0

while True:
    cnt += 1
    bridge.pop(0)

    if truck:
        if sum(bridge) + truck[0] > l:
            bridge.append(0)
        else:
            bridge.append(truck.pop(0))
    else:
        bridge.append(0)
    
    if sum(bridge) == 0:
        break

print(cnt)