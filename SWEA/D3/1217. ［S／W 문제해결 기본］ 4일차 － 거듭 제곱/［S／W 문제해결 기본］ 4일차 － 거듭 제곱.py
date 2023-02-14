def square(num):
    if num == 1:
        return n
    
    return n * square(num-1)


for t in range(10):
    tc = int(input())
    n, m = map(int, input().split())
    print(f"#{tc} {square(m)}")