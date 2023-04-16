chess_board = [input() for _ in range(8)]
line_cnt = 0
cnt = 0

for line in chess_board:
    line_cnt += 1
    if line_cnt % 2 == 1:
        for i in range(len(line)):
            if i % 2 == 0:
                if line[i] == 'F':
                    cnt += 1
    
    else:
        for j in range(len(line)):
            if j % 2 == 1:
                if line[j] == 'F':
                    cnt += 1

print(cnt)