board = [[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]]

def print_board(board):
    for col in board:
        a = ""
        for row in col:
                a += str(row)
        print(a)

# do not need to check right side, as there will be no queens placed there yet, due to recursion
def check(board, row, col):
    # Dont need to check column
    # Check current row upto current queen pos
    for i in range(col):
        if board[row][i] == 1:
            return False

    # Check upper left diagonal
    i=row-1
    j=col-1
    while(i >= 0 and j >= 0):
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1
    # check lower left diagonal
    i = row+1
    j = col-1
    while(i < 8 and j >= 0):
        if board[i][j] == 1:
            return False
        i+=1
        j-=1
    # if no attacks found, return true
    return True

def solve(board, col):
    var b = False
    #If all queens are placed then return true
    if col >= 8:
        return True

    for i in range(8):
        #check if you can place queen
        b = check(board, i, col)
        if b:
            # Place queen
            board[i][col]=1

            # recurse to place rest of the queens
            b = solve(board, col+1)
            if b:
                return True

            # if recursion doesnt work, remove queen from position
            board[i][col]=0

    # if the queen can not be placed anywhere then return false
    return False

solve(board, 0)
print_board(board)
