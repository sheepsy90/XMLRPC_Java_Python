import xmlrpclib
import random
import time

proxy = xmlrpclib.ServerProxy("http://localhost:8099/RPC2")

t = 0
count = 1000
for i in range(count):
    a = time.time()
    g = proxy.userService.insert(1, "1") #str(int(100000000000*random.random())))
    t += time.time() - a
    
print "Average: %s ms" % (str(1000*t/float(count)))


h = proxy.userService.show(0)
print h
