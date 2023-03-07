import sys
input = sys.stdin.readline

def add(elem):
    return s.add(elem)

def remove(elem):
    return s.discard(elem)

def check(elem):
    if elem in s:
        return print(1)
    else:
        return print(0)
    
def toggle(elem):
    if elem in s:
        return s.remove(elem)
    else:
        return s.add(elem)
    
def all():
    return set(i for i in range(1, 21))

def empty():
    return s.clear()


n = int(input())
s = set()

for _ in range(n):
    cmd = list(input().split())

    if cmd[0] == 'add':
        add(int(cmd[1]))
    elif cmd[0] == 'remove':
        remove(int(cmd[1]))
    elif cmd[0] == 'check':
        check(int(cmd[1]))
    elif cmd[0] == 'toggle':
        toggle(int(cmd[1]))
    elif cmd[0] == 'all':
        s = all()
    else:
        empty()
