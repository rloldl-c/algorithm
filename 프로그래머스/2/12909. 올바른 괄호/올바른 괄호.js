function solution(s){
    let answer = true;
    const stack = new Array();
    
    for(let bracket of s) {        
        if(bracket == '(') {
            stack.push(bracket);
        } else {
            if(stack.length == 0) {
                return false;
            }
            
            if(stack[stack.length - 1] != '(') {
                return false;
            }
            
            stack.pop();
        }
    }
    
    if(stack.length == 0) {
        return true;
    } else {
        return false;
    }
}