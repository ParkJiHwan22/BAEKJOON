num_1, num_2 = map(int, input().split())
chess_list = [input() for i in range(num_1)]
chess_wb = []
chess_bw = []
cnt_wb_list = []
cnt_bw_list = []

for i in range(8):
    if i % 2 == 0:
        chess_wb.append('BWBWBWBW')
        chess_bw.append('WBWBWBWB')
    else:
        chess_wb.append('WBWBWBWB')
        chess_bw.append('BWBWBWBW')

for l in range(num_1 - 7):
    for m in range(num_2 - 7):
        cnt_wb = 0
        for j in range(8):
            for k in range(8):
                if chess_list[j+l][k+m] != chess_wb[j][k]:
                    cnt_wb += 1
        
        cnt_wb_list.append(cnt_wb)

for l in range(num_1 - 7):
    for m in range(num_2 - 7):
        cnt_bw = 0
        for j in range(8):
            for k in range(8):
                if chess_list[j+l][k+m] != chess_bw[j][k]:
                    cnt_bw += 1

        cnt_bw_list.append(cnt_bw)

print(min(sorted(cnt_wb_list)[0], sorted(cnt_bw_list)[0]))