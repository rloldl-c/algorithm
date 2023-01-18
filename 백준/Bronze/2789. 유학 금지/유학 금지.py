s = input()
remove_char = ['C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E']

for char in s:
    if char not in remove_char:
        print(char, end="")