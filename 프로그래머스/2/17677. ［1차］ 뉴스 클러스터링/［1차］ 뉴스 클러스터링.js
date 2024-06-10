function solution(str1, str2) {
    let answer = 0;
    let set = new Map();
    let tmp = '';
    
    str1 = str1.toLowerCase();
    str2 = str2. toLowerCase();

    for(let i = 0; i < str1.length; i++) {
        if(str1.charAt(i).charCodeAt() >= 97 && str1.charAt(i).charCodeAt() <= 122) {
            tmp += str1.charAt(i);
            
            if(tmp.length == 2) {
                if(set.get(tmp) == undefined) {
                    set.set(tmp, [1, 0])
                } else {
                    set.set(tmp, [set.get(tmp)[0]+1, set.get(tmp)[1]])
                }

                tmp = tmp.slice(1);
            }
        } else {
            tmp = '';
        }
    }
    
    tmp = '';
    for(let i = 0; i < str2.length; i++) {
        if(str2.charAt(i).charCodeAt() >= 97 && str2.charAt(i).charCodeAt() <= 122) {
            tmp += str2.charAt(i);
            
            if(tmp.length == 2) {
                if(set.get(tmp) == undefined) {
                    set.set(tmp, [0, 1])
                } else {
                    set.set(tmp, [set.get(tmp)[0], set.get(tmp)[1]+1])
                }
                
                tmp = tmp.slice(1);
            }
        } else {
            tmp = '';
        }
    }
    
    const values = [...set.values()]
    let num = 0;
    let denum = 0;
    
    for(const value of values) {
        if(value[0] == 0 || value[1] == 0) {
            denum += Math.max(...value)
        }  else if(value[0] == 1 && value[1] == 1) {
            num += 1
            denum += 1
        } else if(value[0] >= 1 && value[1] >= 1) {
            num += Math.min(...value)
            denum += Math.max(...value)
        }
    }
    
    if(num == 0 && denum == 0) {
        answer = 65536;
    } else {
        answer = Math.floor((num / denum) * 65536);
    }

    return answer;
}