A, B = map(int, input().split())
A_list = list(map(int, input().split()))
B_list = list(map(int, input().split()))
A_dict = {}
B_dict = {}

for i in A_list:
    A_dict[i] = 0

for i in B_list:
    B_dict[i] = 0

cnt_A = 0
for i in A_list:
    if i not in B_dict:
        cnt_A += 1

cnt_B = 0
for i in B_list:
    if i not in A_dict:
        cnt_B += 1

print(cnt_A + cnt_B)