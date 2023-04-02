n = int(input())
code = input()
decode = {
    "000000" : "A",
    "001111" : "B",
    "010011" : "C",
    "011100" : "D",
    "100110" : "E",
    "101001" : "F",
    "110101" : "G",
    "111010" : "H",    
}

tmp, save = [], []
for i in code:
    tmp.append(i)
    if len(tmp) == 6:
        save.append("".join(tmp))
        tmp.clear()
        
res = []
for j in save:
    plus = 0
    for val in decode:
        cnt = 0
        for k in range(len(val)):
            if j[k] != val[k]:
                cnt += 1
            
            if cnt == 2:
                break
        
        if cnt < 2:
            res.append(val)
            plus += 1
    
    if plus == 0:
        print(save.index(j)+1)
        break

if plus != 0:    
    for l in res:
        print(decode[l], end='')
    