test = int(input())
num = {
    'ZRO' : 0,
    'ONE' : 1,
    'TWO' : 2,
    'THR' : 3,
    'FOR' : 4,
    'FIV' : 5,
    'SIX' : 6,
    'SVN' : 7,
    'EGT' : 8,
    'NIN' : 9
}

re_num = {}

for k, v in num.items():
    re_num[v] = k

for t in range(test):
    tc, n = input().split()
    numbers = list(input().split())
    for i in range(int(n)):
        numbers[i] = num[numbers[i]]

    numbers = sorted(numbers)

    print(tc)
    for i in numbers:
        print(re_num.get(i), end=" ")
