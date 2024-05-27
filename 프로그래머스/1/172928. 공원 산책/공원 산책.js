function solution(park, routes) {
    const deltas = {
        "N": [-1, 0],
        "E": [0, 1],
        "S": [1, 0],
        "W": [0, -1]
    }
    
    let now = [0, 0]
    let flag = false
    
    for(let i = 0; i < park.length; i++) {
        for(let j = 0; j < park[i].length; j++) {
            if(park[i].charAt(j) == "S") {
                now[0] = i
                now[1] = j
                flag = true
                break
            }
        }
        
        if(flag) break
    }
    
    for(let i = 0; i < routes.length; i++) {
        const route = routes[i].split(" ")
        flag  = true
        let nr = now[0]
        let nc = now[1]
        
        for(let j = 0; j < route[1]; j++) {
            nr += deltas[route[0]][0]
            nc += deltas[route[0]][1]
            
            if(nr < 0 || nr >= park.length || nc < 0 || nc >= park[0].length) {
                flag = false
                break
            }
            
            if(park[nr].charAt(nc) == "X") {
                flag = false
                break
            }
        }

        if(flag) {
            now[0] = nr
            now[1] = nc
        }
    }
    
    return now
}