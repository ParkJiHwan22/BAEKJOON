word_A, word_B = input().split()

btn = 0
for num_A, i in enumerate(word_A):
    if btn == 0:        
        for num_B, j in enumerate(word_B): 
            if i == j:
                width = num_A
                height = num_B
                btn += 1
                break
    
ans = []
for k in range(len(word_B)):
    tmp = ''
    if k == height:   
        ans.append(word_A)
    
    else:
        tmp += '.' * width
        tmp += word_B[k]
        tmp += '.' * (len(word_A) - width - 1)
        ans.append(tmp)
        
for ans_line in ans:       
    print(ans_line)  
