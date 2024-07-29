function solution(p) {
    let answer = '';

    answer = convert(p)
    
    return answer;
}

function isPerfect(p) {
    const stack = []
    
    for(const c of p) {
        if(c == '(') {
            stack.push(c)
        } else {
            if(stack.length != 0 && stack[stack.length - 1] == '(') {
                stack.pop()
            } else {
                return false
            }
        }
    }
    
    if(stack.length == 0) {
        return true
    } else {
        return false
    }
}

function convert(p) {
    if(p.length == 0) {
        return ''
    }
    
    let u = ''
    let v = ''
    let idx = 0
    let cnt = 0
    const stack = []
    let flag = true
    
    // u, v로 분리
    for(const c of p) {
        if(c == '(') {
            stack.push(c)
            cnt++
        } else {
            if(stack.length != 0 && stack[stack.length - 1] == '(') {
                stack.pop()
            } else {
                flag = false
            }
            
            cnt--
        }
        
        idx++
        
        if(cnt == 0) {
            u = p.slice(0, idx)
            v = p.slice(idx)
            break
        }
    }
    
    if(isPerfect(u)) {
        // 올바른 문자열이라면 v 수행 결과를 붙여서 반환
        return u + convert(v)
    } else {
        // 올바른 문자열이 아니라면
        const newV = '(' + convert(v) + ')'
        let newU = ''
        
        u = u.slice(1, u.length - 1)
        for(const c of u) {
            if(c == '(') {
                newU += ')'
            } else {
                newU += '('
            }
        }
        
        return newV + newU
    }
}