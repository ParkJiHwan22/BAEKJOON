import sys
input = sys.stdin.readline

num, test = map(int, input().split())
pokemon_list = [input().strip('\n') for i in range(num)]
test_list = [input().strip('\n') for i in range(test)]

pokemon_dict = {}
for i in range(num):
    pokemon_dict[pokemon_list[i]] = str(i+1)
    pokemon_dict[str(i+1)] = pokemon_list[i]

for j in test_list:
    print(pokemon_dict[j])