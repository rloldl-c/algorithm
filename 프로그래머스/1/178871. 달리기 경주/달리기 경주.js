function solution(players, callings) {
    const ranking = {}
    const answer = [];
    
    for(let i = 0; i < players.length; i++) {
        ranking[i+1] = players[i]
        ranking[players[i]] = i+1
    }
    
    callings.forEach((name) => {
        // 추월하는 선수의 현재 등수
        const rank = ranking[name]
        // 추월당한 선수
        const preview = ranking[rank-1]
        
        ranking[rank] = preview
        ranking[preview] = rank
        ranking[name] = rank-1
        ranking[rank-1] = name

    })
    
    for(let i = 1; i <= players.length; i++) {
        answer.push(ranking[i])
    }
    
    return answer;
}