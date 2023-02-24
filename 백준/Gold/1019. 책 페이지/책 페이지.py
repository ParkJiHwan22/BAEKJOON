n = input()

book_dic = {0:0, 1:0, 2:0, 3:0, 4:0, 5:0, 6:0, 7:0, 8:0, 9:0}

for k in range(len(n)-1):
    unit = int('1'+'0'*(len(n)-k-1))
    num = int(n) - unit + 1 # 모든 자릿수가 나오는 총 개수
    t = num // unit # 각 자릿수마다  나오는 개수
    p = t % 10 # 각 자릿수가 돌고 멈추는 위치
    
    for x in range(1, 11):
        book_dic[x % 10] += (num - (num % (unit*10)))//10
            
    for y in range(1, p+1):
        book_dic[y % 10] += unit
                    
    book_dic[int(n[k])] += num % unit
            
for a in range(1, 11):
    book_dic[a % 10] += int(n)//10
        
for b in range(1, (int(n)%10)+1):
    book_dic[b % 10] += 1


for res in range(0, 10):
    print(book_dic[res], end = ' ')
