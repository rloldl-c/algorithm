function solution(topping) {
    let answer = 0;
    let dict = {}
    let cnt = 0
    
    for(let n of topping) {
        if(dict[n] == undefined) {
            dict[n] = 1
            cnt++
        } else {
            dict[n]++
        }
    }
    
    let visited = new Array(cnt).fill(false)
    let me = 0
    let bro = cnt
    
    for(let n of topping) {
        if(!visited[n]) {
            me += 1
            visited[n] = true
        }
        
        dict[n] -= 1
        
        if(dict[n] == 0) {
            bro -= 1
        }

        if(me == bro) {
            answer+=1
        }
    }
    
    return answer;
}