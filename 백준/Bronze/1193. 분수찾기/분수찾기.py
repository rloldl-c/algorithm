import sys

x = int(sys.stdin.readline().strip())
line = 0
max = 0

while x > max:
    line += 1
    max += line

gap = max - x

if line % 2 == 0: # 짝수인 경우 1/line
    num = line - gap
    den = gap + 1
    print(f"{num}/{den}")

else: # 홀수인 경우 line/1
    num = gap + 1
    den = line - gap
    print(f"{num}/{den}")