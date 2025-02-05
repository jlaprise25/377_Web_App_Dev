file = open('day8.txt', 'r')
lines = file.readlines()

count = 0
directions = []
key = []
left = []
right = []
for line in lines:
    if count == 0:
        for x in line:
            directions.append(x)
        directions.remove('\n')
        count += 1
    elif count == 1:
        count += 1
    else:
        line ="".join(c for c in line if c.isalpha() or c.isspace())
        
        words = line.split()
    
        key.append(words[0])   
        left.append(words[1])
        right.append(words[2])

nkey = ''
# while True:
for x in range(3):
    for x in directions:
        # print(nkey)
        
        if count == 2:
            index = 0
        if x == 'L':
            for y in left:
                if y == key[index]:
                    nkey = y
                    index = left.index(y)
                    break
        elif x == 'R':
            for y in right:
                if y == key[index]:
                    nkey = y
                    index = right.index(y)
                    break
        count += 1

        if nkey == 'ZZZ':
            break


        
