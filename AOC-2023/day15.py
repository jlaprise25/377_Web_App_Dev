file = open('day15.txt', 'r')
lines = file.readlines()



for line in lines:

    words = line.split(',')
    print(words)