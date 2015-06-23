# __NOT macro missing parentheses
x=10
if not 1<x<10:
    print "out of constraint"

# enumerate start arg
print list(enumerate('hoppa', 2))

# ConfigParser.items model
import ConfigParser
p = ConfigParser.ConfigParser()
p.read("testdata/symbols.INI")
for entry in p.items("symbols"):
    print entry
items = p.defaults().items()
print items
sections = p.sections()
print sections

# os.listdir crash
import os
try:
    print os.listdir('/does/not/exist')
except OSError:
    print 'path does not exist!'

# itertools.izip missing constructor
import itertools
for a,b in itertools.izip(range(4), range(4)):
    print a+b

# qualify & add include for class name
from testdata import iec2
from testdata import d1541
IEC = iec2.IECBus()
hop = d1541.D1541(IEC, 8)
print hop.get_data()

# sys.exit case
import sys
sys.exit(7)
