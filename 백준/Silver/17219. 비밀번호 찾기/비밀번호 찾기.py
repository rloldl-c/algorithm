import sys

input = sys.stdin.readline

save, search = map(int, input().split())
id_dict = {}

for i in range(save):
    site = input().split()
    id_dict[site[0]] = site[1]
    
for i in range(search):
    site = input().strip()
    print(id_dict.get(site))