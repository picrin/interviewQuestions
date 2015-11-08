# find all solutions to the nQueensProblem.
import copy
import sys

if len(sys.argv) != 2:
    print("pass me chessboard size, like:", sys.argv[0], "4")
    sys.exit(1)
chessBoardSize = int(sys.argv[1])

def checkQueensAttack(rc1, rc2):
    print("checking", rc1, rc2)
    row1, col1 = rc1
    row2, col2 = rc2
    if row1 == row2:
        return not col1 == col2
    if col1 == col2:
	return True
    if row2 - row1 == col2 - col1:
        return True
    if row2 - row1 == col1 - col2:
	return True
    return False


def findQueensSolution(queensPositions):
    if len(queensPositions) == chessBoardSize:
        return queensPositions
    for currentColumn in range(0, chessBoardSize):
        newQueensPositions = copy.copy(queensPositions)
        newQueensPositions.append(currentColumn)
        allQueensFine = True
        for otherRow, otherColumn in enumerate(newQueensPositions):
            queensAttack = checkQueensAttack((len(newQueensPositions) - 1, currentColumn), (otherRow, otherColumn))
            print(queensAttack)
            if queensAttack:
                allQueensFine = False
                break
        if allQueensFine:
            result = findQueensSolution(newQueensPositions)
            if result is not None:
                return result
    return None
                        
print(findQueensSolution([]))
