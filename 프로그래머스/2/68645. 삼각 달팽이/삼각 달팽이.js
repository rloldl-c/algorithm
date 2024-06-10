function solution(n) {
    let answer = [];
    const arr = [];
    const deltas = [[1, 0], [0, 1], [-1, -1]];
    const end = (n+1) * n / 2;
    
    for(let i = 0; i < n; i++) {
        arr.push(Array(i+1).fill(0))
    }
    
    let d = 0;
    let r = 0;
    let c = 0;
    for(let i = 1; i <= end; i++) {
        arr[r][c] = i;
        
        const nr = r + deltas[d][0];
        const nc = c + deltas[d][1];
        
        if(nr < 0 || nc < 0 || nr >= n || nc >= arr[r].length || arr[nr][nc] != 0) {
            d = (d+1) % 3;
        }
        
        r += deltas[d][0];
        c += deltas[d][1];
    }
    
    for(const res of arr) {
        answer.push(...res);
    }
    
    return answer;
}