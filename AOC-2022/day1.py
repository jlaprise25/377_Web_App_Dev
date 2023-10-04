file = open('day1.snippet', 'r')
lines = file.readlines()

total = 0
for line in lines:
    line = line.strip()

    if line == '':
        print('New Elf!')
        print('last elf was carrying '+ str(total))
        total = 0
    else:
        total += int(line)

print('New Elf!')
print('last elf was carrying '+ str(total))
total = 0