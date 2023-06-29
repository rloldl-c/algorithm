def solution(records):
    answer = []
    user = {}
    
    for i in range(len(records)):
        record = records[i].split()
        
        if record[0] != 'Leave':
            user[record[1]] = record[2]

                    
    for i in range(len(records)):
        record = records[i].split()
        
        if record[0] == 'Enter':
            answer.append(user[record[1]] + "님이 들어왔습니다.")
        elif record[0] == 'Leave':
            answer.append(user[record[1]] + "님이 나갔습니다.")
            
    return answer