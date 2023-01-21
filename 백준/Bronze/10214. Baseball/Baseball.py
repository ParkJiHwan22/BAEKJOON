T = int(input())

for i in range(T):
    score = [list(map(int, input().split())) for i in range(9)]
    Yonsei = 0
    Korea = 0

    for i in range(9):
        Yonsei += score[i][0] 
        Korea += score[i][1]
    
    if Yonsei > Korea:
        print('Yonsei')

    elif Yonsei < Korea:
        print('Korea')

    else:
        print('Draw')