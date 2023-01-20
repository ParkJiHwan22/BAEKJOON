n = input()
num = int(n)
num_list = []

if len(n) <= 3:
    for i in range(num):
        i_sum = 0
        for j in str(i):
            i_sum += int(j)
        if num == int(i) + i_sum:
            num_list.append(i)
            
    
if len(n) > 3:
    for i in range(num-100, num):
        i_sum = 0
        for j in str(i):
            i_sum += int(j)
        if num == int(i) + i_sum:
            num_list.append(i)

if num_list == []:
    print(0)
        
else:
    print(num_list[0])