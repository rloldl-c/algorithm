function solution(board) {
    let answer = -1;
    let OWin = false
    let XWin = false
    let OArray = []
    let XArray = []
    
    for(let i = 0; i < 3; i++) {
        for(let j = 0; j < 3; j++) {
            if(board[i].at(j) == "O") {
                OArray.push([i, j])
                if(!OWin) {
                    OWin = check(i, j, "O", board)
                }
            }
            
            if(board[i].at(j) == "X") {
                XArray.push([i, j])
                if(!XWin) {
                    XWin = check(i, j, "X", board)
                }
            }
        }
    }

    if(OWin) {
        if(XArray.length >= OArray.length) return 0
    }
    
    if(XWin) {
        if(OArray.length > XArray.length) return 0
    }
    
    while(true) {
        if(OArray.length == 0 || XArray.length == 0) break
        
        OArray.pop()
        XArray.pop()
        console.log(OArray.length, XArray.length)
    }
    
    if((OArray.length == 0  || OArray.length == 1) && XArray.length == 0) return 1
    
    return 0;
}

function check(r, c, char, board) {
    let flag = true
    let cnt = 0
    
    // 가로
    for(let i = c; i < 3; i++) {
        if(board[r].at(i) == char) {
            cnt++
        }       
    }
    
    if(cnt == 3) return true
    
    cnt = 0
    for(let i = r; i < 3; i++) {
        if(board[i].at(c) == char) {
            cnt++
        }
    }
    
    if(cnt == 3) return true
    
    cnt = 0
    for(let i = 0; i < 3; i++) {
        if(r + i >= 0 && r + i < 3 && c + i >= 0 && c + i < 3 && board[r+i].at(c+i) == char) {
            cnt++
        }
    }
    
    if(cnt == 3) return true
    
    cnt = 0
    for(let i = 0; i < 3; i++) {
        if(r + i >= 0 && r + i < 3 && c - i >= 0 && c - i < 3 && board[r+i].at(c-i) == char) {
            cnt++
        }
    }
    
    if(cnt == 3) return true
    
    return false
}