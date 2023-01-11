hour, minu, sec = map(int, input().split())
cook = int(input())

minu += (sec + cook) // 60
sec = (sec + cook) % 60
hour += minu // 60
if hour > 23:
    hour %= 24
minu = minu % 60

print(hour, minu, sec)