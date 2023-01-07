
dict_a = {}
a = 0
b = 0
cnt_z = 0
cnt = 0
cnt_t = -1


c = int(input())
for i in range(c):
    num = list(map(int, input().split()))
    for j in num:
        cnt_z += 1
        if cnt_z == 1:
            a += j
        else:
            b += int(j)
    for j in num:
        cnt_t += 1
        if cnt_t != 0:
            if j > b/a:
                cnt += 1

   
    print(f"{cnt*100/cnt_t:.3f}%")
    a = 0
    b = 0
    cnt_z = 0
    cnt = 0
    cnt_t = -1