import collections as c
class Node:
    def __init__(self, char = ""):
        self.char = char
        self.children = []
        self.last = False
    def isNext(self, char):
        for i, child in enumerate(self.children):
            if child.char == char:
                return i
    def addChar(self, char):
        nexta = self.isNext(char)
        if nexta is not None:
            return self.children[nexta]
        newNode = Node(char)
        self.children.append(newNode)
        return newNode
    def addWord(self, word):
        if word:
            firstChar = word[0]
            nextNode = self.addChar(firstChar)
            nextNode.addWord(word[1:])
            if not word[1:]:
                nextNode.last = True
    def __getitem__(self, word):
       currentNode = self
       while word:
            #print(currentNode.char)
            nexta = currentNode.isNext(word[0])
            if nexta is None:
                return False
            currentNode = currentNode.children[nexta]
            word = word[1:]
       return currentNode.last == True
    def preOrder(self):
        for node in self.children:
            print(node.char)
            node.preOrder()
    def breadthFirst(self):
        q = c.deque()
        q.append(self)
        while q:
            rightMost = q.pop()
            print(rightMost.char)
            for child in rightMost.children:
                q.appendleft(child)

a = Node()
a.addWord("hello")
a.addWord("hi")
a.addWord("ello")
#a.preOrder()
#a.breadthFirst()
print(a["hello"])
print(a["hi"])
print(a["ello"])
print(a["hell"])
print(a["pancake"])
