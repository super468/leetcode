"""
the basic idea is that track every movement of the first player, if the other player can not make a movement, then movement
the first player made is a winning movement.
the optimization is to use memorization to memorize the string state that we have seen.
this is a backtracking problem with memorization optimization
"""
class Solution1:
    mem = {}
    def canWin(self, s):
        if s not in self.mem:
            self.mem[s] = any(s[i:i+2]=='++' and not self.canWin(s[:i]+'--'+s[i+2:]) for i in range(len(s)-1))
        return self.mem[s]

class Solution2(object):
    def canWin(self, s):
        for i in range(len(s)-1):
            if s[i]=='+' and s[i+1]=='+' and not self.canWin(s[:i]+'--'+s[i+2:]): return True
        return False