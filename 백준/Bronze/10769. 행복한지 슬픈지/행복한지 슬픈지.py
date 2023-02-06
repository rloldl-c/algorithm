import sys
input = sys.stdin.readline

s = input().strip()
happy = s.count(":-)")
sad = s.count(":-(")

if happy + sad == 0:
    print("none")
elif happy > sad:
    print("happy")
elif happy < sad:
    print("sad")
else:
    print("unsure")