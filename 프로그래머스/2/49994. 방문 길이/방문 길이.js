function solution(dirs) {
    let answer = 0;
    let r = 0;
    let c = 0;
    const deltas = {
        'U': [1, 0],
        'D': [-1, 0],
        'R': [0, 1],
        'L': [0, -1],
    };
    const visited = [];
    
    for(let d of dirs) {
        const nr = r + deltas[d][0];
        const nc = c + deltas[d][1];
        const path = [[r, c].join(''), [nr, nc].join('')].sort().join('');
        
        if(nr < -5 || nc < -5 || nr > 5 || nc > 5) {
            continue;
        }

        if(!visited.includes(path)) {
            answer++;
            visited.push(path);
        }

        r = nr;
        c = nc;
    }
    
    return answer;
}