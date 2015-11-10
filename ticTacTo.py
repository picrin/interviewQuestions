from copy import deepcopy
size = 3

board = [[0 for i in range(size)] for i in range(size)]

playerA = "X"
playerB = "O"

def gameFinished(board):
    try:
        next(generateMoves(board))
        return False
    except StopIteration as e:
        return True

def generateMoves(board):
    for rowI, row in enumerate(board):
        for valueI, value in enumerate(row):
             if value == 0:
                 yield (rowI, valueI)

def isBoardWon(player, board):
    row0  = [(0, 0), (0, 1), (0, 2)]
    row1  = [(1, 0), (1, 1), (1, 2)]
    row2  = [(2, 0), (2, 1), (2, 2)]
    col0  = [(0, 0), (1, 0), (2, 0)]
    col1  = [(0, 1), (1, 1), (2, 1)]
    col2  = [(0, 2), (1, 2), (2, 2)]
    diag0 = [(0, 0), (1, 1), (2, 2)]
    diag1 = [(0, 2), (1, 1), (2, 0)]
    for threes in [row0, row1, row2, col0, col1, col2, diag0, diag1]:
        if all([board[i[0]][i[1]] == player for i in threes]):
            return True
    return False

boards = 0
def winsDrawFail(playerFirst, playerSecond, board):
    global boards
    boards += 1
    if isBoardWon(playerFirst, board):
        return True
    if isBoardWon(playerSecond, board):
        return False
    if gameFinished(board):
        return None
    results = []
    for move in generateMoves(board):
        newBoard = deepcopy(board)
        newBoard[move[0]][move[1]] = playerFirst
        results.append(winsDrawFail(playerSecond, playerFirst, newBoard))
    for result in results:
        if result is True:
            return False
    for result in results:
        if result is None:
            return None
    for result in results:
        if result is False:
            return True
    return None
print(winsDrawFail(playerA, playerB, board))
print(boards)
