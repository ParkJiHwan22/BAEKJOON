from math import gcd, lcm

a, b = map(int, input().split())
c, d = map(int, input().split())

numerator = a*(lcm(b,d)//b)+c*(lcm(b,d)//d) 
denominator = lcm(b,d)
gcd_num = gcd(numerator,denominator)
print(numerator//gcd_num, denominator//gcd_num)