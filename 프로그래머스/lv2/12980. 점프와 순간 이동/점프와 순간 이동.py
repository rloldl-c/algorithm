def solution(n):
    ans = 1

    while n:
        if n == 1:
            break 

        if n % 2 != 0:
            ans += 1
            n -= 1

        n //= 2

    return ans