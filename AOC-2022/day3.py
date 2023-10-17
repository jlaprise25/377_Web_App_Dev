file = open('day3.txt', 'r')
lines = file.readlines()

def part1():
    total = 0
    for line in lines:
        line = line.strip()
        
        length = len(line)

        compartment_1 = line[:length // 2]
        compartment_2 = line[length // 2 :]

        for letter in compartment_1:
            if letter in compartment_2:
                print("Found duplicate: " + letter)
                if ord(letter) < 96:
                    value = ord(letter) - 64 + 26
                else:
                    value = ord(letter) - 96
                total += value
                break

    print(total)

def part2():
    total = 0
    for line in lines:
        line = line.strip()
        
        length = len(line)

        

        # for letter in compartment_1:
            # if letter in compartment_2:
            #     if letter in 
            #     print("Found duplicate: " + letter)
            #     if ord(letter) < 96:
            #         value = ord(letter) - 64 + 26
            #     else:
            #         value = ord(letter) - 96
            #     total += value
            #     break

    print(total)