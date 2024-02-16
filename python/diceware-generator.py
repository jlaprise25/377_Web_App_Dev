import random

word_lookup = {}

file = open('diceware-wordlist.txt', 'r')
lines = file.readlines()
for line in lines:
    if line[0].isdigit():
        code, word = line.split()
        word_lookup[code] = word

password = ''
code = ''
for i in range(int(input('Enter # of words: '))):
    for i in range(5):
        num = random.randint(1,6)
        code += str(num)
    password += word_lookup[code] + ' '
    code = ''

print(password) 
