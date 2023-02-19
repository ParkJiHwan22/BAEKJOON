formula = input()
formula_new = ''; tmp = ''

for i in range(len(formula)): # 원소 x 숫자 먼저 정리
    if formula[i].isnumeric():
        if formula[i-1].isalnum():
           formula_new += formula[i-1] * (int(formula[i])-1)
        else:  
                formula_new += formula[i]
    else:
        formula_new += formula[i]

cnt, cnt_max = 0, 0 # 괄호의 최대 개수 구하기
for j in formula_new:  
    if j == '(':
        cnt += 1
        if cnt_max < cnt:
            cnt_max = cnt
    elif j == ')':
        cnt -= 1

cnt = 0
for i in range(cnt_max, -1, -1): # 괄호가 많은 쪽부터 차례대로 계산
    for j in range(len(formula_new)):
        if formula_new[j] == '(':
            cnt += 1
            tmp += formula_new[j]
        elif formula_new[j] == ')':
            cnt -= 1
            tmp += formula_new[j]
            
        elif cnt == i:
            if formula_new[j].isnumeric():
                cnt_zero = 0
                for k in range(j-1, -1, -1):
                    if formula_new[k] == '(':
                        cnt_zero += 1
                    elif formula_new[k] == ')':
                        cnt_zero -= 1
                    
                    if cnt_zero == 0:
                        tmp += formula_new[k:j] * (int(formula_new[j]) -1)
                        break

            else:
                tmp += formula_new[j]
        
        else: 
            tmp += formula_new[j]

    formula_new = tmp
    tmp = ''

chemical_dict = {'H':0, 'C':0, 'O':0}

for element in formula_new:
    if element in chemical_dict:
        chemical_dict[element] += 1

print( chemical_dict['H'] + chemical_dict['C']*12 + chemical_dict['O']*16) 