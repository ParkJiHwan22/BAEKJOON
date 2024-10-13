m , n = map(int, input().split())
myList = list(map(int, input().split()))
for i in range(n):
    myQuery = list(map(int,input().split()))
    if myQuery[0] == 1:
        print(sum(myList[myQuery[1]-1:myQuery[2]]))
        tmp = myList[myQuery[1]-1]
        myList[myQuery[1]-1] = myList[myQuery[2] - 1]
        myList[myQuery[2] - 1] = tmp
    if myQuery[0] == 2:
        print(sum(myList[myQuery[1] - 1:myQuery[2]]) - sum(myList[myQuery[3] - 1:myQuery[4]]))
