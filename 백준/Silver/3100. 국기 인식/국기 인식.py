res = [0] * 26
flag_1 = [18] * 26
flag_2 = [18] * 26
flag_3 = [18] * 26
res_2 = [0] * 26
flag_4 = [18] * 26
flag_5 = [18] * 26
flag_6 = [18] * 26

for i in range(6):
    flag = input()

    for i_1 in flag[0:3]:
        flag_1[ord(i_1)-65] -= 1
        
    for i_2 in flag[3:6]:
        flag_2[ord(i_2)-65] -= 1
        
    for i_3 in flag[6:9]:
        flag_3[ord(i_3)-65] -= 1
        
    if i in [0, 1]:
        for i_4 in flag:
            flag_4[ord(i_4)-65] -= 1
    
    elif i in [2, 3]:
        for i_5 in flag:
            flag_5[ord(i_5)-65] -= 1
            
    elif i in [4, 5]:
        for i_6 in flag:
            flag_6[ord(i_6)-65] -= 1

for num in range(26):
    if num == 25:
        res[num] += flag_2[num] + min(flag_1[0:num]) + min(flag_3[0:num])
    elif num == 0:
        res[num] += flag_2[num] + min(flag_1[1:26]) + min(flag_3[1:26])
    else:
        res[num] += flag_2[num] + min(min(flag_1[0:num]), min(flag_1[num+1:26])) + min(min(flag_3[0:num]), min(flag_3[num+1:26]))

for num_2 in range(26):
    if num_2 == 25:
        res_2[num_2] += flag_5[num_2] + min(flag_4[0:num_2]) + min(flag_6[0:num_2])
    elif num_2 == 0:
        res_2[num_2] += flag_5[num_2] + min(flag_4[1:26]) + min(flag_6[1:26])
    else:
        res_2[num_2] += flag_5[num_2] + min(min(flag_4[0:num_2]), min(flag_4[num_2+1:26])) + min(min(flag_6[0:num_2]), min(flag_6[num_2+1:26]))

print(min(min(res) ,min(res_2)))