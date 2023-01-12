test = int(input())

for i in range(test):
    ans = 0
    exp = list(input().split())
    for j in range(len(exp)):
        if j == 0:
            ans += float(exp[j])
            continue

        if exp[j] == "@":
            ans *= 3
        elif exp[j] == "%":
            ans += 5
        elif exp[j] == "#":
            ans -= 7

    print(f'{ans:.2f}')