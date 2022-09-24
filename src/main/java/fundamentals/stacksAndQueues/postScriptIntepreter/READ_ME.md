# Post Script Simple Interpreter

resources
* https://www.adobe.com/jp/print/postscript/pdfs/PLRM.pdf

## Into

This documents describes specification for simple post script intepreter implementations

## Requirements

### Interpreter

The interpreter manipulates entities called **PostScript objects**
* data (numbers, boolean, strings, arrays)
* exe elements (name, operators)

Any PostScript object may be treated as data or be executed as part of a program (there is not a distinction between data and programs). The interpreter operates by executing a sequence of objects. The effect of executing a particular object depends on that object’s type, attributes, and value.
* as each object is scanned it is immediately executed
* object stored in an array in memory may be executed

The interpreter can switch back and forth between executing a procedure and scanning a character stream

There is no notion of “reading in” a program before executing it. Instead, the PostScript interpreter consumes a
program by reading and executing one syntactic entity at a time.

From the interpreter’s point of view, the program has no permanent existence. Execution of the program may have
side effects in the interpreter’s memory or elsewhere (creation of procedure objects in memory).

#### Scanner

 A scanner groups characters into **tokens** according to the PostScript language syntax rules. It then assembles one or more tokens to create a **PostScript object—in other words, a data value in the interpreter’s memory**.
Finally, the interpreter executes the object.

Example:
1. scanner read digits surrounded by spaces
2. create token and converts data into a Post Scrip number object
3. The interpreter then executes this number object (Pushes a copy of the object on the operand stack)

The characters (, ), <, >, [, ], {, }, /, and % are special. They delimit syntactic entities
such as strings, procedure bodies, name literals, and comments

##### Comments
* from % to end of the line
* The scanner ignores comments

##### Numbers
* integer: 23 −98 43445 0 +17
* real −.002 34.5 −3.62 123. −1. 0.0 (no exponent)
* radix 8#112 (base#number)

##### String
* literal text (this is a string)
* name
   1. literal name /test
   2. immediately evaluated name //test (substition)
   3. executable name test

##### Array
* list of items can be any type
* [123 /abd (xyz)]

##### Procedures (executable array)
* {add 2 div}
* The interpreter does not execute a procedure immediately, but treats it as data; it
pushes the procedure on the operand stack.
* A procedure is an array that can be executed by the PostScript interpreter

##### Dictionaries
* key value par
* <<key, value, key value...>>
* << >> -when executed cause a dictionary to be constructed

#### Data Types and PostScript Object
Created by the scanner and executed by the interpreter
All data including procedures exist in the form of PostScript objects
Objects are produced manipulated and consumed by the PostScript operators

##### PostScript object
Each object has a type (object’s type is a property of the object itself), some attributes and a value

* simple object: boolean, integer, name, null, operator, real
* composite: array, dictionary, string

**Composite object** value is separated from the object itself, some types have internal substructure. The values of composite objects reside in a special region of memory called *virtual memory*

When simple object is copied all of its parts are copied. When a composite object is copied the value is not copied, the orginal and copy object **share** the same value.

*PostScript attributes affect* the behavior of the object when it is executed or when certain operations are performed on it. They do not affect its behavior when it is treated strictly as data

Object is
* literal: treated as data and pushed it the operand stack (integer, real, string, names with /, array (produce a literal array object with the *enclosed objects* as elements))
* executable: executed by interpreter (names with //, names, dictionary(produce literal dictionary).


It does not matter whether an object is literal or executable when it is accessed as data, only when it is executed.
However, referring to an executable object by name often causes that object to be executed automatically;

Executing
* name: look in the current dictionary and the associated value to be executed
* operator: build-in action to be performed
* procedure (exe array): execute elements of the array one by one

##### Name PostScript object
Name is a simple object not made up of other objects.

Names do not have values, unlike variable or procedure names in other program-
ming languages. However, names can be associated with values in dictionaries.

##### Dictionary
entries are pairs of PostScript objects. First is key second is the value
If you attempt to use a string as a key, the PostScript interpreter will first convert the string to a name object
Dictionaries ordinarily associate the names and values of a program’s components,
such as variables and procedures

The interpreter maintains a dictionary stack defining the current dynamic name
space. Dictionaries may be pushed on and popped off the dictionary stack at will.
The topmost dictionary on the stack is the **current dictionary**.

There are two built-in dictionaries in the dictionary stack
* *systemdict* is a read-only dictionary that associates the names of all the Post-
Script operator
* *userdict* is a writeable dictionary in local VM. It is the default modifiable naming environment normally

##### Operator object
PostScript language’s built-in actions.

Operators have names. Most operators are associated with names in systemdict, the names are the keys and the operators are the associated value

#### Stacks
Stacks are “last in, first out” (LIFO) data
structures. The PostScript interpreter manages stacks representing the execution state of
a PostScript program
* **The operand stack** holds arbitrary PostScript objects that are the operands and
results of PostScript operators being executed. The interpreter pushes objects
on the operand stack when it encounters them as literal data in a program being executed. When an operator requires one or more operands, it obtains
them by popping them off the top of the operand stack. When an operator returns one or more results, it does so by pushing them on the operand stack. Under the control of the PostScript program being
executed. Objects may be pushed and popped arbitrarily by various operators.
* **The dictionary stack** holds only dictionary objects. The current set of dictionaries on the dictionary stack defines the environment for all implicit name
searches, such as those that occur when the interpreter encounters an executable name. The dictionary stack is also under PostScript program control, but it can hold
only dictionaries.
* **The execution stack** holds executable objects that
are in intermediate stages of execution. At any point in the execution of a PostScript program, this stack represents the program’s call stack. Whenever the 
interpreter suspends execution of an object to execute some other object, it
pushes the new object on the execution stack. When the interpreter finishes executing an object, it pops that object off the execution stack and resumes executing the suspended object beneath it. Under the control of the PostScript interpreter. It can be
read but not directly modified by a PostScript program

When an object is pushed on a stack, the object is copied onto the stack from wherever it was obtained; however, in the case of a composite object (such as an array, a string, or a dictionary), the object’s value is not copied onto the stack, but rather is shared with the original object.

####  Execution
40 60 add 2 div

The interpreter first encounters the literal integer object 40 and pushes it on the
operand stack. Do the same with 60.
Next, it encounters the *executable name object add*, which it looks up in the environment of the current dictionary stack then execute it. (This invokes a built-in function that pops the two integer objects off the operand stack). The rest of the program fragment is executed similarly.

/average {add 2 div} def

40 60 average

The interpreter first encounters the literal name average. (pushes this object on the operand stack, as it would any object having the literal attribute.)

**An executable array or packed array encountered directly by the interpreter is treated as data
(pushed on the operand stack), but an executable array or packed array encountered indirectly—as a result of executing some other object, such as a name or an
operator—is invoked as a procedure**

So executable array {add 2 div} that is produced by the scanner (contains three elements) and pushed it on the operand stack

Then executable name def popus two objects (exe array and name) and enters this pair into current dictionary

The rest is the same.

#####  Execution of specific types

An object with the literal attribute is always treated as data—pushed on the operand stack by the interpreter—regardless of its type.
For many objects, executing them has the same effect as treating them as data. This is true of integer, real, boolean, dictionary.

**An executable array** (procedure) object is pushed on
the operand stack if it is encountered directly by the interpreter. If it is invoked
indirectly as a result of executing some other object (a name or an operator), it
is called instead. The interpreter calls a procedure by pushing it on the execution stack and then executing the array elements in turn. When the interpreter
reaches the end of the procedure, it pops the procedure object off the execution
stack. (Actually, it pops the procedure object when there is one element
remaining and then pushes that element; this permits unlimited depth of “tail
recursion” without overflowing the execution stack.

**An executable name** object is looked up in the environment of the current dictionary stack and its associated value is executed.  If it finds the name as a key in some dictionary, it
executes the associated value. To do that, it examines the value’s type and executable attribute and performs the appropriate action described in this section

**An executable operator** object causes the interpreter to perform one of the builtin operations

**Basic operators**
* stack
    * pop
    * push
    * clear
* arithmetic and mathematical
    * add, sub, mul, div, mod
    * abs, neg, ceiling, floor, round
    * sqrt, exp, ln, log, sin, cos, atan
    * rand
* array
    * get
    * put

#### Memory Management
A PostScript program executes in an environment with these major components

* *The operand stack* is working storage for objects that are the operands and results of operators.
* *The dictionary stack* contains dictionary objects that define the current name space.
* *The execution stack* contains objects that are in partial stages of execution by the PostScript interpreter.
* *Virtual memory (VM)* is a storage pool for the values of all composite objects.
The adjective “virtual” emphasizes the behavior of this memory visible at the
PostScript language level, not its implementation in computer storage
* *Input file* is the normal source of program text to be executed by
the PostScript interpreter
* *Output file* output of the program

##### Virtual memory

A composite object’s value is stored separately; the object contains a reference to it.
Virtual memory (VM) is the storage in which the values of composite objects reside.

(string1) - The
string, which is a composite object, contains a reference to the value string1,
which is a text string that resides in VM

The garbage collector reclaims the memory occupied by composite objects that are no longer accessible to the PostScript program

For example, after the program
/a (string1) def
/a (string2) def
(string3) show
is executed, the string object string1 is no longer accessible, since the dictionary
entry that referred to it has been replaced by a different object, string2. Similarly,
the string object string3 is no longer accessible, since the show operator consumes its operand but does not store it anywhere. These inaccessible strings are
candidates for garbage collection.
Garbage collection normally takes place without explicit action by the PostScript
program. It has no effects that are visible to the program. However, If no garbage collector is present, a program that consumes VM endlessly can have memory problems.

## Solution description

