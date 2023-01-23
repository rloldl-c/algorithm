test = int(input())
decode = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
          'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
          '0','1','2','3','4','5','6','7','8','9','+','/'
          ]
num = 0 # 각 알파벳을 표에 있는 수로 변환
bin_num = "" # 표에 있는 수를 이진수로 변환
decimal = 0 # 8자리씩 끊어서 십진수로 변환

for i in range(test):
    s = input().strip()
    total = "" # 이진수들을 한 줄로 잇기

    for word in s:
        num = decode.index(word)
        bin_num = format(num, "b")

        while len(bin_num) < 6:
            bin_num = "0" + bin_num
        
        total += bin_num

    res = "" # 디코딩한 최종 문자열

    for j in range(len(total)//8):
        decimal = int(total[j*8:j*8+8], 2)
        res += chr(decimal)

    print(f"#{i+1} {res}")