import sys
input = sys.stdin.readline

def is_valid(board, row, col, num):
    for i in range(9):
        if board[row][i] == num:
            return False
        if board[i][col] == num:
            return False
        if board[(row // 3) * 3 + i // 3][(col // 3) * 3 + i % 3] == num:
            return False
    return True

def solve_sudoku(board):
    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                for num in range(1, 10):
                    if is_valid(board, i, j, num):
                        board[i][j] = num
                        if solve_sudoku(board):
                            return True
                        board[i][j] = 0
                return False
    return True

sdoku = [list(map(int, input().strip())) for _ in range(9)]
solve_sudoku(sdoku)

for line in sdoku:
    print("".join(map(str, line)))