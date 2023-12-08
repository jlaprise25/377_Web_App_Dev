file = open('day1.txt', 'r')
lines = file.readlines()

def partone():
    first = ' '
    last = ' '
    total = 0
    for line in lines:
        for x in line:
            if x.isdigit():
                first = x
                break
        for x in line[::-1]:
            if x.isdigit():
                last = x
                break

        total += int(first + last)
        

    print(total)

# def parttwo():
#     one = 'one'
#     two = 'two'
#     three = 'three'
#     four = 'four'
#     five = 'five'
#     six = 'six'
#     seven = 'seven'
#     eight = 'eight'
#     nine = 'nine'

#     first = ' '
#     last = ' '
#     total = 0
#     for line in lines:
#         for x in line:
#             if x.isdigit():
#                 first = x
#                 break

#             if x == 'o' or x == 't' or x == 'f' or x == 's' or x == 'e' or x == 'n':
                

#         for x in line[::-1]:
#             if x.isdigit():
#                 last = x
#                 break

#         total += int(first + last)
        

#     print(total)