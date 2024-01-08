n = int(input())
num_lst = []
for _ in range(n):
    num_lst.append(str(input()))
    
for i in range(1, len(num_lst[0]) + 1):
    
    results = []
    for j in range(n):
        if num_lst[j][-i:] in results:
            break
        else:
            results.append(num_lst[j][-i:])
            
    if len(results) == n:
        print(i)
        break