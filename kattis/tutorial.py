import math

line = input().split()
m = int(line[0])
n = int(line[1])
t = int(line[2])
factorials = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600]

if t is 1:
    if n > 12:
        runTime = m + 1
    else:
        runTime = factorials[n]
elif t is 2:
    runTime = pow(2,n)
elif t is 3:
    runTime = pow(n,4)
elif t is 4:
    runTime = pow(n,3)
elif t is 5:
    runTime = pow(n,2)
elif t is 6:
    runTime = n * math.log(n,2)
elif t is 7:
    runTime = n

if runTime > m:
    print("TLE")
else:
    print("AC")
