file = open('day6.txt', 'r')
lines = file.readlines()

def partone():
    # Iterate through each line
    for line in lines:
        # Split the line into words
        words = line.split()

        # Check if the line has words
        if len(words) > 0:
            # Extract the variable name and values
            variable_name = words[0].rstrip(':')
            values = [int(value) for value in words[1:]]

            # Assign the values to variables
            if variable_name == 'Time':
                time_variable = values
            elif variable_name == 'Distance':
                distance_variable = values
    total = 1
    for x in range(len(time_variable)):
        count = 0
        for y in range(time_variable[x]):
            speed = y
            distance = speed*(time_variable[x]-y) 
            if distance > distance_variable[x]:
                count += 1
        total = count * total

    print(total)

def parttwo():
    # Iterate through each line
    count = 0
    for line in lines:
        
        # for x in line:
        #     if x == ' ':
        
        for x in line:
            if not x.isdigit():
                if x == ' ':
                    line = line.replace(x ,'')   
        # Split the line into words
        words = line.split()

        
        # Check if the line has words
        if len(words) > 0:
            # Extract the variable name and values
            word = words[0].split(':')
            variable_name = word[0]
            # value = [int(value) for value in words[1:]]
            value = words[0].split(':')
            value = value[1]
            count += 1
            # Assign the values to variables
            if variable_name == 'Time':
                time_variable = int(value)
            elif variable_name == 'Distance':
                distance_variable = int(value)

    total = 1
    count = 0
    for y in range(time_variable):
        speed = y
        distance = speed*(time_variable-y) 
        if distance > distance_variable:
            count += 1
    total = count * total

    print(total)
# partone()
parttwo()