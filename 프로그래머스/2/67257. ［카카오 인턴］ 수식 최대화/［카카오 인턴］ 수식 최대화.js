const operator = ['+', '-', '*']
let answer = 0

function solution(expression) {
    const expressionArr = []
    let idx = 0
    for(let i = 0; i < expression.length; i++) {
        if(operator.includes(expression[i])) {
            expressionArr.push(parseInt(expression.slice(idx, i)))
            expressionArr.push(expression[i])
            idx = i+1
        }
    }
    expressionArr.push(parseInt(expression.slice(idx)))
    
    permu(expressionArr, [], Array(3).fill(false))
    
    return answer;
}

function calculate(left, oper, right) {
    if(oper == '+') {
        return left + right
    } else if(oper == '-') {
        return left - right
    } else {
        return left * right
    }
}

function permu(exp, res, visited) {
    if(res.length == 3) {
        const arr = [...exp]
        
        for(let idx of res) {
            for(let i = 0; i < arr.length; i++) {
                if(arr[i] == operator[idx]) {
                    const tmp = calculate(arr[i-1], arr[i], arr[i+1])
                    arr.splice(i-1, 3, tmp)
                    i--
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(arr[0]))
        return
    }
    
    for(let i = 0; i < 3; i++) {
        if(!visited[i]) {
            visited[i] = true
            res.push(i)
            permu(exp, res, visited)
            res.pop()
            visited[i] = false
        }
    }
}