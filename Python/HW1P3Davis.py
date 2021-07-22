CONST_INPUT_SIZE = 10

def partition(inp, p, r ):
    pivot = inp[r]
    while(p < r):
        while(inp[p] < pivot):
            p+=1
        while(inp[r] > pivot):
            r-=1
        if(inp[p] == inp[r]):
            p+=1
        elif(p < r):
            tmp = inp[p]
            inp[p] = inp[r]
            inp[r] = tmp
    return r

def quicksort(inp, p, r):
    if(p < r):
        j = partition(inp, p, r)
        quicksort(inp, p, j-1)
        quicksort(inp, j+1, r)
        
inp = [500, 700, 800, 100, 300, 200, 900, 400, 1000, 600]
print("Input: ", inp)
quicksort(inp, 0,9)
print("Output: ", inp)
