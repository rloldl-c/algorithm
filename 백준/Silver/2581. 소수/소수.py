import sys

m = int(sys.stdin.readline())
n = int(sys.stdin.readline())
prime_min = n
prime_sum = 0

for i in range(m, n+1):
    isPrime = True

    if i == 1:
        isPrime = False
        continue

    for j in range(2, i):
        if i % j == 0:
            isPrime = False
            continue

    if isPrime == True:
        prime_sum += i
        prime_min = min(prime_min, i)

if prime_sum == 0:
    print(-1)
else:
    print(prime_sum)
    print(prime_min)