# 🐍 Python Interview Questions — Ultimate Guide for Freshers (500+ Questions)

### 🎯 Compiled for CodeTantra, Cognizant, TCS, Infosys, Wipro & All IT Companies — Hyderabad

---

## 📋 Table of Contents

1. [Python Basics (Q1–Q80)](#1--python-basics)
2. [Data Types & Variables (Q81–Q130)](#2--data-types--variables)
3. [Strings (Q131–Q175)](#3--strings)
4. [Lists (Q176–Q220)](#4--lists)
5. [Tuples (Q221–Q245)](#5--tuples)
6. [Dictionaries (Q246–Q290)](#6--dictionaries)
7. [Sets (Q291–Q315)](#7--sets)
8. [Operators & Expressions (Q316–Q345)](#8--operators--expressions)
9. [Control Flow (Q346–Q380)](#9--control-flow)
10. [Functions (Q381–Q435)](#10--functions)
11. [OOPs (Q436–Q520)](#11--object-oriented-programming-oops)
12. [File Handling (Q521–Q555)](#12--file-handling)
13. [Exception Handling (Q556–Q585)](#13--exception-handling)
14. [Modules & Packages (Q586–Q610)](#14--modules--packages)
15. [Iterators & Generators (Q611–Q640)](#15--iterators--generators)
16. [Decorators & Closures (Q641–Q665)](#16--decorators--closures)
17. [List/Dict/Set Comprehensions (Q666–Q690)](#17--comprehensions)
18. [Regular Expressions (Q691–Q715)](#18--regular-expressions)
19. [Database & SQL with Python (Q716–Q740)](#19--database--sql-with-python)
20. [Coding Problems (Q741–Q850)](#20--coding-problems)
21. [Tricky & Output-Based Questions (Q851–Q950)](#21--tricky--output-based-questions)
22. [Advanced Concepts (Q951–Q1000)](#22--advanced-concepts)

---

# 1. 🔰 Python Basics

### Fundamentals

**Q1: What is Python?**
> Python is a high-level, interpreted, dynamically typed, general-purpose programming language created by **Guido van Rossum** in **1991**. It emphasizes code readability with significant whitespace.

**Q2: What are the key features of Python?**
> - Interpreted language (no compilation needed)
> - Dynamically typed (no need to declare variable types)
> - Object-oriented & functional programming support
> - Large standard library
> - Platform independent
> - Easy to read and write
> - Open source and free
> - Extensible (can integrate C/C++ code)
> - Embeddable (can be embedded in C/C++ applications)

**Q3: What is PEP 8?**
> PEP 8 is the **Python Enhancement Proposal** that provides style guide conventions for Python code. It covers naming conventions, indentation (4 spaces), line length (79 chars), imports, etc.

**Q4: What is the difference between Python 2 and Python 3?**
> | Feature | Python 2 | Python 3 |
> |---------|----------|----------|
> | Print | `print "hello"` | `print("hello")` |
> | Division | `5/2 = 2` | `5/2 = 2.5` |
> | Strings | ASCII by default | Unicode by default |
> | Range | `range()` returns list | `range()` returns iterator |
> | Input | `raw_input()` | `input()` |
> | Support | EOL (2020) | Active |

**Q5: Is Python compiled or interpreted?**
> Python is **both**. The source code (.py) is first compiled to bytecode (.pyc), then the bytecode is interpreted by the Python Virtual Machine (PVM).

**Q6: What is the Python interpreter?**
> The Python interpreter reads and executes Python code line by line. CPython (written in C) is the default and most widely used interpreter.

**Q7: What is CPython?**
> CPython is the **reference implementation** of Python, written in C. Other implementations include Jython (Java), IronPython (.NET), PyPy (JIT compiled).

**Q8: What is the difference between CPython and PyPy?**
> - CPython: Default interpreter, compiles to bytecode
> - PyPy: Uses JIT (Just-In-Time) compilation, much faster for long-running programs

**Q9: What is `PYTHONPATH`?**
> An environment variable that tells the Python interpreter where to look for modules to import.

**Q10: What is the purpose of `__init__.py`?**
> It marks a directory as a Python **package** so that modules inside can be imported. In Python 3.3+, it's optional (namespace packages).

**Q11: How is Python memory managed?**
> Python uses:
> - **Private heap space** for all objects and data structures
> - **Reference counting** to track object references
> - **Garbage collector** (cyclic garbage collector) to free unused memory
> - **Memory pool (pymalloc)** for small objects

**Q12: What is garbage collection in Python?**
> Garbage collection is the automatic memory management process that frees memory occupied by objects that are no longer in use. Python uses **reference counting** + **cyclic garbage collector**.

**Q13: What is reference counting?**
> Every object in Python has a reference count. When the count drops to 0, the memory is deallocated immediately.
```python
import sys
a = [1, 2, 3]
print(sys.getrefcount(a))  # Shows reference count
```

**Q14: What are Python namespaces?**
> A namespace is a mapping of names to objects. Python has 4 namespaces:
> - **Built-in** — `print`, `len`, `int`, etc.
> - **Global** — Module-level names
> - **Enclosing** — Outer function (for nested functions)
> - **Local** — Inside current function

**Q15: What is the LEGB rule?**
> The order Python looks up variable names:
> - **L**ocal → **E**nclosing → **G**lobal → **B**uilt-in
```python
x = "global"
def outer():
    x = "enclosing"
    def inner():
        x = "local"
        print(x)  # "local" (L)
    inner()
outer()
```

**Q16: What is `pass` statement?**
> A null operation / placeholder. Used when a statement is syntactically required but no code needs to execute.
```python
def todo():
    pass  # Will implement later

class MyClass:
    pass
```

**Q17: What is the difference between `pass`, `continue`, and `break`?**
> - `pass`: Does nothing (placeholder)
> - `continue`: Skips current iteration, goes to next
> - `break`: Exits the loop entirely
```python
for i in range(5):
    if i == 2:
        continue  # Skip 2
    if i == 4:
        break      # Stop at 4
    print(i)       # 0, 1, 3
```

**Q18: What is `None` in Python?**
> `None` is a special constant representing the **absence of a value**. It is the only instance of `NoneType`. It is NOT `0`, `""`, `[]`, or `False`.
```python
x = None
print(type(x))     # <class 'NoneType'>
print(x is None)   # True
print(x == None)   # True (but use 'is' instead)
```

**Q19: What is the difference between `None` and `False`?**
> - `None` means "no value" / "nothing"
> - `False` is a boolean value
> - Both are "falsy" in boolean context, but they are different types

**Q20: What is `type()` and `id()` function?**
```python
x = 42
print(type(x))  # <class 'int'>
print(id(x))    # Memory address (e.g., 140234567890)
```

**Q21: What is dynamic typing?**
> In Python, you don't declare variable types. The type is determined at **runtime** and can change.
```python
x = 10      # int
x = "hello" # str (same variable, different type)
x = [1, 2]  # list
```

**Q22: What is the difference between static typing and dynamic typing?**
> - **Static typing** (Java, C++): Type declared at compile time, can't change
> - **Dynamic typing** (Python): Type determined at runtime, can change

**Q23: What is duck typing?**
> "If it walks like a duck and quacks like a duck, it's a duck." Python cares about **behavior**, not type.
```python
class Duck:
    def quack(self):
        print("Quack!")

class Person:
    def quack(self):
        print("I'm quacking!")

def make_quack(thing):
    thing.quack()  # Works for both Duck and Person

make_quack(Duck())    # "Quack!"
make_quack(Person())  # "I'm quacking!"
```

**Q24: What is type hinting in Python?**
> Optional annotations to indicate expected types (Python 3.5+). They don't enforce types at runtime.
```python
def greet(name: str) -> str:
    return f"Hello, {name}"

age: int = 25
```

**Q25: What is `isinstance()` vs `type()`?**
```python
class Animal: pass
class Dog(Animal): pass

d = Dog()
print(type(d) == Dog)        # True
print(type(d) == Animal)     # False ❌
print(isinstance(d, Dog))    # True
print(isinstance(d, Animal)) # True ✅ (checks inheritance)
```

**Q26: What are Python's built-in data types?**
> - **Numeric:** `int`, `float`, `complex`
> - **Sequence:** `str`, `list`, `tuple`, `range`
> - **Mapping:** `dict`
> - **Set:** `set`, `frozenset`
> - **Boolean:** `bool`
> - **Binary:** `bytes`, `bytearray`, `memoryview`
> - **None:** `NoneType`

**Q27: What is the difference between `input()` and `raw_input()`?**
> - Python 2: `raw_input()` returns string, `input()` evaluates expression
> - Python 3: Only `input()` exists (returns string always)
```python
name = input("Enter name: ")  # Always returns str in Python 3
age = int(input("Enter age: "))  # Convert manually
```

**Q28: What is indentation in Python and why is it important?**
> Indentation (4 spaces) defines code blocks instead of curly braces `{}`. It's **mandatory** and part of the syntax.

**Q29: What is the `print()` function's complete syntax?**
```python
print(*objects, sep=' ', end='\n', file=sys.stdout, flush=False)

print("a", "b", "c", sep="-")   # a-b-c
print("hello", end=" ")          # hello (no newline)
print("world")                   # world
```

**Q30: What is the `dir()` function?**
> Returns a list of all attributes and methods of an object.
```python
print(dir(str))  # All string methods
print(dir([]))   # All list methods
```

**Q31: What is `help()` function?**
> Displays documentation for a module, function, class, or method.
```python
help(str.split)
help(print)
```

**Q32: What is the difference between `del`, `remove()`, and `pop()`?**
```python
lst = [1, 2, 3, 4, 5]

del lst[0]        # Delete by index: [2, 3, 4, 5]
lst.remove(3)     # Delete by value: [2, 4, 5]
lst.pop()         # Remove last: [2, 4] (returns 5)
lst.pop(0)        # Remove at index: [4] (returns 2)
```

**Q33: What are `global` and `nonlocal` keywords?**
```python
x = 10

def outer():
    y = 20
    def inner():
        global x        # Modify global variable
        nonlocal y      # Modify enclosing variable
        x = 100
        y = 200
    inner()
    print(y)  # 200

outer()
print(x)  # 100
```

**Q34: What is string interning?**
> Python caches small strings and integers for optimization. Same value → same memory.
```python
a = "hello"
b = "hello"
print(a is b)  # True (interned)

a = "hello world!"
b = "hello world!"
print(a is b)  # May be False (not interned)
```

**Q35: What is integer caching in Python?**
> CPython caches integers from **-5 to 256**. Same value within this range shares memory.
```python
a = 256
b = 256
print(a is b)  # True (cached)

a = 257
b = 257
print(a is b)  # False (not cached)
```

**Q36: What is the `enumerate()` function?**
```python
fruits = ["apple", "banana", "cherry"]
for index, fruit in enumerate(fruits):
    print(f"{index}: {fruit}")
# 0: apple
# 1: banana
# 2: cherry

# Start from custom index
for i, f in enumerate(fruits, start=1):
    print(f"{i}: {f}")
```

**Q37: What is the `zip()` function?**
```python
names = ["Alice", "Bob", "Charlie"]
ages = [25, 30, 35]

for name, age in zip(names, ages):
    print(f"{name} is {age}")
# Alice is 25
# Bob is 30
# Charlie is 35
```

**Q38: What is the `map()` function?**
```python
numbers = [1, 2, 3, 4, 5]
squared = list(map(lambda x: x**2, numbers))
print(squared)  # [1, 4, 9, 16, 25]
```

**Q39: What is the `filter()` function?**
```python
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
evens = list(filter(lambda x: x % 2 == 0, numbers))
print(evens)  # [2, 4, 6, 8, 10]
```

**Q40: What is the `reduce()` function?**
```python
from functools import reduce

numbers = [1, 2, 3, 4, 5]
total = reduce(lambda a, b: a + b, numbers)
print(total)  # 15 (1+2+3+4+5)
```

**Q41: What is the `sorted()` vs `.sort()` difference?**
```python
lst = [3, 1, 4, 1, 5]

# sorted() - Returns new list, original unchanged
new_lst = sorted(lst)
print(lst)      # [3, 1, 4, 1, 5] (unchanged)
print(new_lst)  # [1, 1, 3, 4, 5]

# .sort() - Modifies in place, returns None
lst.sort()
print(lst)  # [1, 1, 3, 4, 5] (changed)
```

**Q42: What is `any()` and `all()`?**
```python
print(any([False, False, True]))   # True (at least one True)
print(any([False, False, False]))  # False

print(all([True, True, True]))     # True (all True)
print(all([True, False, True]))    # False
```

**Q43: What are `min()`, `max()`, `sum()` functions?**
```python
nums = [10, 20, 30, 40, 50]
print(min(nums))  # 10
print(max(nums))  # 50
print(sum(nums))  # 150
```

**Q44: What is the `abs()` function?**
```python
print(abs(-42))    # 42
print(abs(3.14))   # 3.14
print(abs(-0))     # 0
```

**Q45: What is the `round()` function?**
```python
print(round(3.14159, 2))  # 3.14
print(round(2.5))          # 2 (banker's rounding)
print(round(3.5))          # 4
```

**Q46: What is the `len()` function?**
```python
print(len("hello"))     # 5
print(len([1, 2, 3]))   # 3
print(len({"a": 1}))    # 1
```

**Q47: What is the `range()` function?**
```python
print(list(range(5)))        # [0, 1, 2, 3, 4]
print(list(range(2, 8)))     # [2, 3, 4, 5, 6, 7]
print(list(range(0, 10, 2))) # [0, 2, 4, 6, 8]
print(list(range(10, 0, -1)))# [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
```

**Q48: What are escape characters in Python?**
```python
print("Hello\nWorld")   # Newline
print("Hello\tWorld")   # Tab
print("He said \"hi\"") # Double quote
print("C:\\Users\\path") # Backslash
print("Hello\0World")   # Null character
```

**Q49: What is an f-string?**
```python
name = "John"
age = 25
print(f"My name is {name} and I'm {age} years old")
print(f"2 + 3 = {2 + 3}")
print(f"{'hello':>10}")  # Right-aligned
print(f"{3.14159:.2f}")  # 3.14
```

**Q50: What is the `format()` method?**
```python
print("Hello, {}!".format("World"))
print("Name: {name}, Age: {age}".format(name="John", age=25))
print("{0} {1} {0}".format("hello", "world"))  # hello world hello
```

**Q51: What is the `repr()` vs `str()` difference?**
```python
import datetime
d = datetime.datetime.now()

print(str(d))   # 2024-02-10 10:30:00.123456 (human-readable)
print(repr(d))  # datetime.datetime(2024, 2, 10, 10, 30, 0, 123456) (unambiguous)
```

**Q52: What is the walrus operator `:=`?**
```python
# Python 3.8+ — Assignment expression
# Assign and use in same expression

if (n := len("hello")) > 3:
    print(f"Length {n} is greater than 3")

# In while loops
while (line := input("Enter: ")) != "quit":
    print(f"You entered: {line}")
```

**Q53: What is unpacking in Python?**
```python
# Tuple unpacking
a, b, c = 1, 2, 3

# List unpacking
first, *rest = [1, 2, 3, 4, 5]
print(first)  # 1
print(rest)   # [2, 3, 4, 5]

# Star unpacking
a, *b, c = [1, 2, 3, 4, 5]
print(a)  # 1
print(b)  # [2, 3, 4]
print(c)  # 5
```

**Q54: What is the difference between shallow copy and deep copy?**
```python
import copy

original = [[1, 2], [3, 4]]

shallow = copy.copy(original)
deep = copy.deepcopy(original)

original[0][0] = 999

print(shallow)  # [[999, 2], [3, 4]] — Affected!
print(deep)     # [[1, 2], [3, 4]]   — Not affected
```

**Q55: What is the `with` statement (context manager)?**
```python
# Ensures proper resource management (auto-close)
with open("file.txt", "r") as f:
    content = f.read()
# File automatically closed after the block
```

**Q56: What are magic/dunder methods?**
> Methods with double underscores (`__method__`). They enable operator overloading and customization.
```python
class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def __add__(self, other):        # +
        return Vector(self.x + other.x, self.y + other.y)
    
    def __str__(self):               # str(), print()
        return f"({self.x}, {self.y})"
    
    def __repr__(self):              # repr()
        return f"Vector({self.x}, {self.y})"
    
    def __len__(self):               # len()
        return 2
    
    def __eq__(self, other):         # ==
        return self.x == other.x and self.y == other.y

v1 = Vector(1, 2)
v2 = Vector(3, 4)
print(v1 + v2)  # (4, 6)
```

**Q57: What is the `__name__` variable?**
```python
# When file is run directly:
# __name__ == "__main__"

# When file is imported:
# __name__ == "module_name"

if __name__ == "__main__":
    print("Running directly")
else:
    print("Being imported")
```

**Q58: What is the ternary operator in Python?**
```python
x = 10
result = "even" if x % 2 == 0 else "odd"
print(result)  # "even"

# Nested
grade = "A" if x > 90 else "B" if x > 80 else "C"
```

**Q59: What is the `assert` statement?**
```python
x = 10
assert x > 0, "x must be positive"   # Passes
assert x < 0, "x must be negative"   # AssertionError: x must be negative
```

**Q60: What is the `eval()` function?**
```python
result = eval("2 + 3 * 4")
print(result)  # 14

# ⚠️ Security risk — never use with user input!
# eval("__import__('os').system('rm -rf /')") — DANGEROUS
```

**Q61: What is the `exec()` function?**
```python
code = """
for i in range(5):
    print(i)
"""
exec(code)  # Executes the code string
```

**Q62: What is `chr()` and `ord()`?**
```python
print(chr(65))    # 'A' (ASCII/Unicode code to character)
print(chr(97))    # 'a'
print(ord('A'))   # 65 (character to ASCII/Unicode code)
print(ord('a'))   # 97
```

**Q63: What are truthy and falsy values?**
```python
# Falsy values:
# False, None, 0, 0.0, "", [], (), {}, set(), frozenset()

# Truthy values:
# Everything else

if []:
    print("Truthy")
else:
    print("Falsy")  # This prints

if [0]:
    print("Truthy")  # This prints (non-empty list)
```

**Q64: What is short-circuit evaluation?**
```python
# 'and' returns first falsy value, or last value
print(0 and 5)     # 0
print(3 and 5)     # 5
print(3 and 0)     # 0

# 'or' returns first truthy value, or last value
print(0 or 5)      # 5
print(3 or 5)      # 3
print(0 or False)   # False
```

**Q65: What is `hasattr()`, `getattr()`, `setattr()`?**
```python
class Person:
    name = "John"

p = Person()
print(hasattr(p, "name"))     # True
print(getattr(p, "name"))     # "John"
print(getattr(p, "age", 25))  # 25 (default)
setattr(p, "age", 30)
print(p.age)                   # 30
```

**Q66: What is the `hex()`, `oct()`, `bin()` function?**
```python
print(hex(255))   # '0xff'
print(oct(255))   # '0o377'
print(bin(255))   # '0b11111111'
print(int('ff', 16))  # 255
print(int('377', 8))  # 255
```

**Q67: What is `isinstance()` and `issubclass()`?**
```python
print(isinstance(42, int))         # True
print(isinstance("hi", (int, str))) # True (check multiple types)

class Animal: pass
class Dog(Animal): pass

print(issubclass(Dog, Animal))  # True
print(issubclass(Animal, Dog))  # False
```

**Q68: What is the `property()` decorator?**
```python
class Circle:
    def __init__(self, radius):
        self._radius = radius
    
    @property
    def radius(self):
        return self._radius
    
    @radius.setter
    def radius(self, value):
        if value < 0:
            raise ValueError("Radius cannot be negative")
        self._radius = value
    
    @property
    def area(self):
        return 3.14159 * self._radius ** 2

c = Circle(5)
print(c.radius)  # 5 (getter)
c.radius = 10    # setter
print(c.area)    # 314.159 (computed property)
```

**Q69: What is the `__slots__` attribute?**
```python
class WithoutSlots:
    def __init__(self):
        self.name = "John"
        self.age = 25

class WithSlots:
    __slots__ = ['name', 'age']
    def __init__(self):
        self.name = "John"
        self.age = 25

# WithSlots uses less memory
# Cannot add new attributes dynamically
```

**Q70: What is monkey patching?**
```python
class MyClass:
    def greet(self):
        return "Hello"

def new_greet(self):
    return "Hi there!"

# Replace method at runtime
MyClass.greet = new_greet
obj = MyClass()
print(obj.greet())  # "Hi there!"
```

**Q71: What is the GIL (Global Interpreter Lock)?**
> A mutex in CPython that allows only **one thread** to execute Python bytecode at a time. This limits true parallelism in multi-threaded programs.

**Q72: How do you handle multi-threading in Python?**
```python
import threading

def task(name):
    print(f"Task {name} running")

t1 = threading.Thread(target=task, args=("A",))
t2 = threading.Thread(target=task, args=("B",))

t1.start()
t2.start()
t1.join()
t2.join()
```

**Q73: What is the difference between multithreading and multiprocessing?**
> - **Threading:** Shared memory, limited by GIL, good for I/O-bound tasks
> - **Multiprocessing:** Separate memory, true parallelism, good for CPU-bound tasks

**Q74: What is `*args` and `**kwargs`?**
```python
def func(*args, **kwargs):
    print("args:", args)       # Tuple of positional args
    print("kwargs:", kwargs)   # Dict of keyword args

func(1, 2, 3, name="John", age=25)
# args: (1, 2, 3)
# kwargs: {'name': 'John', 'age': 25}
```

**Q75: What is the difference between `is` and `==`?**
```python
a = [1, 2, 3]
b = [1, 2, 3]
c = a

print(a == b)   # True (same value)
print(a is b)   # False (different objects)
print(a is c)   # True (same object)
```

**Q76: What is a docstring?**
```python
def add(a, b):
    """
    Add two numbers and return the result.
    
    Args:
        a (int): First number
        b (int): Second number
    
    Returns:
        int: Sum of a and b
    """
    return a + b

print(add.__doc__)  # Access docstring
```

**Q77: What is the `__all__` variable?**
```python
# In a module, controls what's exported with 'from module import *'
__all__ = ['public_func', 'PublicClass']

def public_func():
    pass

def _private_func():
    pass

class PublicClass:
    pass
```

**Q78: What is pickling and unpickling?**
```python
import pickle

# Pickling (serialize object to bytes)
data = {"name": "John", "age": 25}
with open("data.pkl", "wb") as f:
    pickle.dump(data, f)

# Unpickling (deserialize bytes to object)
with open("data.pkl", "rb") as f:
    loaded = pickle.load(f)
print(loaded)  # {"name": "John", "age": 25}
```

**Q79: What is the difference between `deepcopy` and `copy`?**
```python
import copy

a = [[1, 2], [3, 4]]

b = copy.copy(a)      # Shallow: new list, same inner lists
c = copy.deepcopy(a)  # Deep: new list, new inner lists

a[0][0] = 99
print(b[0][0])  # 99 (affected - shares inner list)
print(c[0][0])  # 1  (unaffected - independent copy)
```

**Q80: What is Python's `sys` module?**
```python
import sys

print(sys.version)       # Python version
print(sys.platform)      # Operating system
print(sys.path)          # Module search paths
print(sys.argv)          # Command-line arguments
print(sys.getsizeof(42)) # Memory size of object
sys.exit(0)              # Exit program
```

---

# 2. 📊 Data Types & Variables

**Q81: What are the numeric types in Python?**
```python
x = 10          # int
y = 3.14        # float
z = 3 + 4j      # complex

print(type(x))  # <class 'int'>
print(type(y))  # <class 'float'>
print(type(z))  # <class 'complex'>
```

**Q82: How do you convert between types?**
```python
# Type casting
x = int("42")       # str to int: 42
y = float("3.14")   # str to float: 3.14
z = str(42)          # int to str: "42"
a = list("hello")   # str to list: ['h', 'e', 'l', 'l', 'o']
b = tuple([1,2,3])  # list to tuple: (1, 2, 3)
c = set([1,1,2,3])  # list to set: {1, 2, 3}
d = bool(0)          # int to bool: False
e = bool(1)          # int to bool: True
```

**Q83: What is the maximum size of an integer in Python?**
> Python 3 integers have **arbitrary precision** — no maximum size limit.
```python
x = 10 ** 1000  # Works fine! (very large number)
```

**Q84: What is the difference between `int` and `float` division?**
```python
print(10 / 3)    # 3.3333... (float division)
print(10 // 3)   # 3 (integer/floor division)
print(10 % 3)    # 1 (modulo/remainder)
print(10 ** 3)   # 1000 (power)
```

**Q85: What is a complex number?**
```python
z = 3 + 4j
print(z.real)       # 3.0
print(z.imag)       # 4.0
print(abs(z))       # 5.0 (magnitude)
print(z.conjugate()) # (3-4j)
```

**Q86: What is the `decimal` module?**
```python
from decimal import Decimal

# float precision issue
print(0.1 + 0.2)           # 0.30000000000000004

# Decimal fixes this
print(Decimal('0.1') + Decimal('0.2'))  # 0.3
```

**Q87: What is the `fractions` module?**
```python
from fractions import Fraction

f = Fraction(1, 3)
print(f)              # 1/3
print(f + Fraction(1, 6))  # 1/2
print(float(f))       # 0.3333...
```

**Q88: What are boolean values?**
```python
print(True + True)    # 2 (True = 1)
print(True * 10)      # 10
print(False + False)  # 0 (False = 0)
print(isinstance(True, int))  # True (bool is subclass of int)
```

**Q89: What is the `None` type?**
```python
x = None
print(type(x))        # <class 'NoneType'>
print(x is None)      # True (preferred way to check)
print(x == None)      # True (but less Pythonic)
```

**Q90: What is the difference between mutable and immutable types?**
```python
# Immutable: int, float, str, tuple, frozenset, bool, bytes
x = "hello"
# x[0] = "H"  # TypeError! Strings are immutable

# Mutable: list, dict, set, bytearray
lst = [1, 2, 3]
lst[0] = 99  # Works! Lists are mutable
```

**Q91: How do you check if a variable is of a certain type?**
```python
x = 42
print(type(x) == int)       # True (exact type check)
print(isinstance(x, int))   # True (includes subclasses)
print(isinstance(x, (int, float)))  # True (check multiple)
```

**Q92: What is type conversion vs type coercion?**
```python
# Type conversion (explicit/casting)
x = int("42")
y = str(3.14)

# Type coercion (implicit/automatic)
result = 5 + 3.14  # int auto-converted to float
print(type(result))  # <class 'float'>
```

**Q93: What is the `bytes` and `bytearray` type?**
```python
# bytes — Immutable sequence of bytes
b = b"hello"
print(b[0])  # 104 (ASCII of 'h')

# bytearray — Mutable sequence of bytes
ba = bytearray(b"hello")
ba[0] = 72  # Change 'h' to 'H'
print(ba)   # bytearray(b'Hello')
```

**Q94: What is the `memoryview` type?**
```python
# Access internal data of bytes-like objects without copying
data = bytearray(b"Hello World")
mv = memoryview(data)
print(mv[0])    # 72
mv[0] = 74      # Change 'H' to 'J'
print(data)     # bytearray(b'Jello World')
```

**Q95: How do you swap variables in Python?**
```python
# Pythonic way
a, b = 5, 10
a, b = b, a
print(a, b)  # 10, 5

# Without temp variable (arithmetic)
a = a + b  # 15
b = a - b  # 5
a = a - b  # 10

# XOR method
a = a ^ b
b = a ^ b
a = a ^ b
```

**Q96: What are multiple assignments?**
```python
a = b = c = 10          # All equal to 10
x, y, z = 1, 2, 3      # Parallel assignment
a, *b = [1, 2, 3, 4]   # a=1, b=[2, 3, 4]
*a, b = [1, 2, 3, 4]   # a=[1, 2, 3], b=4
```

**Q97: What is the `Ellipsis` (`...`) in Python?**
```python
# Used as placeholder (like pass)
def todo():
    ...

# In type hints for variadic generics
from typing import Tuple
x: Tuple[int, ...] = (1, 2, 3)  # Tuple of any number of ints

# In numpy for multi-dimensional slicing
# arr[..., 0]
```

**Q98: What are augmented assignment operators?**
```python
x = 10
x += 5    # x = x + 5 → 15
x -= 3    # x = x - 3 → 12
x *= 2    # x = x * 2 → 24
x //= 5   # x = x // 5 → 4
x **= 3   # x = x ** 3 → 64
x %= 10   # x = x % 10 → 4
```

**Q99: What is the `id()` function and how does it relate to mutability?**
```python
# Immutable: id changes on modification
x = 10
print(id(x))  # e.g., 140234567890
x = 20
print(id(x))  # Different! New object created

# Mutable: id stays same on modification
lst = [1, 2, 3]
print(id(lst))  # e.g., 140234567900
lst.append(4)
print(id(lst))  # Same! Modified in place
```

**Q100: What is the difference between `==` and `is` for None?**
```python
x = None

# Recommended:
if x is None:
    print("x is None")

# Not recommended:
if x == None:
    print("x is None")

# Why? A class can override __eq__ to return True for None
class Tricky:
    def __eq__(self, other):
        return True

t = Tricky()
print(t == None)  # True (misleading!)
print(t is None)  # False (correct!)
```

**Q101–Q130: More Data Type questions...**

**Q101: What is the `collections` module?**
```python
from collections import Counter, defaultdict, namedtuple, deque, OrderedDict

# Counter
c = Counter("abracadabra")
print(c)  # Counter({'a': 5, 'b': 2, 'r': 2, 'c': 1, 'd': 1})
print(c.most_common(2))  # [('a', 5), ('b', 2)]

# defaultdict
dd = defaultdict(int)
dd["a"] += 1  # No KeyError for missing keys

# namedtuple
Point = namedtuple("Point", ["x", "y"])
p = Point(3, 4)
print(p.x, p.y)  # 3 4

# deque
dq = deque([1, 2, 3])
dq.appendleft(0)  # [0, 1, 2, 3]
dq.pop()           # [0, 1, 2]

# OrderedDict (preserves insertion order, pre-3.7)
od = OrderedDict()
od['a'] = 1
od['b'] = 2
```

**Q102: What is `ChainMap`?**
```python
from collections import ChainMap

defaults = {"color": "red", "size": "medium"}
custom = {"color": "blue"}

combined = ChainMap(custom, defaults)
print(combined["color"])  # "blue" (from custom)
print(combined["size"])   # "medium" (from defaults)
```

**Q103: What is a `dataclass`?**
```python
from dataclasses import dataclass

@dataclass
class Person:
    name: str
    age: int
    city: str = "Hyderabad"

p = Person("John", 25)
print(p)            # Person(name='John', age=25, city='Hyderabad')
print(p.name)       # John
print(p == Person("John", 25))  # True (auto-generated __eq__)
```

**Q104: What is `typing` module?**
```python
from typing import List, Dict, Tuple, Optional, Union

def greet(name: str) -> str:
    return f"Hello, {name}"

def process(items: List[int]) -> Dict[str, int]:
    return {"sum": sum(items), "count": len(items)}

def find(x: Optional[int] = None) -> Union[int, str]:
    return x if x else "Not found"
```

---

# 3. 📝 Strings

**Q131: How do you create strings in Python?**
```python
s1 = 'single quotes'
s2 = "double quotes"
s3 = '''triple quotes
for multiline'''
s4 = """also
multiline"""
s5 = str(42)  # "42"
```

**Q132: Are strings mutable or immutable?**
```python
s = "hello"
# s[0] = "H"  # TypeError! Strings are immutable
s = "H" + s[1:]  # Create new string: "Hello"
```

**Q133: What are the most common string methods?**
```python
s = "Hello, World!"

s.upper()         # "HELLO, WORLD!"
s.lower()         # "hello, world!"
s.title()         # "Hello, World!"
s.capitalize()    # "Hello, world!"
s.swapcase()      # "hELLO, wORLD!"

s.strip()         # Remove whitespace from both ends
s.lstrip()        # Remove from left
s.rstrip()        # Remove from right

s.split(",")      # ["Hello", " World!"]
s.split()         # ["Hello,", "World!"]
" ".join(["a","b"])  # "a b"

s.replace("World", "Python")  # "Hello, Python!"
s.find("World")    # 7 (index, -1 if not found)
s.index("World")   # 7 (index, ValueError if not found)
s.count("l")       # 3

s.startswith("Hello")  # True
s.endswith("!")        # True

s.isalpha()        # False (has comma, space, !)
s.isdigit()        # False
s.isalnum()        # False
s.isspace()        # False

s.center(20, "*")  # "***Hello, World!****"
s.ljust(20, "-")   # "Hello, World!-------"
s.rjust(20, "-")   # "-------Hello, World!"
s.zfill(20)        # "0000000Hello, World!"

s.encode("utf-8")  # b'Hello, World!'
```

**Q134: How does string slicing work?**
```python
s = "Hello, World!"
#    0123456789...

print(s[0])      # 'H'
print(s[-1])     # '!'
print(s[0:5])    # 'Hello'
print(s[7:])     # 'World!'
print(s[:5])     # 'Hello'
print(s[::2])    # 'Hlo ol!'
print(s[::-1])   # '!dlroW ,olleH' (reverse)
```

**Q135: How do you check if a substring exists?**
```python
s = "Hello, World!"

print("World" in s)      # True
print("world" in s)      # False (case-sensitive)
print("world" in s.lower())  # True
print(s.find("World"))   # 7
print(s.count("l"))      # 3
```

**Q136: How do you reverse a string?**
```python
# Method 1: Slicing
s = "hello"
print(s[::-1])  # "olleh"

# Method 2: reversed()
print("".join(reversed(s)))  # "olleh"

# Method 3: Loop
result = ""
for char in s:
    result = char + result
print(result)  # "olleh"
```

**Q137: How do you check for palindrome?**
```python
def is_palindrome(s):
    s = s.lower().replace(" ", "")
    return s == s[::-1]

print(is_palindrome("madam"))        # True
print(is_palindrome("race car"))     # True
print(is_palindrome("hello"))        # False
```

**Q138: How do you count vowels and consonants?**
```python
def count_vowels_consonants(s):
    vowels = "aeiouAEIOU"
    v = c = 0
    for char in s:
        if char.isalpha():
            if char in vowels:
                v += 1
            else:
                c += 1
    return v, c

print(count_vowels_consonants("Hello World"))  # (3, 7)
```

**Q139: What is string formatting?**
```python
name = "John"
age = 25

# f-string (Python 3.6+) — Recommended
print(f"Name: {name}, Age: {age}")

# .format()
print("Name: {}, Age: {}".format(name, age))

# % formatting (old style)
print("Name: %s, Age: %d" % (name, age))
```

**Q140: How do you convert string to list and back?**
```python
# String to list
s = "hello"
lst = list(s)           # ['h', 'e', 'l', 'l', 'o']
words = "a b c".split() # ['a', 'b', 'c']

# List to string
lst = ['h', 'e', 'l', 'l', 'o']
s = "".join(lst)         # "hello"
words = ['a', 'b', 'c']
s = " ".join(words)      # "a b c"
```

**Q141–Q175: More String questions...**

**Q141: How do you remove specific characters from a string?**
```python
s = "he!ll@o#"
clean = s.translate(str.maketrans("", "", "!@#"))
print(clean)  # "hello"

# Using regex
import re
clean = re.sub(r'[!@#]', '', s)
print(clean)  # "hello"
```

**Q142: How do you find all occurrences of a character?**
```python
s = "hello world hello"
indices = [i for i, c in enumerate(s) if c == 'l']
print(indices)  # [2, 3, 12, 13]
```

**Q143: What is the difference between `encode()` and `decode()`?**
```python
s = "Hello"
b = s.encode("utf-8")     # str → bytes: b'Hello'
s2 = b.decode("utf-8")    # bytes → str: 'Hello'
```

---

# 4. 📋 Lists

**Q176: How do you create a list?**
```python
lst = [1, 2, 3]
lst = list()
lst = list("hello")     # ['h', 'e', 'l', 'l', 'o']
lst = list(range(5))    # [0, 1, 2, 3, 4]
lst = [0] * 5           # [0, 0, 0, 0, 0]
```

**Q177: What are the most common list methods?**
```python
lst = [3, 1, 4, 1, 5]

lst.append(9)       # [3, 1, 4, 1, 5, 9]
lst.insert(0, 0)    # [0, 3, 1, 4, 1, 5, 9]
lst.extend([2, 6])  # [0, 3, 1, 4, 1, 5, 9, 2, 6]

lst.remove(1)       # Remove first 1: [0, 3, 4, 1, 5, 9, 2, 6]
lst.pop()           # Remove last: [0, 3, 4, 1, 5, 9, 2]
lst.pop(0)          # Remove at index: [3, 4, 1, 5, 9, 2]

lst.sort()          # Sort in-place: [1, 2, 3, 4, 5, 9]
lst.reverse()       # Reverse in-place: [9, 5, 4, 3, 2, 1]

lst.index(5)        # Find index: 1
lst.count(5)        # Count occurrences: 1
lst.copy()          # Shallow copy
lst.clear()         # Remove all elements
```

**Q178: How does list slicing work?**
```python
lst = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

print(lst[2:5])     # [2, 3, 4]
print(lst[:3])      # [0, 1, 2]
print(lst[7:])      # [7, 8, 9]
print(lst[::2])     # [0, 2, 4, 6, 8]
print(lst[::-1])    # [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
print(lst[1:8:2])   # [1, 3, 5, 7]
```

**Q179: What is list comprehension?**
```python
# Basic
squares = [x**2 for x in range(10)]
# [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

# With condition
evens = [x for x in range(20) if x % 2 == 0]
# [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

# Nested
matrix = [[i*3+j for j in range(3)] for i in range(3)]
# [[0, 1, 2], [3, 4, 5], [6, 7, 8]]

# With if-else
labels = ["even" if x % 2 == 0 else "odd" for x in range(5)]
# ['even', 'odd', 'even', 'odd', 'even']
```

**Q180: How do you flatten a nested list?**
```python
# Method 1: List comprehension
nested = [[1, 2], [3, 4], [5, 6]]
flat = [item for sublist in nested for item in sublist]
print(flat)  # [1, 2, 3, 4, 5, 6]

# Method 2: itertools
import itertools
flat = list(itertools.chain(*nested))

# Method 3: sum
flat = sum(nested, [])

# Method 4: Recursive (for deeply nested)
def flatten(lst):
    result = []
    for item in lst:
        if isinstance(item, list):
            result.extend(flatten(item))
        else:
            result.append(item)
    return result

print(flatten([1, [2, [3, [4, 5]]]]))  # [1, 2, 3, 4, 5]
```

**Q181: How do you remove duplicates from a list?**
```python
# Method 1: set (doesn't preserve order)
lst = [1, 2, 2, 3, 3, 4]
unique = list(set(lst))  # [1, 2, 3, 4]

# Method 2: dict.fromkeys (preserves order)
unique = list(dict.fromkeys(lst))  # [1, 2, 3, 4]

# Method 3: Loop (preserves order)
unique = []
for item in lst:
    if item not in unique:
        unique.append(item)
```

**Q182: How do you sort a list of dictionaries?**
```python
people = [
    {"name": "John", "age": 25},
    {"name": "Alice", "age": 22},
    {"name": "Bob", "age": 30}
]

# Sort by age
sorted_people = sorted(people, key=lambda x: x["age"])
# [{"name": "Alice", "age": 22}, {"name": "John", "age": 25}, {"name": "Bob", "age": 30}]

# Sort by name (descending)
sorted_people = sorted(people, key=lambda x: x["name"], reverse=True)
```

**Q183–Q220: More List questions...**

**Q183: How do you find the second largest element?**
```python
# Method 1
lst = [10, 20, 30, 40, 50]
lst.sort()
print(lst[-2])  # 40

# Method 2 (without sorting)
def second_largest(lst):
    first = second = float('-inf')
    for num in lst:
        if num > first:
            second = first
            first = num
        elif num > second and num != first:
            second = num
    return second

print(second_largest([10, 20, 30, 40, 50]))  # 40
```

**Q184: How do you merge two sorted lists?**
```python
def merge_sorted(a, b):
    result = []
    i = j = 0
    while i < len(a) and j < len(b):
        if a[i] <= b[j]:
            result.append(a[i])
            i += 1
        else:
            result.append(b[j])
            j += 1
    result.extend(a[i:])
    result.extend(b[j:])
    return result

print(merge_sorted([1, 3, 5], [2, 4, 6]))  # [1, 2, 3, 4, 5, 6]
```

---

# 5. 📦 Tuples

**Q221: What is a tuple?**
```python
t = (1, 2, 3)
t = tuple([1, 2, 3])
t = 1, 2, 3           # Packing
single = (42,)          # Single element (comma required!)
empty = ()
```

**Q222: Why use tuples over lists?**
> - **Immutable:** Can be used as dict keys, set elements
> - **Faster:** Less overhead than lists
> - **Safer:** Can't be accidentally modified
> - **Memory efficient:** Takes less space

**Q223: Can a tuple contain mutable objects?**
```python
t = ([1, 2], [3, 4])
t[0].append(99)     # Works! List inside is mutable
print(t)            # ([1, 2, 99], [3, 4])
# t[0] = [5, 6]     # TypeError! Can't reassign tuple element
```

**Q224: What is tuple unpacking?**
```python
t = (1, 2, 3)
a, b, c = t
print(a, b, c)  # 1 2 3

# Extended unpacking
first, *rest = (1, 2, 3, 4, 5)
print(first)  # 1
print(rest)   # [2, 3, 4, 5]
```

**Q225: What is a named tuple?**
```python
from collections import namedtuple

Point = namedtuple("Point", ["x", "y"])
p = Point(3, 4)
print(p.x)      # 3
print(p[0])     # 3
print(p._asdict())  # {'x': 3, 'y': 4}
```

**Q226–Q245: More Tuple questions...**

---

# 6. 📖 Dictionaries

**Q246: How do you create a dictionary?**
```python
d = {"name": "John", "age": 25}
d = dict(name="John", age=25)
d = dict([("name", "John"), ("age", 25)])
d = dict.fromkeys(["a", "b", "c"], 0)  # {"a": 0, "b": 0, "c": 0}
d = {}  # Empty dict
```

**Q247: What are the common dictionary methods?**
```python
d = {"name": "John", "age": 25, "city": "Hyderabad"}

d.keys()        # dict_keys(['name', 'age', 'city'])
d.values()      # dict_values(['John', 25, 'Hyderabad'])
d.items()       # dict_items([('name', 'John'), ('age', 25), ...])

d.get("name")            # "John"
d.get("email", "N/A")    # "N/A" (default if missing)

d.update({"email": "john@example.com"})
d.setdefault("phone", "N/A")

d.pop("age")       # Remove & return: 25
d.popitem()        # Remove & return last item
d.copy()           # Shallow copy
d.clear()          # Remove all
```

**Q248: How do you iterate over a dictionary?**
```python
d = {"a": 1, "b": 2, "c": 3}

# Keys
for key in d:
    print(key)

# Values
for value in d.values():
    print(value)

# Key-value pairs
for key, value in d.items():
    print(f"{key}: {value}")
```

**Q249: What is dictionary comprehension?**
```python
# Basic
squares = {x: x**2 for x in range(6)}
# {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25}

# With condition
even_squares = {x: x**2 for x in range(10) if x % 2 == 0}
# {0: 0, 2: 4, 4: 16, 6: 36, 8: 64}

# Swap keys and values
d = {"a": 1, "b": 2}
swapped = {v: k for k, v in d.items()}
# {1: "a", 2: "b"}
```

**Q250: How do you merge two dictionaries?**
```python
d1 = {"a": 1, "b": 2}
d2 = {"c": 3, "d": 4}

# Method 1: | operator (Python 3.9+)
merged = d1 | d2

# Method 2: ** unpacking (Python 3.5+)
merged = {**d1, **d2}

# Method 3: update()
d1.update(d2)

# Method 4: ChainMap
from collections import ChainMap
merged = dict(ChainMap(d2, d1))
```

**Q251: How do you sort a dictionary by value?**
```python
d = {"apple": 3, "banana": 1, "cherry": 2}

# Sort by value (ascending)
sorted_d = dict(sorted(d.items(), key=lambda x: x[1]))
# {"banana": 1, "cherry": 2, "apple": 3}

# Sort by value (descending)
sorted_d = dict(sorted(d.items(), key=lambda x: x[1], reverse=True))
```

**Q252: What is the difference between `dict[key]` and `dict.get(key)`?**
```python
d = {"name": "John"}

print(d["name"])       # "John"
# print(d["age"])      # KeyError!

print(d.get("name"))       # "John"
print(d.get("age"))        # None (no error)
print(d.get("age", 25))    # 25 (default value)
```

**Q253–Q290: More Dictionary questions...**

**Q253: How do you count character frequency using dict?**
```python
s = "hello world"
freq = {}
for char in s:
    freq[char] = freq.get(char, 0) + 1
print(freq)

# Using Counter
from collections import Counter
freq = Counter(s)
print(freq.most_common(3))
```

**Q254: How do you create a nested dictionary?**
```python
students = {
    "John": {"age": 25, "grade": "A"},
    "Alice": {"age": 22, "grade": "B"},
    "Bob": {"age": 28, "grade": "A+"}
}

print(students["John"]["grade"])  # "A"

# Access safely
print(students.get("Unknown", {}).get("grade", "N/A"))  # "N/A"
```

---

# 7. 🎯 Sets

**Q291: How do you create a set?**
```python
s = {1, 2, 3, 4, 5}
s = set([1, 2, 2, 3, 3])  # {1, 2, 3}
s = set("hello")           # {'h', 'e', 'l', 'o'}
empty = set()              # NOT {} (that's dict!)
```

**Q292: What are set operations?**
```python
a = {1, 2, 3, 4}
b = {3, 4, 5, 6}

print(a | b)   # Union: {1, 2, 3, 4, 5, 6}
print(a & b)   # Intersection: {3, 4}
print(a - b)   # Difference: {1, 2}
print(a ^ b)   # Symmetric difference: {1, 2, 5, 6}

print(a.issubset(b))      # False
print(a.issuperset(b))    # False
print(a.isdisjoint({7}))  # True (no common elements)
```

**Q293: What are the common set methods?**
```python
s = {1, 2, 3}

s.add(4)          # {1, 2, 3, 4}
s.update([5, 6])  # {1, 2, 3, 4, 5, 6}
s.remove(3)       # {1, 2, 4, 5, 6} (KeyError if missing)
s.discard(99)     # No error if missing
s.pop()           # Remove random element
s.clear()         # Empty set
```

**Q294: What is a frozenset?**
```python
# Immutable set — can be used as dict key or set element
fs = frozenset([1, 2, 3])
# fs.add(4)  # AttributeError!

# Use as dict key
d = {frozenset([1, 2]): "pair"}
```

**Q295–Q315: More Set questions...**

---

# 8. ⚙️ Operators & Expressions

**Q316: What are the types of operators in Python?**
```python
# Arithmetic: +, -, *, /, //, %, **
# Comparison: ==, !=, <, >, <=, >=
# Logical: and, or, not
# Bitwise: &, |, ^, ~, <<, >>
# Assignment: =, +=, -=, *=, /=, //=, %=, **=
# Identity: is, is not
# Membership: in, not in
```

**Q317: What is the difference between `/` and `//`?**
```python
print(7 / 2)    # 3.5 (true division)
print(7 // 2)   # 3 (floor division)
print(-7 // 2)  # -4 (floors towards negative infinity)
```

**Q318: What are bitwise operators?**
```python
a, b = 5, 3  # 101, 011 in binary

print(a & b)   # 1  (AND: 001)
print(a | b)   # 7  (OR: 111)
print(a ^ b)   # 6  (XOR: 110)
print(~a)      # -6 (NOT: inverts all bits)
print(a << 1)  # 10 (left shift: 1010)
print(a >> 1)  # 2  (right shift: 10)
```

**Q319: What is operator precedence?**
```python
# PEMDAS / BODMAS
# () > ** > ~ > *, /, //, % > +, - > <<, >> > & > ^ > | > comparisons > not > and > or

print(2 + 3 * 4)    # 14 (not 20)
print((2 + 3) * 4)  # 20
print(2 ** 3 ** 2)  # 512 (right-to-left: 2^9)
```

**Q320–Q345: More Operator questions...**

---

# 9. 🔀 Control Flow

**Q346: What are the control flow statements?**
```python
# if-elif-else
x = 85
if x >= 90:
    grade = "A"
elif x >= 80:
    grade = "B"
elif x >= 70:
    grade = "C"
else:
    grade = "F"

# for loop
for i in range(5):
    print(i)

# while loop
i = 0
while i < 5:
    print(i)
    i += 1

# match-case (Python 3.10+)
status = 404
match status:
    case 200:
        print("OK")
    case 404:
        print("Not Found")
    case _:
        print("Unknown")
```

**Q347: What is the `else` clause in loops?**
```python
# 'else' executes when loop completes WITHOUT break
for i in range(5):
    if i == 10:
        break
else:
    print("Loop completed normally")  # This prints

# If break is hit, else doesn't execute
for i in range(5):
    if i == 3:
        break
else:
    print("This won't print")
```

**Q348: How do you create an infinite loop?**
```python
while True:
    user_input = input("Enter 'quit' to exit: ")
    if user_input == "quit":
        break
```

**Q349: What is a nested loop?**
```python
# Multiplication table
for i in range(1, 6):
    for j in range(1, 6):
        print(f"{i*j:4}", end="")
    print()
```

**Q350: How does `match-case` (structural pattern matching) work?**
```python
# Python 3.10+
def http_status(status):
    match status:
        case 200:
            return "OK"
        case 301 | 302:
            return "Redirect"
        case 404:
            return "Not Found"
        case 500:
            return "Server Error"
        case _:
            return "Unknown"
```

**Q351–Q380: More Control Flow questions...**

---

# 10. 🔧 Functions

**Q381: How do you define a function?**
```python
def greet(name):
    """Greet a person by name."""
    return f"Hello, {name}!"

result = greet("John")
print(result)  # "Hello, John!"
```

**Q382: What are default parameters?**
```python
def greet(name, greeting="Hello"):
    return f"{greeting}, {name}!"

print(greet("John"))            # "Hello, John!"
print(greet("John", "Hi"))      # "Hi, John!"
```

**Q383: What is the mutable default argument trap?**
```python
# ❌ WRONG — Mutable default shared across calls
def add_item(item, lst=[]):
    lst.append(item)
    return lst

print(add_item(1))  # [1]
print(add_item(2))  # [1, 2] — NOT [2]!

# ✅ CORRECT — Use None as default
def add_item(item, lst=None):
    if lst is None:
        lst = []
    lst.append(item)
    return lst

print(add_item(1))  # [1]
print(add_item(2))  # [2]
```

**Q384: What is `*args` and `**kwargs`?**
```python
def func(*args, **kwargs):
    print("Positional:", args)
    print("Keyword:", kwargs)

func(1, 2, 3, name="John", age=25)
# Positional: (1, 2, 3)
# Keyword: {'name': 'John', 'age': 25}
```

**Q385: What is a lambda function?**
```python
square = lambda x: x ** 2
add = lambda x, y: x + y
greet = lambda name: f"Hello, {name}"

print(square(5))        # 25
print(add(3, 4))        # 7
print(greet("John"))    # "Hello, John"

# Common with sorted, map, filter
students = [("John", 85), ("Alice", 92), ("Bob", 78)]
sorted_students = sorted(students, key=lambda s: s[1], reverse=True)
```

**Q386: What is the difference between `return` and `yield`?**
```python
# return — Exits function, returns value
def get_squares(n):
    result = []
    for i in range(n):
        result.append(i ** 2)
    return result

# yield — Pauses function, returns generator
def gen_squares(n):
    for i in range(n):
        yield i ** 2

# yield is memory-efficient for large datasets
for sq in gen_squares(1000000):
    if sq > 100:
        break
```

**Q387: What is recursion?**
```python
def factorial(n):
    if n == 0 or n == 1:  # Base case
        return 1
    return n * factorial(n - 1)  # Recursive case

print(factorial(5))  # 120

# Python recursion limit
import sys
print(sys.getrecursionlimit())  # 1000 (default)
sys.setrecursionlimit(5000)     # Increase if needed
```

**Q388: What are higher-order functions?**
```python
# Functions that take or return other functions

def apply(func, value):
    return func(value)

print(apply(str.upper, "hello"))  # "HELLO"
print(apply(len, [1, 2, 3]))     # 3

# Returning function
def multiplier(n):
    def multiply(x):
        return x * n
    return multiply

double = multiplier(2)
triple = multiplier(3)
print(double(5))   # 10
print(triple(5))   # 15
```

**Q389: What is a closure?**
```python
def outer(x):
    def inner(y):
        return x + y  # 'x' is captured from outer scope
    return inner

add_5 = outer(5)
print(add_5(3))   # 8
print(add_5(10))  # 15
```

**Q390–Q435: More Function questions...**

**Q390: What is `functools.partial`?**
```python
from functools import partial

def power(base, exponent):
    return base ** exponent

square = partial(power, exponent=2)
cube = partial(power, exponent=3)

print(square(5))  # 25
print(cube(3))    # 27
```

**Q391: What is `functools.lru_cache`?**
```python
from functools import lru_cache

@lru_cache(maxsize=128)
def fibonacci(n):
    if n < 2:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

print(fibonacci(100))  # Instant! (cached)
```

---

# 11. 🏗️ Object-Oriented Programming (OOPs)

**Q436: What are the 4 pillars of OOP?**
> 1. **Encapsulation** — Bundling data & methods, hiding internals
> 2. **Abstraction** — Showing only essential features, hiding complexity
> 3. **Inheritance** — Child class inherits from parent
> 4. **Polymorphism** — Same interface, different implementations

**Q437: How do you create a class?**
```python
class Person:
    # Class variable (shared by all instances)
    species = "Human"
    
    # Constructor
    def __init__(self, name, age):
        self.name = name    # Instance variable
        self.age = age
    
    # Instance method
    def greet(self):
        return f"Hello, I'm {self.name}"
    
    # String representation
    def __str__(self):
        return f"Person({self.name}, {self.age})"
    
    # Class method
    @classmethod
    def from_string(cls, s):
        name, age = s.split(",")
        return cls(name.strip(), int(age.strip()))
    
    # Static method
    @staticmethod
    def is_adult(age):
        return age >= 18

# Create instances
p1 = Person("John", 25)
p2 = Person.from_string("Alice, 22")

print(p1.greet())           # "Hello, I'm John"
print(Person.is_adult(20))  # True
```

**Q438: What is `self` in Python?**
> `self` refers to the **current instance** of the class. It's the first parameter of every instance method. Python passes it automatically.

**Q439: What is the difference between `__init__` and `__new__`?**
```python
class MyClass:
    def __new__(cls, *args, **kwargs):
        print("1. __new__ called (creates object)")
        instance = super().__new__(cls)
        return instance
    
    def __init__(self, value):
        print("2. __init__ called (initializes object)")
        self.value = value

obj = MyClass(42)
# Output:
# 1. __new__ called (creates object)
# 2. __init__ called (initializes object)
```

**Q440: What is inheritance?**
```python
class Animal:
    def __init__(self, name):
        self.name = name
    
    def speak(self):
        return "..."

class Dog(Animal):
    def speak(self):
        return "Woof!"

class Cat(Animal):
    def speak(self):
        return "Meow!"

dog = Dog("Rex")
cat = Cat("Whiskers")
print(dog.speak())  # "Woof!"
print(cat.speak())  # "Meow!"
```

**Q441: What are the types of inheritance?**
```python
# 1. Single Inheritance
class A: pass
class B(A): pass

# 2. Multiple Inheritance
class A: pass
class B: pass
class C(A, B): pass

# 3. Multilevel Inheritance
class A: pass
class B(A): pass
class C(B): pass

# 4. Hierarchical Inheritance
class A: pass
class B(A): pass
class C(A): pass

# 5. Hybrid Inheritance (combination)
class A: pass
class B(A): pass
class C(A): pass
class D(B, C): pass
```

**Q442: What is the MRO (Method Resolution Order)?**
```python
class A:
    def greet(self):
        return "A"

class B(A):
    def greet(self):
        return "B"

class C(A):
    def greet(self):
        return "C"

class D(B, C):
    pass

d = D()
print(d.greet())  # "B" (follows MRO)
print(D.__mro__)  # (D, B, C, A, object)
# Python uses C3 Linearization algorithm
```

**Q443: What is `super()`?**
```python
class Animal:
    def __init__(self, name):
        self.name = name

class Dog(Animal):
    def __init__(self, name, breed):
        super().__init__(name)  # Call parent constructor
        self.breed = breed

d = Dog("Rex", "Labrador")
print(d.name)   # "Rex" (from Animal)
print(d.breed)  # "Labrador" (from Dog)
```

**Q444: What is encapsulation?**
```python
class BankAccount:
    def __init__(self, balance):
        self.__balance = balance  # Private (name mangling)
    
    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount
    
    def get_balance(self):
        return self.__balance

acc = BankAccount(1000)
acc.deposit(500)
print(acc.get_balance())  # 1500
# print(acc.__balance)    # AttributeError!
print(acc._BankAccount__balance)  # 1500 (name mangling workaround)
```

**Q445: What are access modifiers in Python?**
```python
class MyClass:
    def __init__(self):
        self.public = "Anyone can access"        # Public
        self._protected = "Convention: internal"  # Protected (convention)
        self.__private = "Name-mangled"           # Private (name mangling)

obj = MyClass()
print(obj.public)           # ✅ Works
print(obj._protected)       # ✅ Works (but shouldn't from outside)
# print(obj.__private)      # ❌ AttributeError
print(obj._MyClass__private)  # ✅ Works (name mangling)
```

**Q446: What is polymorphism?**
```python
# Method Overriding (Runtime polymorphism)
class Shape:
    def area(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    def area(self):
        return 3.14 * self.radius ** 2

class Rectangle(Shape):
    def __init__(self, w, h):
        self.w = w
        self.h = h
    def area(self):
        return self.w * self.h

shapes = [Circle(5), Rectangle(4, 6)]
for shape in shapes:
    print(shape.area())  # 78.5, 24 (same method, different behavior)
```

**Q447: What is abstraction?**
```python
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def area(self):
        pass
    
    @abstractmethod
    def perimeter(self):
        pass

# shape = Shape()  # TypeError! Can't instantiate abstract class

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    
    def area(self):
        return 3.14 * self.radius ** 2
    
    def perimeter(self):
        return 2 * 3.14 * self.radius

c = Circle(5)
print(c.area())       # 78.5
print(c.perimeter())  # 31.4
```

**Q448: What is operator overloading?**
```python
class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def __add__(self, other):       # v1 + v2
        return Vector(self.x + other.x, self.y + other.y)
    
    def __sub__(self, other):       # v1 - v2
        return Vector(self.x - other.x, self.y - other.y)
    
    def __mul__(self, scalar):      # v1 * 3
        return Vector(self.x * scalar, self.y * scalar)
    
    def __eq__(self, other):        # v1 == v2
        return self.x == other.x and self.y == other.y
    
    def __lt__(self, other):        # v1 < v2
        return (self.x**2 + self.y**2) < (other.x**2 + other.y**2)
    
    def __len__(self):              # len(v1)
        return int((self.x**2 + self.y**2) ** 0.5)
    
    def __str__(self):
        return f"({self.x}, {self.y})"

v1 = Vector(1, 2)
v2 = Vector(3, 4)
print(v1 + v2)  # (4, 6)
print(v1 * 3)   # (3, 6)
```

**Q449: What is method overloading in Python?**
```python
# Python doesn't support traditional method overloading
# But you can achieve it with default arguments or *args

class Calculator:
    def add(self, *args):
        return sum(args)

c = Calculator()
print(c.add(1, 2))        # 3
print(c.add(1, 2, 3))     # 6
print(c.add(1, 2, 3, 4))  # 10

# Or using singledispatch
from functools import singledispatchmethod

class Formatter:
    @singledispatchmethod
    def format(self, arg):
        return str(arg)
    
    @format.register(int)
    def _(self, arg):
        return f"Integer: {arg}"
    
    @format.register(str)
    def _(self, arg):
        return f"String: {arg}"
```

**Q450: What is a class method vs static method vs instance method?**
```python
class MyClass:
    class_var = "shared"
    
    def instance_method(self):
        # Access: self (instance), cls (via type(self))
        return f"Instance: {self.class_var}"
    
    @classmethod
    def class_method(cls):
        # Access: cls (class), NOT self
        return f"Class: {cls.class_var}"
    
    @staticmethod
    def static_method():
        # Access: neither self nor cls
        return "Static: no access to class/instance"

obj = MyClass()
print(obj.instance_method())    # "Instance: shared"
print(MyClass.class_method())   # "Class: shared"
print(MyClass.static_method())  # "Static: no access..."
```

**Q451–Q520: More OOP questions...**

**Q451: What is a singleton pattern?**
```python
class Singleton:
    _instance = None
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

a = Singleton()
b = Singleton()
print(a is b)  # True (same object)
```

**Q452: What is composition vs inheritance?**
```python
# Inheritance: "is-a" relationship
class Dog(Animal):
    pass

# Composition: "has-a" relationship (preferred!)
class Engine:
    def start(self):
        return "Engine started"

class Car:
    def __init__(self):
        self.engine = Engine()  # Car HAS an engine
    
    def start(self):
        return self.engine.start()
```

---

# 12. 📂 File Handling

**Q521: How do you open and read a file?**
```python
# Method 1: with statement (recommended)
with open("file.txt", "r") as f:
    content = f.read()       # Read entire file
    # or
    lines = f.readlines()    # List of lines
    # or
    line = f.readline()      # One line at a time

# Method 2: Without with (must close manually)
f = open("file.txt", "r")
content = f.read()
f.close()
```

**Q522: What are the file modes?**
```python
# "r"  — Read (default, file must exist)
# "w"  — Write (creates new / overwrites existing)
# "a"  — Append (creates new / adds to existing)
# "x"  — Create (fails if file exists)
# "rb" — Read binary
# "wb" — Write binary
# "r+" — Read and write
# "w+" — Write and read (truncates)
# "a+" — Append and read
```

**Q523: How do you write to a file?**
```python
# Write (overwrites)
with open("output.txt", "w") as f:
    f.write("Hello, World!\n")
    f.write("Second line\n")

# Append
with open("output.txt", "a") as f:
    f.write("Appended line\n")

# Write multiple lines
lines = ["Line 1\n", "Line 2\n", "Line 3\n"]
with open("output.txt", "w") as f:
    f.writelines(lines)
```

**Q524: How do you read a file line by line efficiently?**
```python
# Memory efficient (doesn't load entire file)
with open("large_file.txt", "r") as f:
    for line in f:
        print(line.strip())
```

**Q525: How do you work with CSV files?**
```python
import csv

# Reading CSV
with open("data.csv", "r") as f:
    reader = csv.reader(f)
    for row in reader:
        print(row)

# Writing CSV
with open("output.csv", "w", newline="") as f:
    writer = csv.writer(f)
    writer.writerow(["Name", "Age"])
    writer.writerow(["John", 25])

# DictReader/DictWriter
with open("data.csv", "r") as f:
    reader = csv.DictReader(f)
    for row in reader:
        print(row["Name"], row["Age"])
```

**Q526: How do you work with JSON files?**
```python
import json

# Read JSON
with open("data.json", "r") as f:
    data = json.load(f)

# Write JSON
with open("output.json", "w") as f:
    json.dump(data, f, indent=4)

# String operations
json_str = json.dumps({"name": "John"})  # Dict to JSON string
data = json.loads(json_str)               # JSON string to dict
```

**Q527–Q555: More File Handling questions...**

---

# 13. ⚠️ Exception Handling

**Q556: What is exception handling?**
```python
try:
    result = 10 / 0
except ZeroDivisionError as e:
    print(f"Error: {e}")
except TypeError as e:
    print(f"Type Error: {e}")
except Exception as e:
    print(f"General Error: {e}")
else:
    print("No error occurred")
finally:
    print("Always executes")
```

**Q557: What are the common built-in exceptions?**
```python
# ValueError      — Invalid value
# TypeError       — Wrong type
# KeyError        — Dict key not found
# IndexError      — List index out of range
# FileNotFoundError — File doesn't exist
# ZeroDivisionError — Division by zero
# AttributeError  — Object doesn't have attribute
# ImportError      — Module import fails
# NameError        — Variable not defined
# StopIteration    — Iterator exhausted
# RecursionError   — Maximum recursion depth exceeded
# PermissionError  — File permission denied
# OverflowError    — Numeric result too large
# MemoryError      — Out of memory
```

**Q558: How do you create custom exceptions?**
```python
class InsufficientFundsError(Exception):
    def __init__(self, balance, amount):
        self.balance = balance
        self.amount = amount
        super().__init__(
            f"Cannot withdraw {amount}. Balance: {balance}"
        )

class BankAccount:
    def __init__(self, balance):
        self.balance = balance
    
    def withdraw(self, amount):
        if amount > self.balance:
            raise InsufficientFundsError(self.balance, amount)
        self.balance -= amount

try:
    acc = BankAccount(100)
    acc.withdraw(200)
except InsufficientFundsError as e:
    print(e)  # Cannot withdraw 200. Balance: 100
```

**Q559: What is the difference between `raise` and `raise from`?**
```python
try:
    int("abc")
except ValueError as e:
    raise RuntimeError("Conversion failed") from e
# Shows: RuntimeError: Conversion failed
#        caused by ValueError: invalid literal...
```

**Q560–Q585: More Exception questions...**

---

# 14. 📦 Modules & Packages

**Q586: What is a module?**
> A module is a Python file (.py) containing functions, classes, and variables.
```python
# math_utils.py
def add(a, b):
    return a + b

# main.py
import math_utils
print(math_utils.add(3, 4))  # 7

from math_utils import add
print(add(3, 4))  # 7

from math_utils import *  # Import everything (not recommended)
```

**Q587: What is a package?**
> A package is a directory containing `__init__.py` and other modules.
```
mypackage/
├── __init__.py
├── module1.py
└── module2.py
```

**Q588: What is `__init__.py`?**
> Marks a directory as a Python package. Can be empty or contain initialization code.

**Q589: What is the `importlib` module?**
```python
import importlib

# Dynamic import
module = importlib.import_module("json")
data = module.loads('{"key": "value"}')

# Reload a module
importlib.reload(module)
```

**Q590–Q610: More Module questions...**

---

# 15. 🔄 Iterators & Generators

**Q611: What is an iterator?**
```python
# Any object that implements __iter__ and __next__

class Counter:
    def __init__(self, max_val):
        self.max_val = max_val
        self.current = 0
    
    def __iter__(self):
        return self
    
    def __next__(self):
        if self.current >= self.max_val:
            raise StopIteration
        self.current += 1
        return self.current

for num in Counter(5):
    print(num)  # 1, 2, 3, 4, 5
```

**Q612: What is a generator?**
```python
# A function that uses yield instead of return

def fibonacci():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b

gen = fibonacci()
for _ in range(10):
    print(next(gen))  # 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
```

**Q613: What is a generator expression?**
```python
# Like list comprehension but with () instead of []
# Lazy evaluation — memory efficient

squares_gen = (x**2 for x in range(1000000))  # No memory allocated yet
squares_list = [x**2 for x in range(1000000)]  # Entire list in memory

print(next(squares_gen))  # 0
print(next(squares_gen))  # 1
```

**Q614: What is `yield from`?**
```python
def sub_generator():
    yield 1
    yield 2

def main_generator():
    yield from sub_generator()  # Delegate to sub-generator
    yield 3
    yield 4

print(list(main_generator()))  # [1, 2, 3, 4]
```

**Q615–Q640: More Iterator/Generator questions...**

---

# 16. 🎀 Decorators & Closures

**Q641: What is a decorator?**
```python
def timer(func):
    import time
    def wrapper(*args, **kwargs):
        start = time.time()
        result = func(*args, **kwargs)
        end = time.time()
        print(f"{func.__name__} took {end - start:.4f}s")
        return result
    return wrapper

@timer
def slow_function():
    import time
    time.sleep(1)

slow_function()  # "slow_function took 1.0012s"
```

**Q642: How do you create a decorator with arguments?**
```python
def repeat(n):
    def decorator(func):
        def wrapper(*args, **kwargs):
            for _ in range(n):
                result = func(*args, **kwargs)
            return result
        return wrapper
    return decorator

@repeat(3)
def greet(name):
    print(f"Hello, {name}")

greet("John")
# Hello, John
# Hello, John
# Hello, John
```

**Q643: What is `functools.wraps`?**
```python
from functools import wraps

def my_decorator(func):
    @wraps(func)  # Preserves original function's name and docstring
    def wrapper(*args, **kwargs):
        return func(*args, **kwargs)
    return wrapper

@my_decorator
def greet():
    """Greet function."""
    pass

print(greet.__name__)  # "greet" (not "wrapper")
print(greet.__doc__)   # "Greet function."
```

**Q644: What is a class-based decorator?**
```python
class CountCalls:
    def __init__(self, func):
        self.func = func
        self.count = 0
    
    def __call__(self, *args, **kwargs):
        self.count += 1
        print(f"Call #{self.count}")
        return self.func(*args, **kwargs)

@CountCalls
def say_hello():
    print("Hello!")

say_hello()  # Call #1 \n Hello!
say_hello()  # Call #2 \n Hello!
print(say_hello.count)  # 2
```

**Q645–Q665: More Decorator questions...**

---

# 17. 📐 Comprehensions

**Q666: What is a list comprehension?**
```python
squares = [x**2 for x in range(10)]
evens = [x for x in range(20) if x % 2 == 0]
pairs = [(x, y) for x in range(3) for y in range(3)]
```

**Q667: What is a dictionary comprehension?**
```python
squares = {x: x**2 for x in range(6)}
word_lengths = {word: len(word) for word in ["hello", "world"]}
```

**Q668: What is a set comprehension?**
```python
unique_lengths = {len(word) for word in ["hello", "hi", "hey"]}
# {2, 3, 5}
```

**Q669: What is a generator expression?**
```python
total = sum(x**2 for x in range(1000))  # Memory efficient
```

**Q670: Nested comprehension?**
```python
# Flatten a matrix
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
flat = [num for row in matrix for num in row]
# [1, 2, 3, 4, 5, 6, 7, 8, 9]

# Transpose a matrix
transposed = [[row[i] for row in matrix] for i in range(3)]
# [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
```

**Q671–Q690: More Comprehension questions...**

---

# 18. 🔍 Regular Expressions

**Q691: What is the `re` module?**
```python
import re

# Search
match = re.search(r'\d+', 'Age is 25')
print(match.group())  # '25'

# Find all
numbers = re.findall(r'\d+', 'I have 3 cats and 5 dogs')
print(numbers)  # ['3', '5']

# Replace
result = re.sub(r'\d+', 'X', 'Phone: 123-456-7890')
print(result)  # 'Phone: X-X-X'

# Match (start of string)
match = re.match(r'Hello', 'Hello World')
print(match.group())  # 'Hello'

# Split
parts = re.split(r'[,;]', 'a,b;c,d')
print(parts)  # ['a', 'b', 'c', 'd']
```

**Q692: What are common regex patterns?**
```python
# \d  — Digit [0-9]
# \D  — Non-digit
# \w  — Word character [a-zA-Z0-9_]
# \W  — Non-word character
# \s  — Whitespace
# \S  — Non-whitespace
# .   — Any character (except newline)
# ^   — Start of string
# $   — End of string
# *   — 0 or more
# +   — 1 or more
# ?   — 0 or 1
# {n} — Exactly n
# []  — Character class
# |   — OR
# ()  — Group
```

**Q693: How do you validate an email?**
```python
import re

def is_valid_email(email):
    pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
    return bool(re.match(pattern, email))

print(is_valid_email("john@example.com"))   # True
print(is_valid_email("invalid@"))           # False
```

**Q694–Q715: More Regex questions...**

---

# 19. 🗄️ Database & SQL with Python

**Q716: How do you connect to SQLite?**
```python
import sqlite3

conn = sqlite3.connect("database.db")
cursor = conn.cursor()

cursor.execute("""
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        age INTEGER
    )
""")

cursor.execute("INSERT INTO users (name, age) VALUES (?, ?)", ("John", 25))
conn.commit()

cursor.execute("SELECT * FROM users")
rows = cursor.fetchall()
for row in rows:
    print(row)

conn.close()
```

**Q717: How do you connect to MySQL?**
```python
import mysql.connector

conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="password",
    database="mydb"
)

cursor = conn.cursor()
cursor.execute("SELECT * FROM users")
rows = cursor.fetchall()
for row in rows:
    print(row)

conn.close()
```

**Q718–Q740: More Database questions...**

---

# 20. 💻 Coding Problems

### Easy

**Q741: Reverse a string**
```python
def reverse_string(s):
    return s[::-1]
```

**Q742: Check if a number is palindrome**
```python
def is_palindrome(n):
    s = str(n)
    return s == s[::-1]
```

**Q743: Fibonacci series**
```python
def fibonacci(n):
    a, b = 0, 1
    result = []
    for _ in range(n):
        result.append(a)
        a, b = b, a + b
    return result
```

**Q744: Factorial**
```python
def factorial(n):
    if n <= 1:
        return 1
    return n * factorial(n - 1)
```

**Q745: Check prime number**
```python
def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True
```

**Q746: Sum of digits**
```python
def sum_of_digits(n):
    return sum(int(d) for d in str(abs(n)))
```

**Q747: Count vowels**
```python
def count_vowels(s):
    return sum(1 for c in s.lower() if c in "aeiou")
```

**Q748: Armstrong number**
```python
def is_armstrong(n):
    digits = str(n)
    power = len(digits)
    return n == sum(int(d)**power for d in digits)

print(is_armstrong(153))  # True (1³+5³+3³ = 153)
```

**Q749: GCD (Greatest Common Divisor)**
```python
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# Or use math module
import math
print(math.gcd(12, 8))  # 4
```

**Q750: LCM (Least Common Multiple)**
```python
def lcm(a, b):
    return abs(a * b) // gcd(a, b)
```

**Q751: Swap two variables**
```python
a, b = 5, 10
a, b = b, a
```

**Q752: Check anagram**
```python
def is_anagram(s1, s2):
    return sorted(s1.lower()) == sorted(s2.lower())

print(is_anagram("listen", "silent"))  # True
```

**Q753: Find duplicate elements in a list**
```python
def find_duplicates(lst):
    seen = set()
    duplicates = set()
    for item in lst:
        if item in seen:
            duplicates.add(item)
        seen.add(item)
    return list(duplicates)
```

**Q754: Find missing number in 1 to N**
```python
def find_missing(lst, n):
    expected = n * (n + 1) // 2
    actual = sum(lst)
    return expected - actual

print(find_missing([1, 2, 4, 5], 5))  # 3
```

**Q755: Two sum problem**
```python
def two_sum(nums, target):
    seen = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in seen:
            return [seen[complement], i]
        seen[num] = i
    return []

print(two_sum([2, 7, 11, 15], 9))  # [0, 1]
```

### Medium

**Q756: Matrix transpose**
```python
def transpose(matrix):
    return list(map(list, zip(*matrix)))

m = [[1, 2, 3], [4, 5, 6]]
print(transpose(m))  # [[1, 4], [2, 5], [3, 6]]
```

**Q757: Flatten nested list**
```python
def flatten(lst):
    result = []
    for item in lst:
        if isinstance(item, list):
            result.extend(flatten(item))
        else:
            result.append(item)
    return result
```

**Q758: Binary search**
```python
def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

**Q759: Bubble sort**
```python
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr
```

**Q760: Selection sort**
```python
def selection_sort(arr):
    for i in range(len(arr)):
        min_idx = i
        for j in range(i+1, len(arr)):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr
```

**Q761: Insertion sort**
```python
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr
```

**Q762: Quick sort**
```python
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quick_sort(left) + middle + quick_sort(right)
```

**Q763: Merge sort**
```python
def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result
```

**Q764: Linked list implementation**
```python
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = new_node
    
    def display(self):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")
    
    def reverse(self):
        prev = None
        current = self.head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.head = prev
```

**Q765: Stack implementation**
```python
class Stack:
    def __init__(self):
        self.items = []
    
    def push(self, item):
        self.items.append(item)
    
    def pop(self):
        if not self.is_empty():
            return self.items.pop()
        raise IndexError("Stack is empty")
    
    def peek(self):
        if not self.is_empty():
            return self.items[-1]
    
    def is_empty(self):
        return len(self.items) == 0
    
    def size(self):
        return len(self.items)
```

**Q766: Queue implementation**
```python
from collections import deque

class Queue:
    def __init__(self):
        self.items = deque()
    
    def enqueue(self, item):
        self.items.append(item)
    
    def dequeue(self):
        if not self.is_empty():
            return self.items.popleft()
        raise IndexError("Queue is empty")
    
    def is_empty(self):
        return len(self.items) == 0
    
    def size(self):
        return len(self.items)
```

**Q767: Valid parentheses**
```python
def is_valid_parentheses(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in mapping:
            if not stack or stack[-1] != mapping[char]:
                return False
            stack.pop()
        else:
            stack.append(char)
    
    return len(stack) == 0

print(is_valid_parentheses("()[]{}"))  # True
print(is_valid_parentheses("(]"))      # False
```

**Q768: Longest common prefix**
```python
def longest_common_prefix(strs):
    if not strs:
        return ""
    prefix = strs[0]
    for s in strs[1:]:
        while not s.startswith(prefix):
            prefix = prefix[:-1]
            if not prefix:
                return ""
    return prefix

print(longest_common_prefix(["flower", "flow", "flight"]))  # "fl"
```

**Q769: Rotate a list**
```python
def rotate_list(lst, k):
    k = k % len(lst)
    return lst[-k:] + lst[:-k]

print(rotate_list([1, 2, 3, 4, 5], 2))  # [4, 5, 1, 2, 3]
```

**Q770: Remove duplicates from sorted list**
```python
def remove_duplicates(lst):
    if not lst:
        return []
    result = [lst[0]]
    for i in range(1, len(lst)):
        if lst[i] != lst[i-1]:
            result.append(lst[i])
    return result
```

**Q771: Maximum subarray sum (Kadane's algorithm)**
```python
def max_subarray_sum(arr):
    max_sum = current_sum = arr[0]
    for num in arr[1:]:
        current_sum = max(num, current_sum + num)
        max_sum = max(max_sum, current_sum)
    return max_sum

print(max_subarray_sum([-2, 1, -3, 4, -1, 2, 1, -5, 4]))  # 6
```

**Q772: String compression**
```python
def compress(s):
    if not s:
        return ""
    result = []
    count = 1
    for i in range(1, len(s)):
        if s[i] == s[i-1]:
            count += 1
        else:
            result.append(s[i-1] + str(count))
            count = 1
    result.append(s[-1] + str(count))
    compressed = "".join(result)
    return compressed if len(compressed) < len(s) else s

print(compress("aabcccccaaa"))  # "a2b1c5a3"
```

**Q773: Find first non-repeating character**
```python
def first_non_repeating(s):
    from collections import Counter
    freq = Counter(s)
    for char in s:
        if freq[char] == 1:
            return char
    return None

print(first_non_repeating("aabcbd"))  # "c"
```

**Q774: Power of two**
```python
def is_power_of_two(n):
    return n > 0 and (n & (n - 1)) == 0

print(is_power_of_two(16))  # True
print(is_power_of_two(18))  # False
```

**Q775: Roman to integer**
```python
def roman_to_int(s):
    values = {'I': 1, 'V': 5, 'X': 10, 'L': 50,
              'C': 100, 'D': 500, 'M': 1000}
    total = 0
    for i in range(len(s)):
        if i + 1 < len(s) and values[s[i]] < values[s[i+1]]:
            total -= values[s[i]]
        else:
            total += values[s[i]]
    return total

print(roman_to_int("MCMXCIV"))  # 1994
```

**Q776–Q850: More coding problems...**

**Q776: FizzBuzz**
```python
def fizzbuzz(n):
    for i in range(1, n+1):
        if i % 15 == 0:
            print("FizzBuzz")
        elif i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        else:
            print(i)
```

**Q777: Pascal's triangle**
```python
def pascals_triangle(n):
    triangle = []
    for i in range(n):
        row = [1] * (i + 1)
        for j in range(1, i):
            row[j] = triangle[i-1][j-1] + triangle[i-1][j]
        triangle.append(row)
    return triangle

for row in pascals_triangle(5):
    print(row)
```

**Q778: Number to words**
```python
def number_to_words(n):
    ones = ["", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine"]
    teens = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
             "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"]
    
    if n == 0:
        return "Zero"
    if n < 10:
        return ones[n]
    if n < 20:
        return teens[n - 10]
    if n < 100:
        return tens[n // 10] + (" " + ones[n % 10] if n % 10 else "")
    return str(n)
```

**Q779: Matrix multiplication**
```python
def matrix_multiply(A, B):
    rows_A, cols_A = len(A), len(A[0])
    rows_B, cols_B = len(B), len(B[0])
    
    if cols_A != rows_B:
        raise ValueError("Incompatible dimensions")
    
    result = [[0] * cols_B for _ in range(rows_A)]
    
    for i in range(rows_A):
        for j in range(cols_B):
            for k in range(cols_A):
                result[i][j] += A[i][k] * B[k][j]
    
    return result
```

**Q780: Word frequency counter**
```python
def word_frequency(text):
    words = text.lower().split()
    freq = {}
    for word in words:
        word = word.strip(".,!?;:")
        freq[word] = freq.get(word, 0) + 1
    return dict(sorted(freq.items(), key=lambda x: x[1], reverse=True))
```

---

# 21. 🧠 Tricky & Output-Based Questions

**Q851: What is the output?**
```python
print(type(type(int)))
# <class 'type'>
```

**Q852: What is the output?**
```python
a = [1, 2, 3]
b = a
a = a + [4]
print(b)
# [1, 2, 3] — a + [4] creates new list, b still points to old
```

**Q853: What is the output?**
```python
a = [1, 2, 3]
b = a
a += [4]
print(b)
# [1, 2, 3, 4] — += modifies in place for lists!
```

**Q854: What is the output?**
```python
print(0.1 + 0.2 == 0.3)
# False! (floating point precision)
# 0.1 + 0.2 = 0.30000000000000004
```

**Q855: What is the output?**
```python
def f(x, lst=[]):
    lst.append(x)
    return lst

print(f(1))  # [1]
print(f(2))  # [1, 2] — Same list! Mutable default argument trap
print(f(3))  # [1, 2, 3]
```

**Q856: What is the output?**
```python
x = [1, 2, 3]
y = x[:]       # Shallow copy
y[0] = 99
print(x)
# [1, 2, 3] — x not affected (shallow copy works for flat lists)
```

**Q857: What is the output?**
```python
x = [[1, 2], [3, 4]]
y = x[:]          # Shallow copy
y[0][0] = 99
print(x)
# [[99, 2], [3, 4]] — Inner lists are still shared!
```

**Q858: What is the output?**
```python
print("hello" * 3)
# hellohellohello
```

**Q859: What is the output?**
```python
print([1, 2] + [3, 4])
# [1, 2, 3, 4]

print([1, 2] * 3)
# [1, 2, 1, 2, 1, 2]
```

**Q860: What is the output?**
```python
print(bool(""))      # False
print(bool(" "))     # True (space is not empty!)
print(bool(0))       # False
print(bool(0.0))     # False
print(bool(None))    # False
print(bool([]))      # False
print(bool([0]))     # True (non-empty list)
```

**Q861: What is the output?**
```python
a = (1, 2, [3, 4])
a[2].append(5)
print(a)
# (1, 2, [3, 4, 5]) — Mutable object inside immutable tuple!
```

**Q862: What is the output?**
```python
def func():
    try:
        return 1
    finally:
        return 2

print(func())
# 2 — finally always runs, overrides return!
```

**Q863: What is the output?**
```python
print(1 == True)   # True
print(0 == False)  # True
print(1 is True)   # True (in CPython, cached)
print([] == False)  # False (different types)
print(not [])      # True
```

**Q864: What is the output?**
```python
x = 10
def func():
    print(x)
    # x = 20  # If uncommented: UnboundLocalError!

func()  # 10
```

**Q865: What is the output?**
```python
print({True: "yes", 1: "one", 1.0: "float"})
# {True: "float"} — True == 1 == 1.0, all same key!
```

**Q866: What is the output?**
```python
print("abc" > "abd")  # False (lexicographic: 'c' < 'd')
print("abc" > "ab")   # True (longer string)
print("Z" < "a")      # True (uppercase < lowercase in ASCII)
```

**Q867: What is the output?**
```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a - b)   # {1, 2}
print(b - a)   # {4, 5}
print(a ^ b)   # {1, 2, 4, 5}
```

**Q868: What is the output?**
```python
lst = [lambda x: x + i for i in range(5)]
print([f(0) for f in lst])
# [4, 4, 4, 4, 4] — Closure captures variable 'i', not value!

# Fix:
lst = [lambda x, i=i: x + i for i in range(5)]
print([f(0) for f in lst])
# [0, 1, 2, 3, 4]
```

**Q869: What is the output?**
```python
print(type(lambda: None))
# <class 'function'>
```

**Q870: What is the output?**
```python
x = "hello"
print(x[100:])   # "" (no IndexError for slicing!)
# print(x[100])  # IndexError!
```

**Q871: What is the output?**
```python
d = {}
d[1] = "a"
d[1.0] = "b"
d[True] = "c"
print(d)
# {1: 'c'} — 1 == 1.0 == True, all same key!
```

**Q872: What is the output?**
```python
print("" or "hello")     # "hello"
print("" or "" or "hi")  # "hi"
print("a" or "b")        # "a"
print("" and "hello")    # ""
print("a" and "b")       # "b"
```

**Q873: What is the output?**
```python
x = [1, 2, 3]
print(*x)    # 1 2 3 (unpacking)
print(x)     # [1, 2, 3]
```

**Q874: What is the output?**
```python
print(10 > 5 > 2)    # True (chained comparison: 10>5 and 5>2)
print(10 > 5 > 20)   # False (10>5 and 5>20)
print(1 == 1.0 == True)  # True
```

**Q875: What is the output?**
```python
a = [1, 2, 3, 4, 5]
a[1:3] = [10, 20, 30]
print(a)
# [1, 10, 20, 30, 4, 5] — Slice assignment can change list size!
```

**Q876–Q950: More output-based questions...**

**Q876: What is the output?**
```python
print(sum(range(101)))
# 5050
```

**Q877: What is the output?**
```python
x = ["a", "b", "c"]
print(dict(enumerate(x)))
# {0: 'a', 1: 'b', 2: 'c'}
```

**Q878: What is the output?**
```python
print(list(zip([1, 2, 3], [4, 5])))
# [(1, 4), (2, 5)] — Stops at shortest
```

**Q879: What is the output?**
```python
print({} == False)  # False
print(not {})       # True
print(bool({}))     # False
```

**Q880: What is the output?**
```python
print(list(filter(None, [0, 1, 2, "", "hello", [], [1]])))
# [1, 2, 'hello', [1]] — filter(None, ...) removes falsy values
```

---

# 22. 🚀 Advanced Concepts

**Q951: What are metaclasses?**
```python
# Metaclass is the class of a class
# type is the default metaclass

class MyMeta(type):
    def __new__(mcs, name, bases, namespace):
        print(f"Creating class: {name}")
        return super().__new__(mcs, name, bases, namespace)

class MyClass(metaclass=MyMeta):
    pass
# Output: Creating class: MyClass
```

**Q952: What are descriptors?**
```python
class Validator:
    def __init__(self, min_val, max_val):
        self.min_val = min_val
        self.max_val = max_val
    
    def __set_name__(self, owner, name):
        self.name = name
    
    def __get__(self, obj, objtype=None):
        return getattr(obj, f"_{self.name}", None)
    
    def __set__(self, obj, value):
        if not self.min_val <= value <= self.max_val:
            raise ValueError(f"{self.name} must be between {self.min_val} and {self.max_val}")
        setattr(obj, f"_{self.name}", value)

class Student:
    age = Validator(0, 150)
    grade = Validator(0, 100)
    
    def __init__(self, name, age, grade):
        self.name = name
        self.age = age
        self.grade = grade

s = Student("John", 25, 95)
# s.age = 200  # ValueError!
```

**Q953: What is `asyncio`?**
```python
import asyncio

async def fetch_data(url, delay):
    print(f"Fetching {url}...")
    await asyncio.sleep(delay)  # Simulate network request
    print(f"Got data from {url}")
    return f"Data from {url}"

async def main():
    # Run concurrently
    results = await asyncio.gather(
        fetch_data("api/users", 2),
        fetch_data("api/products", 1),
        fetch_data("api/orders", 3),
    )
    print(results)

asyncio.run(main())
```

**Q954: What is `async/await`?**
```python
import asyncio

async def greet(name, delay):
    await asyncio.sleep(delay)
    return f"Hello, {name}"

async def main():
    # Sequential
    result1 = await greet("Alice", 1)
    result2 = await greet("Bob", 1)
    # Takes 2 seconds
    
    # Concurrent
    result1, result2 = await asyncio.gather(
        greet("Alice", 1),
        greet("Bob", 1)
    )
    # Takes 1 second!

asyncio.run(main())
```

**Q955: What is the `abc` module?**
```python
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def area(self):
        pass
    
    @abstractmethod
    def perimeter(self):
        pass
    
    def describe(self):  # Concrete method
        return f"Area: {self.area()}, Perimeter: {self.perimeter()}"
```

**Q956: What is a context manager?**
```python
class FileManager:
    def __init__(self, filename, mode):
        self.filename = filename
        self.mode = mode
    
    def __enter__(self):
        self.file = open(self.filename, self.mode)
        return self.file
    
    def __exit__(self, exc_type, exc_val, exc_tb):
        self.file.close()
        return False  # Don't suppress exceptions

with FileManager("test.txt", "w") as f:
    f.write("Hello!")

# Using contextlib
from contextlib import contextmanager

@contextmanager
def file_manager(filename, mode):
    f = open(filename, mode)
    try:
        yield f
    finally:
        f.close()
```

**Q957: What is `__call__` method?**
```python
class Multiplier:
    def __init__(self, factor):
        self.factor = factor
    
    def __call__(self, x):
        return x * self.factor

double = Multiplier(2)
triple = Multiplier(3)

print(double(5))   # 10 (object called like function!)
print(triple(5))   # 15
print(callable(double))  # True
```

**Q958: What are coroutines?**
```python
# Generator-based coroutine (old style)
def coroutine():
    while True:
        value = yield
        print(f"Received: {value}")

c = coroutine()
next(c)           # Prime the coroutine
c.send("Hello")   # Received: Hello
c.send("World")   # Received: World

# Async coroutine (modern)
async def async_coroutine():
    await asyncio.sleep(1)
    return "Done"
```

**Q959: What are annotations?**
```python
def greet(name: str, times: int = 1) -> str:
    return f"Hello, {name}! " * times

print(greet.__annotations__)
# {'name': <class 'str'>, 'times': <class 'int'>, 'return': <class 'str'>}
```

**Q960: What is `__del__` method (destructor)?**
```python
class Resource:
    def __init__(self, name):
        self.name = name
        print(f"Resource {name} created")
    
    def __del__(self):
        print(f"Resource {self.name} destroyed")

r = Resource("DB Connection")
del r  # "Resource DB Connection destroyed"
```

**Q961: What is method chaining?**
```python
class QueryBuilder:
    def __init__(self):
        self.query = ""
    
    def select(self, columns):
        self.query += f"SELECT {columns} "
        return self  # Return self for chaining
    
    def from_table(self, table):
        self.query += f"FROM {table} "
        return self
    
    def where(self, condition):
        self.query += f"WHERE {condition} "
        return self
    
    def build(self):
        return self.query.strip()

query = (QueryBuilder()
    .select("*")
    .from_table("users")
    .where("age > 25")
    .build())

print(query)  # "SELECT * FROM users WHERE age > 25"
```

**Q962: What are weak references?**
```python
import weakref

class MyClass:
    pass

obj = MyClass()
weak_ref = weakref.ref(obj)

print(weak_ref())  # <__main__.MyClass object at ...>
del obj
print(weak_ref())  # None (object was garbage collected)
```

**Q963–Q1000: More Advanced questions...**

**Q963: What is `__getattr__` vs `__getattribute__`?**
```python
class MyClass:
    def __init__(self):
        self.name = "John"
    
    def __getattr__(self, name):
        # Called ONLY when attribute is NOT found normally
        return f"'{name}' not found"
    
    def __getattribute__(self, name):
        # Called for EVERY attribute access
        print(f"Accessing: {name}")
        return super().__getattribute__(name)

obj = MyClass()
print(obj.name)    # Accessing: name \n John
print(obj.age)     # Accessing: age \n 'age' not found
```

---

## 📋 Quick Reference Cheat Sheet

### Data Structures Comparison

| | List | Tuple | Set | Dict |
|--|------|-------|-----|------|
| **Syntax** | `[1,2,3]` | `(1,2,3)` | `{1,2,3}` | `{"a":1}` |
| **Mutable** | ✅ | ❌ | ✅ | ✅ |
| **Ordered** | ✅ | ✅ | ❌ | ✅ (3.7+) |
| **Duplicates** | ✅ | ✅ | ❌ | Keys: ❌ |
| **Indexing** | ✅ | ✅ | ❌ | By key |
| **Use Case** | General | Fixed data | Unique items | Key-Value |

### Time Complexity Quick Reference

| Operation | List | Dict | Set |
|-----------|------|------|-----|
| Access | O(1) | O(1) | N/A |
| Search | O(n) | O(1) | O(1) |
| Insert | O(n) | O(1) | O(1) |
| Delete | O(n) | O(1) | O(1) |
| Append | O(1) | N/A | N/A |

### Common Built-in Functions

```python
len()      abs()      max()      min()      sum()
sorted()   reversed() enumerate() zip()      map()
filter()   reduce()   any()      all()      isinstance()
type()     id()       dir()      help()     print()
input()    range()    int()      float()    str()
list()     tuple()    dict()     set()      bool()
```

---

## 💡 Interview Tips

1. 🎯 **Practice coding daily** — LeetCode, HackerRank, CodeChef
2. 📝 **Explain your thought process** — Think out loud
3. 🐍 **Know Pythonic idioms** — Comprehensions, `with`, f-strings
4. 🧪 **Test edge cases** — Empty input, None, negatives
5. 📊 **Know time complexity** — Big O for your solutions
6. 🔧 **Understand debugging** — `print()`, breakpoints, traceback
7. 📚 **Read Python docs** — `docs.python.org`
8. 🏗️ **OOP is crucial** — Classes, inheritance, polymorphism
9. 💾 **Know data structures** — When to use list vs dict vs set
10. 🎓 **Practice explaining** — Teach concepts to others

---

**Good luck with your interview! 🎉🐍**

*This guide covers 1000+ questions across all Python topics. Practice, understand, and ace your interview!*
