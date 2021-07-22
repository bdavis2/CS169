# return the sum of two variables if they are BOTH int or BOTH str
def fun(x,y):
        if(isinstance(x, str) or isinstance(x, int)): #check x to see if  valid type
             #this is lazy, should also check if y is valid type, but it shouldn't matter
            if(type(x) == type(y)): #check 
                return x + y
            else:
                return "type mismatch \nx is: " + str(type(x)) + " and y is: " + str(type(x))
                
        else:
            return "x is of invalid type " + str(type(x)) + "\nvalid types are str and int"

print(fun(1,2))
print(fun("hi","there"))
print(fun("hi", 2))
print(fun(True, True)) # booleans are considered instances of ints
print(fun([1,2,3], "there"))

