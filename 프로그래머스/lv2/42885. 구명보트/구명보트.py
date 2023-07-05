from collections import deque

def solution(people, limit):
    answer = 0
    people = deque(sorted(people))
    
    while people:
        if len(people) > 1:
            if people[0] + people[-1] > limit:
                people.pop()

            else:
                people.popleft()
                people.pop()

        else:
            people.pop()
            
        answer += 1
    
    return answer