import sys
input = sys.stdin.readline

n = int(input())
home = sorted(list(map(int, input().split())))

if n % 2 == 0:
    antenna = home[n//2-1]
else:
    antenna = home[n//2]
    
print(antenna)