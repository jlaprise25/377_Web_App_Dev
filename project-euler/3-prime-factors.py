def isPrime(x):
    for i in range(x):
        if x % i == 0:
            return False
        else:
            return True

x = 0
num = 600851475143

for i in range(num):
    if i % num == 0 and isPrime(i):
        gpf = x

print(gpf)