import sys

num = int(sys.stdin.readline().strip())
words = []

for i in range(num):
    words.append(sys.stdin.readline().strip())

words.sort()
words.sort(key= len)
res = []

for word in words:
    if word not in res:
        res.append(word)

for word in res:
    print(word)