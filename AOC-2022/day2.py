def part1 ():

    file = open('day2.txt', 'r')
    lines = file.readlines()

    total = 0
    for line in lines:
        throws = line.strip().split(' ')

        print(throws[0] + ' vs ' + throws[1])

        if throws[1] == 'X':
            throws[1] = 'A'
            total += 1
        elif throws[1] == 'Y':
            total += 2
            throws[1] = 'B'
        else:
            throws[1] = 'C'
            total += 3


        if throws[0] == throws[1]:
            total += 3
        
        if  (throws[0] == 'A' and throws[1] == 'B') or \
            (throws[0] == 'B' and throws[1] == 'C') or \
            (throws[0] == 'C' and throws[1] == 'A'):
            total += 6

    print(total)



def parttwo():
    file = open('day2.snippet', 'r')
    lines = file.readlines()

    total = 0
    for line in lines:
        throws = line.strip().split(' ')

        print(throws[0] + ' for result ' + throws[1])
        
        yourThrow = ''

        for elfThrow in throws[0]:
            if elfThrow == 'A':
                for result in throws[1]:
                    if  result == '':
                        yourThrow = ''
            

        

parttwo()
    

        