n = input()

num_list = [n[i] for i in range(len(n))]

answer = []

if int(n) >= int('7'*len(n)):
    print('7'*(len(n)))

elif int(n) >= int('4'*len(n)):
    for j in range(len(n)):
        if num_list[j] >= '8':
            answer.append('7'*(len(n)-j))
            break
        elif num_list[j] == '7': 
            answer.append('7')
        
        elif num_list[j] > '4':
            answer.append('4')
            answer.append('7'*(len(n)-j-1))
            break

        elif num_list[j] == '4':
            answer.append('4')

        else:
            t = 1
            while True:
                if answer[j-t] == '7':
                    break
                else:
                    t += 1
            answer[j-t] = '4'
            for k in range(j-t+1, j): 
                answer[k] = '7'  
            answer.append('7'*(len(n)-j))
            break

    print(*answer, sep = '')

else:
    print('7'*(len(n)-1))