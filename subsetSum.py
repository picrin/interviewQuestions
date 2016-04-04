x = [0, 7, 3, 6, 4, 9, 11]
k = 26

b = [[False for j in range(k + 1)] for i in x]

b[0][0] = True

for i in range(len(x)):
     x_i = x[i]
     for j in range(k + 1):
         if i > 0:
             up = b[i-1][j]
         else:
             up = False
         if i > 0 and x_i <= j:
             left = b[i-1][j - x_i]
         else:
             left = False
         if i != 0 or j != 0:
             b[i][j] = left or up

if b[-1][-1]:
    current = k
    index = len(x) - 1
    for _, item in enumerate(x[::-1]):
        if index != 0:
            up = b[index - 1][current]
            if up:
                print "skip", item
            else:
                print "choose", item
                current = current - item
            index -= 1
        
        
