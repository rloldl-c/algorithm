function solution(places) {
    let answer = []
    
    for(const place of places) {
        const seat = []
        
        for(let i = 0; i < 5; i++) {
            for(let j = 0; j < 5; j++) {
                if(place[i].charAt(j) == 'P') {
                    seat.push([i, j])
                }
            }
        }

        let flag = true
        
        for(let i = 0; i < seat.length; i++) {
            for(let j = i+1; j < seat.length; j++) {
                const dist = Math.abs(seat[i][0] - seat[j][0]) + 
                      Math.abs(seat[i][1] - seat[j][1])

                if(dist <= 2) {
                    if(!checkPartition(place, seat[i], seat[j])) {
                        flag = false
                        break
                    }
                }
            }
            
            if(!flag) {
                break
            }
        }
        
        if(flag) {
            answer.push(1)
        } else {
            answer.push(0)
        }
    }
    
    return answer;
}

function checkPartition(place, seat1, seat2) {
    const er = Math.max(seat1[0], seat2[0])
    const ec = Math.max(seat1[1], seat2[1])
    const sr = Math.min(seat1[0], seat2[0])
    const sc = Math.min(seat1[1], seat2[1])
    const deltas = {
        0: [0, 1],
        1: [1, 0],
        2: [0, -1],
        3: [-1, 0]
    }
    console.log("(", sr, ",", sc, ") (", er, ",", ec, ")")
    
    for(let i = sr; i <= er; i++) {
        for(let j = sc; j <= ec; j++) {
            if(place[i].charAt(j) == 'P') {
                for(let d = 0; d < 4; d++) {
                    const nr = i + deltas[d][0]
                    const nc = j + deltas[d][1]
                    
                    if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue
                    
                    if(place[nr].charAt(nc) == 'P') {
                        return false
                    }
                }
            }
            
            if(place[i].charAt(j) == 'O') {
                return false
            }
        }
    }
    
    return true
}