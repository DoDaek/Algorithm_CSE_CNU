import sys

n,m = map(int, input().split(" "))

count = 0
subjects = []

for i in range(n):
    p,l = map(int, sys.stdin.readline().strip().split(" "))
    op = list(map(int, sys.stdin.readline().strip().split(" ")))
    op.sort()
    op.reverse()
    if p > l:
        minPoint = op[l-1]
    elif p == l:
        minPoint = op[p-1]
    else:
        minPoint = 1
    subjects.append(minPoint)

subjects.sort()
ans = 0
doit = 0
for i in range(len(subjects)):
    doit += subjects[i]
    if doit <= m:
        ans +=1
    else:
        break
print(ans)