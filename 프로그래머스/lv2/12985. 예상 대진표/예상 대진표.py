def ceil(num):
    if num%2 == 1:
        num = num//2 + 1
    else:
        num = num//2
        
    return int(num)


def solution(n,a,b):
    answer = 0

    while True:
        a = ceil(a)
        b = ceil(b)
        answer += 1
        
        if a == b:
            break

    return answer