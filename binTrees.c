#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct node {
  struct node* children;
  int childrenNo;
  int childrenCap;
  char letter; 
};

void* initReallocChildren(struct node* children, int oldChildrenNo, int newChildrenNo) {
  children = realloc(children, sizeof(struct node) * newChildrenNo);
  memset(children + oldChildrenNo, 0, (newChildrenNo - oldChildrenNo) * sizeof(struct node));
  return children;
}

struct node* createNode(int childrenCap) {
  struct node* newNode = (struct node*) malloc(sizeof(struct node));
  if (newNode == NULL) {
    perror("no memory");
  }
  newNode -> childrenCap = childrenCap;
  newNode -> children = (struct node*) malloc(sizeof(struct node) * childrenCap);
  if (newNode -> children == NULL) {
    perror("no memory");
  }
  newNode -> letter = 0;
  newNode -> childrenNo = 0;
  return newNode;
}

void growCap(struct node* node) {
  int newCap = node->childrenCap * 2;
  (node -> children) = (struct node*) initReallocChildren(node -> children, node->childrenCap, newCap);
  node->childrenCap = newCap;
}

void addChild(struct node* a_node, char letter) {
  (a_node -> childrenNo) ++;
  if ((a_node -> childrenNo) >= (a_node -> childrenCap)) {
    growCap(a_node);
  }
  ((a_node -> children) + ((a_node -> childrenNo) - 1)) -> letter = letter;
}

void pre_order(struct node* a_node) {
  printf("%c", a_node -> letter);
  for (int i = 0; i < a_node -> childrenNo; i++) {
    pre_order((a_node -> children) + i);
  }
}

void post_order(struct node* a_node) {
  for (int i = 0; i < a_node -> childrenNo; i++) {
    post_order((a_node -> children) + i);
  }
  printf("%c", a_node -> letter);
}

int main() {
  int const size = 3;
  struct node* root = createNode(1);
  char letters[] = {'a', 'b', 'c'};
  for (int i = 0; i < size; i++) {
    addChild(root, letters[i]);
  }
  addChild(root -> children, 'd');
  pre_order(root);
  printf("\n");
  post_order(root);
  return 0;
}
