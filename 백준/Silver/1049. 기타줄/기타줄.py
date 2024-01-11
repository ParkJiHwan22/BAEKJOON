n, m = map(int, input().split())
check = [1e7 for _ in range(n+1)]
check[0] = 0

for i in range(m):
    six_lines, one_line = map(int, input().split())
    
    for j in range(1, n+1):
        if j < 6:
            check[j] = min(check[j], check[j - 1] + one_line, six_lines)
        else:                
            check[j] = min(check[j], check[j - 1] + one_line, check[j - 6] + six_lines)

print(check[n])