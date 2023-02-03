import sys

input = sys.stdin.readline

test = int(input())

for _ in range(test):
    note1 = int(input())
    note1_num = list(map(int, input().split()))
    note2 = int(input())
    note2_num = list(map(int, input().split()))
    
    num_dict = {}
    for n in note1_num:
        num_dict[n] = 1

    for n in note2_num:
        print(num_dict.get(n, 0))