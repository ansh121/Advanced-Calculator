import sys
import mpmath
from sympy import Symbol, integrate
from sympy.parsing.sympy_parser import parse_expr
from multiprocessing.connection import answer_challenge

file = open("input.txt",'r')
line = file.readline();
a = Symbol('a')
b = Symbol('b')
c = Symbol('c')
d = Symbol('d')
x = Symbol('x')
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
    line = file.readline()
    l1 = line;
    line = file.readline();
    l2 = line;
    if l1 == "\n" or l2=="\n":
        ans = integrate(exp, x)
    else :
        pval = parse_expr(l1)
        qval = parse_expr(l2)
        ans = integrate(exp, (x, qval, pval))
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
