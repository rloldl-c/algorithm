function solution(id_list, report, k) {
    let answer = [];
    const id = new Map();
    const count = Array.from(Array(id_list.length), () => Array(id_list.length).fill(0))
    
    for(let i = 0; i < id_list.length; i++) {
        id.set(id_list[i], [i, 0])
    }

    for(let str of report) {
        const arr = str.split(" ")
        if(count[id.get(arr[0])[0]][id.get(arr[1])[0]] == 0) {
        count[id.get(arr[0])[0]][id.get(arr[1])[0]] = 1
        id.get(arr[1])[1]++            
        }

    }
    
    for(let i = 0; i < id_list.length; i++) {
        let cnt = 0
        for(let j = 0; j < id_list.length; j++) {
            if(i != j && count[i][j] != 0) {
                [...id.values()].forEach((arr) => {
                    if(arr[0] == j && arr[1] >= k) {
                        cnt++
                    }
                })
            }
        }
        
        answer.push(cnt)
    }
    
    return answer;
}