function solution(n, k, enemy) {
    let answer = 0;

    if (k >= enemy.length) {
        return enemy.length;
    }

    let s = 0;
    let e = enemy.length;

    while (s <= e) {
        let m = Math.floor((s + e) / 2);
        if (play(n, k, enemy.slice(0, m).sort((a, b) => b - a))) {
            s = m + 1;
            answer = Math.max(answer, m);
        } else {
            e = m - 1;
        }
    }

    return answer;
}

function play(n, k, enemy) {
    let tmp = 0;

    for (let e of enemy) {
        if(k > 0) {
            k--
        } else {
            tmp += e
        }
    }

    return tmp <= n;
}