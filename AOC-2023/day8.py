file = open('day8.txt', 'r')
lines = file.readlines()

count = 0
directions = ''
# print(lines)
for line in lines:
    if count == 0:
        directions = line
        count += 1
    else:
    
        # line.replace('(', '')
        # line.replace(')', '')
        
        line = line.split()
        line.pop(1)

        print(line)  
    
            
