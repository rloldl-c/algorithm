let zero = 0;
let one = 0;

function isEqual(arr, r, c, len) {
    for(let i = r; i < r + len; i++) {
        for(let j = c; j < c + len; j++) {
            if(arr[r][c] != arr[i][j]) {
                return false;
            }
        }
    }
    
    return true;
}

function zip(arr, r, c, len) {
    if(len == 1) {
        arr[r][c] == 0 ? zero++ : one++;
        return;
    }
    
    if(isEqual(arr, r, c, len)) {
        arr[r][c] == 0 ? zero++ : one++;
    } else {
        zip(arr, r, c, len / 2);
        zip(arr, r + len / 2, c, len / 2);
        zip(arr, r, c + len / 2, len / 2);
        zip(arr, r + len / 2, c + len / 2, len / 2);
    }
}

function solution(arr) {
    zip(arr, 0, 0, arr.length);
    return [zero, one];
}