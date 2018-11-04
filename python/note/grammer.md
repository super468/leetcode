# Python Grammer
## lambda
lambda : an anonymous function
```python
f = lambda x : x + 5
print(f(5)) # 10
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




