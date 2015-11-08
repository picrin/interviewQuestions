class Node:
    def __init__(self, value):
        self.value = value
        self.child = None
    def addNode(self, value):
        self.child = Node(value)
        return self.child
    def walkList(self):
        print(self.value, " ")
        if self.child is not None:
            self.child.walkList()
    def invertList(self):
        previousNode = self
        currentNode = previousNode.child
        previousNode.child = None
        while currentNode is not None:
            nextNode = currentNode.child
            currentNode.child = previousNode
            previousNode = currentNode
            currentNode = nextNode

head = Node(0)
tail = head.addNode(3)
tail = tail.addNode(11)
tail = tail.addNode(4)

head.walkList()
head.invertList()
print()
tail.walkList()

