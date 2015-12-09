w1 = "smarkirm"
w2 = "marker"

lookup = {}

def matchStrings(p1, p2, b1, b2, s1, s2, score, memoise):
    #if memoise:
    #    key = s1 + "|" + s2
    #    if key in lookup:
    #        return lookup[key]
    while b1 and b2:
        if b1[0] != b2[0]:
            score += 1
        p1 += b1[0]
        p2 += b2[0]
        b1 = b1[1:]
        b2 = b2[1:]
    if not s1 and not s2:
        if b1:
            #if len(b2) != 0:
               #print("shit", b1, b2)
            score += len(b1)
            return (score, p1 + b1, p2 + " " * len(b1))
        if b2:
            #if len(b1) != 0:
               #print("shit", b1, b2)
            score += len(b2)
            return (score, p1 + " " * len(b2), p2 + b2)
    bestWay = []
    if s1:
        b1 += s1[0]
        s1 = s1[1:]
        nextResult = matchStrings(p1, p2, b1, b2, s1, s2, score, memoise)
        bestWay.append(nextResult)
    if s2:
        b2 += s2[0]
        s2 = s2[1:]
        nextResult = matchStrings(p1, p2, b1, b2, s1, s2, score, memoise)
        bestWay.append(nextResult)
    if not b2 or b2[0] != " ":
        bestWay.append(matchStrings(p1, p2, b1 + " ", b2, s1, s2, score, memoise))
    if not b1 or b1[0] != " ":
        bestWay.append(matchStrings(p1, p2, b1, b2 + " ", s1, s2, score, memoise))
    bestResult = min(bestWay, key=lambda tupla: tupla[0])
    #if memoise:
    #    lookup[key] = bestResult
    return bestResult

print(matchStrings("", "", "", "", w1, w2, 0, True))
