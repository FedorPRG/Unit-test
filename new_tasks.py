import doctest
def avg(args):
    if not isinstance(args,list):
        raise TypeError
    sum = 0
    for i in args:
        sum+=i
    return sum/len(args)

#print(avg([1,2,3]))

def div(a,b):
    if b==0:
        raise ZeroDivisionError
    return a/b

def multy(a,b):
    return a*b

def length(a):
    return len(a)

def square(n):
    """
    >>> square(2)
    4
    >>> square(3)
    9
    >>> square(4)
    16
    >>> square(5)
    25
    """
    return n*n

def is_prime(n):
    if n == 2 or n == 1:
        return True
    for i in range(2, n):
        if n % i == 0:
            return False
        return True