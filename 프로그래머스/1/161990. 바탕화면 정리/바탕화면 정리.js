function solution(wallpaper) {
    var answer = [-1, -1, -1, -1];
    
    let flag = false
    // 가장 위에
    for(let i = 0; i < wallpaper.length; i++) {
        for(let j = 0; j < wallpaper[i].length; j++) {
            if(wallpaper[i].charAt(j) == "#") {
                answer[0] = i
                flag = true
                break
            }
        }
        
        if(flag) break
    }
    
    flag = false
    // 가장 왼쪽
    for(let i = 0; i < wallpaper[0].length; i++) {
        for(let j = 0; j < wallpaper.length; j++) {
            if(wallpaper[j].charAt(i) == "#") {
                answer[1] = i
                flag = true
            }
        }
        
        if(flag) break
    }
    
    // 가장 아래
    flag = false
    for(let i = wallpaper.length-1; i >= 0; i--) {
        for(let j = 0; j < wallpaper[i].length; j++) {
            if(wallpaper[i].charAt(j) == "#") {
                answer[2] = i+1
                flag = true
            }
        }
        
        if(flag) break
    }
    
    // 가장 오른쪽
    flag = false
    for(let i = wallpaper[0].length-1; i >= 0; i--) {
        for(let j = 0; j < wallpaper.length; j++) {
            if(wallpaper[j].charAt(i) == "#") {
                answer[3] = i+1
                flag = true
            }
        }
        
        if(flag) break
    }
    
    return answer;
}