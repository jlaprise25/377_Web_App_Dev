file = open('day4.txt', 'r')
lines = file.readlines()

total = 0
for line in lines:
    words = line.split('|')
    # print(words)
    if len(words) > 0:
        game = words[0].rstrip(':')
        
        yours = words[0].split()
        yours.pop(0)
        yours.pop(0)

        winners = words[1].split()
    count = 0
    temp = 0
    for x in winners:
        for y in yours:
            if y == x and count == 0:
                temp += 1
                count += 1
            elif y == x and count > 0:
                temp *= 2

    total += temp
        
print(total)