function solution(survey, choices) {
    var answer = '';
    let R = 0;
    let C = 0;
    let J = 0;
    let A = 0;
    
    for(let i = 0; i < survey.length; i++) {
        const target = survey[i][0];
        const choice = choices[i] - 4;
        
        if(target == 'R' || target == 'T') {
            if(target == 'R') {
                R += -choice;
            } else {
                R += choice;
            }
        }
        
        if(target == 'C' || target == 'F') {
            if(target == 'C') {
                C += -choice;
            } else {
                C += choice;
            }
        }
        
        if(target == 'J' || target == 'M') {
            if(target == 'J') {
                J += -choice;
            } else {
                J += choice;
            }
        }
        
        if(target == 'A' || target == 'N') {
            if(target == 'A') {
                A += -choice;
            } else {
                A += choice;
            }
        }
    }
    
    answer = [R >= 0 ? 'R' : 'T', C >= 0 ? 'C' : 'F', J >= 0 ? 'J' : 'M', A >= 0 ? 'A' : 'N'].join('');
    
    return answer;
}