n = int(input())
file_lst = []

file = input()
for a in file:
    file_lst.append(a)
    
for _ in range(n-1):
    new = input()
    
    for i in range(len(file)):
        if file_lst[i] != new[i]:
            file_lst[i] = '?'
            
print(''.join(file_lst))