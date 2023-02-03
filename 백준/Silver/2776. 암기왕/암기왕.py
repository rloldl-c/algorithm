import sys

input = sys.stdin.readline

def search(t, arr):
    s = 0
    e = len(arr)-1

    while s <= e:
        m = (s+e) // 2
        if t == arr[m]:
            return 1
        elif t > arr[m]:
            s = m + 1
        else:
            e = m - 1

test = int(input())

for _ in range(test):
    note1 = int(input())
    note1_num = list(map(int, input().split()))
    note1_num = sorted(note1_num)
    note2 = int(input())
    note2_num = list(map(int, input().split()))

    for i in note2_num:
        s = 0
        e = note1 - 1

        if (search(i, note1_num)) == 1:
            print(1)
        else:
            print(0)