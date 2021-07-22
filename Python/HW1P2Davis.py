
def report(xs):
    namelist = ""
    lastname = ""
    totalscore = 0
    total = 0
    for x in xs:
        if(isinstance(x, str)): 
            namelist += lastname # if x is a string, the last string in the list was not a lastname, so append it to the report
            lastname = x
        else: # x must be an int, by problem definition
            totalscore += x
            total+=1
            namelist += ", "  # if x is an int, then the last x was a last name, and do not append it to the report
            lastname = "" # reset lastname
    return namelist + "averaged " + str(totalscore/total) # average the scores, reutrn namelist
print(report(["Jill", "Johnson", 87, "Billy", "Ray", "Cyrus", 78, "Rita", "Yeats", 94, "Bobbie", "Sue", "Palmer", 72]))
            
        
