n, B, H, W = map(int, input().split())
min_cost = 500001

for i in range(H):
    cost = int(input())
    customer_lst = list(map(int, input().split()))
    
    if max(customer_lst) >= n and B >= cost * n:
        if min_cost > cost * n:
            min_cost = cost * n

if min_cost == 500001:
    print('stay home')
else:
    print(min_cost)