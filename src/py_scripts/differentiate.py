import sys
import mpmath
from sympy import diff, Symbol
from sympy.parsing.sympy_parser import parse_expr

file = open("input.txt",'r')
line = file.readline();
a = Symbol('a')
b = Symbol('b')
c = Symbol('c')
d = Symbol('d')
x = Symbol('x')
try:
    line=line.replace("^","**")
    exp=parse_expr(line)
    line=file.readline()
    aval = float(line)
    line=file.readline()
    bval = float(line)
    line=file.readline()
    cval = float(line)
    line=file.readline()
    dval = float(line)
    ans = diff(exp, x)
    line = file.readline()
    if line != "\n":
        xval = parse_expr(line)
        ans = ans.subs(x, xval)
    ans = ans.subs([(a, aval), (b, bval), (c, cval), (d, dval)])
    try:
        ans = float(ans)
    except :
        ans = ans
    ans = str(ans)
    ans = ans.replace("e","*10^")
    ans = ans.replace('**','^')
except:
    ans = 'Error'
    
print(ans)
