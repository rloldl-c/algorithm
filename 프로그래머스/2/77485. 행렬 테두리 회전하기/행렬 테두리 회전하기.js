function solution(rows, columns, queries) {
    var answer = [];
    const arr = Array.from(Array(rows+1), () => new Array(columns+1))
    let num = 1
    
    for(let i = 1; i <= rows; i++) {
        for(let j = 1; j <= columns; j++) {
            arr[i][j] = num++
        }
    }
    
    queries.map((query) =>  {
        const [sr, sc, er, ec] = query
        const tmp = arr[sr][ec]
        let min = tmp
        
        // 위
        for(let j = ec; j > sc; j--) {
            arr[sr][j] = arr[sr][j-1]
            min = Math.min(min, arr[sr][j-1])
        }
        
        // 왼쪽
        for(let i = sr; i < er; i++) {
            arr[i][sc] = arr[i+1][sc]
            min = Math.min(min, arr[i+1][sc])
        }
        
        // 아래
        for(let j = sc; j < ec; j++) {
            arr[er][j] = arr[er][j+1]
            min = Math.min(min, arr[er][j+1])
        }
        
        // 오른쪽
        for(let i = er; i > sr; i--) {
            arr[i][ec] = arr[i-1][ec]
            min = Math.min(min, arr[i-1][ec])
        }
        
        arr[sr+1][ec] = tmp
        answer.push(min)
    })
    
    return answer;
}