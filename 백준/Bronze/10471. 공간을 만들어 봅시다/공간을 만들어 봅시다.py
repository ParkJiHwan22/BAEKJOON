def find_possible_room_widths(W, P, partitions):
    partitions = [0] + partitions + [W]
    
    unique_widths = set()
    
    for i in range(len(partitions)):
        for j in range(i + 1, len(partitions)):
            width = partitions[j] - partitions[i]
            unique_widths.add(width)
    
    sorted_widths = sorted(unique_widths)
    
    return sorted_widths

W, P = map(int, input().strip().split())
partitions = list(map(int, input().strip().split()))

result = find_possible_room_widths(W, P, partitions)

print(" ".join(map(str, result)))