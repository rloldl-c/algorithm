import sys
input = sys.stdin.readline

def recursion(s, l, r):
    global cnt
    cnt += 1

    if l >= r: 
        return (1, cnt)
    elif s[l] != s[r]: 
        return (0, cnt)
    else: 
        return recursion(s, l+1, r-1)

def isPalindrome(s):
    return recursion(s, 0, len(s)-1)

n = int(input())

for _ in range(n):
    s = input().strip()
    cnt = 0
    print(*isPalindrome(s))