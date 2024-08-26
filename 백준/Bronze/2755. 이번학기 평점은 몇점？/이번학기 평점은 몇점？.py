diction = {"A+":4.3, "A0":4.0, "A-":3.7, "B+":3.3, "B0":3.0, "B-":2.7,
	"C+":2.3, "C0":2.0, "C-":1.7, "D+":1.3, "D0":1.0, "D-":0.7, "F":0.0}

t = int(input())

count = 0
result = 0
for _ in range(t) :
  a, b, c = input().split()
  b = int(b)
  result += b * diction[c]
  count += b

print("%.2f" % (round(result/count + 10**-10, 2)))