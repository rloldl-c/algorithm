import sys

test = int(sys.stdin.readline().strip())
end_list = [[10], [1], [2, 4, 8, 6], [3, 9, 7, 1], [4, 6], 
            [5], [6], [7, 9, 3, 1], [8, 4, 2, 6], [9, 1]]

for i in range(test):
    a, b = map(int, sys.stdin.readline().split())
    list_index = b % len(end_list[a%10]) -1
    print(end_list[a%10][list_index])