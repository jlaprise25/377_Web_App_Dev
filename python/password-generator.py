import random

SPECIALS = '~!@#$%^&*()_+`=-'';.,|}{":?><"}\\'
string = ''
for i in range(10):
    digit = random.randint(0,9)
    string += str(digit)

for i in range(5):
    letter = chr(ord('A') + random.randint(0,25))
    string += letter

for i in range(5):
    letter = chr(ord('a') + random.randint(0,25))
    string += letter

for i in range(5):
    special = SPECIALS[random.randint(0,len(SPECIALS) - 1)]
    string += special
    
def num():
    return str(random.randint(0,9))

def uppercase():
    return chr(ord('A') + random.randint(0,25))

def lowercase():
    return chr(ord('a') + random.randint(0,25))

def specials():
    return SPECIALS[random.randint(0,len(SPECIALS) - 1)]

length = int(input('Enter password length: '))
password = []
include_digit = input('Include digit [Y/N]: ')
if include_digit == 'Y':
    password.append(num()) 
    length -= 1

include_upper = input('Include uppercase letter [Y/N]: ')
if include_upper == 'Y':
    password.append(uppercase())
    length -= 1

include_lower = input('Include lowercase letter [Y/N]: ')
if include_lower == 'Y':
    password.append(lowercase())
    length -= 1

include_special = input('Include special character [Y/N]: ')
if include_special == 'Y':
    password.append(specials())
    length -= 1

for i in range(length):
    typechar = random.randint(0,3)
    if typechar == 0:
        password.append(num())
    elif typechar == 1:
        password.append(uppercase())
    elif typechar == 2:
        password.append(lowercase())
    elif typechar == 3:
        password.append(specials())

random.shuffle(password)
print(''.join(password))
    

