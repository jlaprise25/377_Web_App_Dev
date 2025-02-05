file = open('day9.txt', 'r')
lines = file.readlines()

for line in lines:
    words = line.split()
    count = 0
    for x in words:
        nums = []
        nums.append(int(words[count]))
        count += 1
        print(count)

    print(nums)
    
    # for x in range(len(words)):
    #     next = []
    #     next.append(int(words[count + 1]) - int(words[count]))
    #     print(next)
    #     count += 1