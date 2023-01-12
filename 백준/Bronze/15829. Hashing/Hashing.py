length = int(input())
string = input()
total = 0

for i in range(length):
    total += (ord(string[i]) - 96) * (31 ** i)

print(total % 1234567891)