import sys
from sympy import *
from sympy.parsing.sympy_parser import parse_expr

def Adj(A):
    return A.adjugate()

def Inv(A):
    return A**(-1)

def T(A):
    return A.transpose()
    
def det(A):
    return A.det()

def EigenVals(A):
    dic = A.eigenvals()
    line = '['
    for key in dic:
        for i in range(dic[key]):                
            line = line + '[' + str(key) + '], '
    line = line[:len(line)-2] + ']'
    return Matrix(parse_expr(line))

file = open("input.txt",'r')
out = open("output.txt",'w')

w = Symbol('w')
x = Symbol('x')
y = Symbol('y')
z = Symbol('z')

line = file.readline()
if line=='\n':
    wval='w'
else:
    wval = float(line)
    
line = file.readline()
if line=='\n':
    xval='x'
else:
    xval = float(line)
    
line = file.readline()
if line=='\n':
    yval='y'
else:
    yval = float(line)
    
line = file.readline()
if line=='\n':
    zval='z'
else:
    zval = float(line)

try:
    line = file.readline()
    if line != '\n' :
        line = line.replace("^","**")
        A = Matrix(parse_expr(line))
        A = A.subs({w: wval, x: xval, y: yval, z: zval})
    line = file.readline()
    if line != '\n' :
        line = line.replace("^","**")
        B = Matrix(parse_expr(line))
        B = B.subs({w: wval, x: xval, y: yval, z: zval})
    line = file.readline()
    if line != '\n' :
        line = line.replace("^","**")
        C = Matrix(parse_expr(line))
        C = C.subs({w: wval, x: xval, y: yval, z: zval})
    line = file.readline()
    if line != '\n' :
        line = line.replace("^","**")
        D = Matrix(parse_expr(line))
        D = D.subs({w: wval, x: xval, y: yval, z: zval})
    line = file.readline()
    line = line.replace("^","**")
    ans = eval(line)
    if str(type(ans)) == "<class 'sympy.matrices.dense.MutableDenseMatrix'>":
        ans = ans.subs({w: wval, x: xval, y: yval, z: zval})
        m,n=ans.shape
        for i in range(0,m):
            for j in range(0,n):
                val = parse_expr(str((ans.row(i).col(j)).det()))
                val = val.evalf()
                try:
                    val=float("{0:.6f}".format(val))
                except:
                    val=val
                val = str(val).replace('**','^')
                out.write(val+"   ")
            out.write('\n')
    else:
        ans = parse_expr(str(ans))
        ans = ans.subs({w: wval, x: xval, y: yval, z: zval})
        ans = ans.evalf()
        try:
            ans = float("{0:.6f}".format(ans))
        except:
            ans = ans
        out.write(str(ans))
    
            
except:
    out.write("Error")


