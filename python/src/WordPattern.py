def wordPattern(self, pattern, str):
    s = pattern
    t = str.split()
    return map(s.find, s) == map(t.index, t)

def wordPattern2(self, pattern, str):
    f = lambda s: map({}.setdefault, s, range(len(s)))
    return f(pattern) == f(str.split())