def solution(files):
    answer = []
    
    for i in range(len(files)):
        file = list(files[i])
        files[i] = ['', '', '']
        for j in range(2):
            while file:
                tmp = file[0]
                
                if j == 0:
                    if tmp not in '0123456789':
                        files[i][0] += tmp
                        file.pop(0)
                    else:
                        break
                    
                if j == 1:
                    if tmp in '0123456789':
                        files[i][1] += tmp
                        file.pop(0)
                    else:
                        break
        
        files[i][2] += ''.join(file)                    
    
    files = sorted(files, key=lambda x: (x[0].lower(), int(x[1])))
    answer = [''.join(file) for file in files]
    print(files)
    
    return answer