import sys
input = sys.stdin.readline

def palin(s, length):
    is_aka = False

    if length == 1:
        return True

    cur_length = length//2

    if s == s[::-1]:
        is_aka = palin(s[:cur_length], cur_length)

    return is_aka

s = input().strip()
s_len = len(s)

if palin(s, s_len):
    print("AKARAKA")
else:
    print("IPSELENTI")