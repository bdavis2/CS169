board = [[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]]
def print_board(board):
    for col in board:
        a = ""
        for row in col:
                a += str(row)
        print(a)
def check(board, row, col):
    #do not need to check column
    #check to the left of the queen on the same row
    for i in range(col):
        if(board[row][i] == 1):
            return False
    #do not need to check the right side, as there are not queens in front yet
    #to the left
    #check left upper diag (-1,+1)
    i = row-1
    j = col-1
    
    while(j >= 0 and i >= 0):
        if(board[i][j] == 1):
            return False
        i-=1
        j-=1
        

    #check left lower diag (-1,-1)
    j = col-1
    i = row+1
    while(j >= 0 and i < 8):
        if(board[i][j] == 1):
            return False
        j-=1
        i+=1

    return True
def solve(board, col):
    #if we've reached
    if col >= 8:
        return True
    for i in range(8):
        if(check(board, col, i)):
            board[i][col] = 1
            if solve(board, col+1) == True:
                return True
            board[i][col] = 0
    return False
solve(board, 0)
print_board(board)
