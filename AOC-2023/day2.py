file = open('day2.txt', 'r')
lines = file.readlines()

def partone():
    mg = 13
    mr = 12
    mb = 14
    total = 0
    game = 1
    valid = True

    for line in lines:
        valid = True
        for round in line.split(':')[1].split(';'):
            for color_count in [ x.strip() for x in round.split(',') ]:
                # print(color_count)
                count, color = [entry.strip() for entry in color_count.split(' ')]

                count = int(count)
                if color == 'red':
                    if count > mr:
                        valid = False
                elif color == 'blue':
                    if count > mb:
                        valid = False
                elif color == 'green':
                    if count > mg:
                        valid = False
        
        if valid:
            total += game
        game += 1
    
        
    print(total)

def parttwo():
    total = 0

    for line in lines:
        tr = 0
        tg = 0
        tb = 0
        for round in line.split(':')[1].split(';'):
            for color_count in [ x.strip() for x in round.split(',') ]:
                print(color_count)
                count, color = [entry.strip() for entry in color_count.split(' ')]
                # print(count)
                count = int(count)
                if color == 'red':
                    if count > tr:
                        tr = count
                    # count = 0
                elif color == 'blue':
                    if count > tb:
                        tb = count
                elif color == 'green':
                    if count > tg:
                        tg = count
        # print(tb)
        # print(tg) 
        # print(tr)           
        total += tr * tb * tg

    print(total)

# partone()
parttwo()