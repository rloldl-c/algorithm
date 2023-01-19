import sys

input = sys.stdin.readline

test = int(input())
staff = {}
company = []

for i in range(test):
    name, state = input().split()
    staff[name] = state

for n in staff:
    if staff[n] == "enter":
        company.append(n)

company.sort(reverse=True)

for n in company:
    print(n)