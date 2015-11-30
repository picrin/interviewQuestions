prices = [17, 23, 10, 27, 22, 18, 11, 11, 18, 23, 18, 24]

def lte(a, b):
    return a <= b

def gte(a, b):
    return a >= b

def oppositeCmp(func):
    if func is lte:
        return gte
    else:
        return lte

def oppositeFunc(currentFunc, alternative1, alternative2):
    if currentFunc is alternative1:
        return alternative2
    if currentFunc is alternative2:
        return alternative1

def downUpFilter(lista, comparator):
    if len(lista) == 1:
        return [lista[0]]
    else:
        if comparator(lista[0], lista[1]):
            return [lista[0]] + downUpFilter(lista[1:], oppositeCmp(comparator))
        else:
            return downUpFilter(lista[1:], comparator)

def stockAccumulator(initialCash):
    v = {"shares": 0, "cash": initialCash}
    def buyAll(sharePrice):
        sharesNo = v["cash"] // sharePrice
        print("buying", sharesNo, "shares @", sharePrice, "price")
        v["shares"] += sharesNo
        v["cash"] -= sharesNo*sharePrice
        return v
    def sellAll(sharePrice):
        totalCash = v["shares"] * sharePrice
        print("selling", v["shares"], "shares @", sharePrice, "price")
        v["shares"] = 0
        v["cash"] += totalCash
        return v
    return buyAll, sellAll

def buySell(prices):
    buy, sell = stockAccumulator(prices[0])
    currentFunc = buy
    for price in prices:
        currentV = currentFunc(price)
        currentFunc = oppositeFunc(currentFunc, buy, sell) 
    return currentV

filtered = downUpFilter(prices, lte)
v = buySell(filtered)
print(v)

