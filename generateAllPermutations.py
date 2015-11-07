import sys

if len(sys.argv) != 2:
    print("you have to pass a size set as a number, like:", sys.argv[0], "4")
    sys.exit(1)

size = sys.argv[1]

setToPermute = [i + 1 for i in range(int(size))]

def generatePermutations(setToPermute, prefix):
    if len(setToPermute) == 0:
	yield prefix
    for i, _ in enumerate(setToPermute):
        newPrefix = prefix + " " + str(setToPermute[i])
        newSet = setToPermute[:i] + setToPermute[i + 1:]
        for permutation in generatePermutations(newSet, newPrefix):
            yield permutation



perms = generatePermutations(setToPermute, "")

for permutation in perms:
    print(permutation)
    
        

