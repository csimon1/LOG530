
def fact(n):
    """Return n factorial"""
    product = 1
    for ii in range(2, n + 1):
        product *= ii
    return product

l = lambda x: -x
a = [1 for x in range(10)]
b = (x for x in range(10))

def blah(x):
    yield x
    yield x+1
c = list(blah(4))

print 'subsub:'
print l(3)

GLOBAL = 'global'

class helper():
  flag=0
  @staticmethod
  def enable(flag):
    helper.flag=flag
    print 'enabled'

class aa(object):
  def __init__(self):
    print "init a"
    aa=[1,2]
    for i in aa:
      print i

  def hoppa(self):
    x = GLOBAL
    print x
    helper.enable(1)
