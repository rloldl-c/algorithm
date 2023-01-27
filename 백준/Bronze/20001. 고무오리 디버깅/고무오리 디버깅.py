import sys

input = sys.stdin.readline

start = input().strip()
problem = []

while True:
    s = input().strip()

    if s == "고무오리 디버깅 끝":
        break
    
    if s == "고무오리":
        if problem:
            problem.pop()
        else:
            problem.append("문제")
            problem.append("문제")
    else:
        problem.append(s)
        
if problem:
    print("힝구")
else:
    print("고무오리야 사랑해")