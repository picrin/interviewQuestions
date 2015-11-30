#include <stdlib.h>
#include <stdio.h>

unsigned long int simpleHash(char* strInput) {
  char c;
  unsigned long int hash = 0;
  while (*strInput != '\0') {
    c = *strInput;
    hash = c + (hash << 6) + (hash << 16) - hash;
    strInput++;
  }
  return hash;
}

int main() {
  printf("%lu\n", simpleHash("adam likes iva"));
  return 0;
}
