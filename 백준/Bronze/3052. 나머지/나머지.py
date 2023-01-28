num_list = [int(input()) for i in range(10)]
remainder = []
for i in num_list:
    remainder.append(i % 42)

print(len(set(remainder)))