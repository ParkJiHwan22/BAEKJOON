def fib(n):
    val = [0, 1]
    if n >= 2:
        for i in range(2, n+1):
            val.append(val[i-1] + val[i-2])  # 코드2
    return val[n]

def fibonacci(n):
    return n-2

n = int(input())
print(fib(n), fibonacci(n))