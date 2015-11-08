#include <stdlib.h>
#include <stdio.h>

int size = 4;
int* circularList;
int head = 0;
int tail = 0;

int moveHead() {
    if (head == tail) return -1; // trying to take elements from an empty list.
    return head = (head + 1) % size;
}

int moveTail() {
    if (tail + 1 == head) return -1; // we've exceed the size of the underlying array.
    return tail = (tail + 1) % size;
}

void printList() {
    int index = head;
    while (index != tail) {
         printf("%d ", circularList[index]);
         index = (index + 1) % size;
    }
    printf("\n");
}

int getFirst() {
    int toReturn = circularList[head];
    if (moveHead() == -1) {
        printf("error"); // TODO change to stderr stream.
        exit(1);
    }
    printList();
    return toReturn;
}

void putLast(int elem) {
    int previousTail = tail;
    if (moveTail() == -1) {
        printf("error");
        exit(1);
    }
    circularList[previousTail] = elem;
    printList();
}


int main (char** args, int argv) {
    circularList = malloc(sizeof(int*) * size);
    printList();
    putLast(4);
    putLast(3);
    //printf("%d", getFirst());
    getFirst();
    putLast(11);
    getFirst();
    putLast(9);
    getFirst();
    //putLast(10);
    return 0;
}
