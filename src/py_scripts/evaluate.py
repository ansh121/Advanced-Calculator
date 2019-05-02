import sys
import mpmath
from sympy import Symbol
from sympy.parsing.sympy_parser import parse_expr

file = open("input.txt",'r')
line = file.readline();

a = Symbol('a')
b = Symbol('b')
c = Symbol('c')
d = Symbol('d')

try:
    line = line.replace("^","**")
    exp = parse_expr(line)
    line = file.readline()
    aval = float(line)
    line = file.readline()
    bval = float(line)
    line = file.readline()
    cval = float(line)
    line = file.readline()
    dval = float(line)
    ans = exp.evalf(subs={a: aval, b: bval, c: cval, d: dval})
    ans = float(ans)
except:
    ans = 'Error'
    
if type(ans) == float:
    ans = str(ans)
    ans = ans.replace("e","*10^")

print(ans)
