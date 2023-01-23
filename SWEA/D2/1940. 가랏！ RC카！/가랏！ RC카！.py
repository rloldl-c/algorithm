test = int(input())

for i in range(test):
    num = int(input())
    distacne = 0
    speed = 0

    for j in range(num):
        cmd = input().split()
        
        if cmd[0] == '1':
            speed += int(cmd[1])
            distacne += speed
        elif cmd[0] == '2':
            speed -= int(cmd[1])
            if speed < 0:
                speed = 0
            distacne += speed
        else:
            distacne += speed

    print(f"#{i+1} {distacne}")