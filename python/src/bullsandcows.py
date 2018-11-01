class Solution:
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        bulls = 0
        cows = 0
        smap = {}
        gmap = {}
        for i in range(0, len(secret)):
            s = secret[i]
            g = guess[i]
            if s == g:
                bulls += 1
            else:
                if s in smap.keys():
                    smap[s] += 1
                else:
                    smap[s] = 1
                if g in gmap.keys():
                    gmap[g] += 1
                else:
                    gmap[g] = 1
        for i in range(0, 10):
            
            if i in gmap.keys() and i in smap.keys():
                cows += gmap[i] if gmap[i] < smap[i] else smap[i]

        return "%dA%dB" % (bulls, cows)


if __name__ == "__main__":
    s = Solution()
    print(s.getHint('1807', '7810'))