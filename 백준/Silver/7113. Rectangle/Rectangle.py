import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def square(w, h):
    global cnt

    if w == h:
        cnt += 1
        return cnt

    if w > h:
        cnt += 1
        return square(w-h, h)
    elif w < h:
        cnt += 1
        return square(w, h-w)


n, m = map(int, input().split())
cnt = 0
print(square(n, m))