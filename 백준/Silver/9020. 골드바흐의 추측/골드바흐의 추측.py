import sys
input = sys.stdin.readline

def isPrime(num):
    if num == 1:
        return False
    else:
        for i in range(2, int(num**0.5)+1):
            if num % i == 0:
                return False
        return True
    
prime_num = [False for i in range(10001)]

for i in range(len(prime_num)):
    prime_num[i] = isPrime(i)

test = int(input())

for _ in range(test):
    n = int(input())
    front = n//2
    end = n//2

    while True:
        if front + end == n:
            if prime_num[front] == True and prime_num[end] == True:
                print(front, end)
                break
        
        front -= 1
        end += 1