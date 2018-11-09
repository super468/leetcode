# Python Grammer
## lambda
lambda : an anonymous function
```python
f = lambda x : x + 5
print(f(5)) # 10
```

## Slice Notation
```python
a[start:end] # items start through end-1
a[start:]    # items start through the rest of the array
a[:end]      # items from the beginning through end-1
a[:]         # a copy of the whole array
```
There is also the `step` value, which can be used with any of the above:
```python
a[start:end:step] # start through not past end, by step
```
The key point to remember is that the `:end` value represents the first value that is not in the selected slice. So, the difference beween `end` and `start` is the number of elements selected (if `step` is 1, the default).

The other feature is that `start` or `end` may be a negative number, which means it counts from the end of the array instead of the beginning. So:
```python
a[-1]    # last item in the array
a[-2:]   # last two items in the array
a[:-2]   # everything except the last two items
```
Similarly, `step` may be a negative number:
```python
a[::-1]    # all items in the array, reversed
a[1::-1]   # the first two items, reversed
a[:-3:-1]  # the last two items, reversed
a[-3::-1]  # everything except the last two items, reversed
```
## Sort
* sorted() return a new ordered iterable object
    * parameter: sorted(key=function)
      ```python
      test_list=[
        test('Tom', 17),
        test('Jeff', 16)
      ]
      sorted(test_lsit, key=lambda test: test.age)
      ```
      ```python
      [('Jeff', 16),('Tom', 17)]
      ```
* list.sort() in place sort
## Min Heap
min heap is a binary tree that each node is less than or equal to any of its children.  
`heap[k] <= heap[2k] && heap[2k+1] and heap[k] >= heap[k/2]`  
To create a heap, use a list initialized to `[]`, or you can transform a populated list into a heap via function `heapify()`.  
```python
>>> def heapsort(iterable):
...     h = []
...     for value in iterable:
...         heappush(h, value)
...     return [heappop(h) for i in range(len(h))]
...
>>> heapsort([1, 3, 5, 7, 9, 2, 4, 6, 8, 0])
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```

## Join
`string.join()` instead of `list.join()`. Because join is a string method

## Built-in Function
### iter()
```python
    iter()
    """
    :param a collection object
    :return a iterable object
    """
```
### next()
```python
    next()
    """
    Retrieve the next item from the iterator by calling its next() method. 
    :param iterator
    :return value
    """
```
### any()
Return True if any element of the iterable is true. If the iterable is empty, return False.Equivalent to:
```python
def any(iterable):
    for element in iterable:
        if element:
            return True
    return False
```

### map()
map() function returns a list of the results after applying the given function to each item of a given iterable (list, tuple etc.)
```python
numbers = (1, 2, 3, 4) 
result = map(lambda x: x + x, numbers) 
print(list(result)) 
```
Output
```python
{2, 4, 6, 8}
```

## String Function
### find()
It determines if string str occurs in string, or in a substring of string if starting index beg and ending index end are given.

```python
str1 = "this is string example....wow!!!";
str2 = "exam";

print str1.find(str2)
print str1.find(str2, 10)
print str1.find(str2, 40)

```
Output
```python
15
15
-1
```

## List Funciton
### index()
In simple terms, index() method finds the given element in a list and returns its position.

However, if the same element is present more than once, index() method returns its smallest/first position.


```python
list = ['a','a']
list.index('a')
```
Output
```python
0
```

## Dictionary Function
### setdefault(key,default=None)
The method setdefault() is similar to get(), but will set dict[key]=default if key is not already in dict.

* key − This is the key to be searched.

* default − This is the Value to be returned in case key is not found.

This method returns the key value available in the dictionary and if given key is not available then it will return provided default value.
```python
a ={}
a.setdefault('a',1)
a.setdefault('a',2)
```
Output
```python
1
1
```

### collection.defaultdict
`defaultdict` means that if a key is not found in the dictionary, then instead of a `KeyError` being thrown, a new entry is created. The type of this new entry is given by the argument of defaultdict.

For example:
```python
somedict = {}
print(somedict[3]) # KeyError

someddict = defaultdict(int)
print(someddict[3]) # print int(), thus 0
```