K = int(input())

pattern = [
    "G...",
    ".I.T",
    "..S."
]

expanded_pattern = []

for line in pattern:
    expanded_line = ""
    
    for char in line:
        expanded_line += char * K
    
    for _ in range(K):
        expanded_pattern.append(expanded_line)

for line in expanded_pattern:
    print(line)