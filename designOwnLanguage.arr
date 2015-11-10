# This is a new programming language called arrow.

# arrow explores the idea of minimalism, but
# is designed with education in mind.

# In particular, while teaching programming to high
# school students it has been noticed that assignment operator
# is a major hurdle in understanding programming.
# part of the reason might be that assignment operator
# actually works backwards!
# Let's look at an example
# in Python for example, person = "adam" means actually
# person <- "adam", that is, put "adam" into a container
# person. Right to left!
#
# In arrow this great mistake of many programming languages preceding arrow
# is fixed. "adam" -> person
"adam" -> person1
"iva"  -> person2

# this is how variable swap is expressed
person1 -> temporaryPerson
person2 -> person1
temporaryPerson -> person2

# Store creates a lua-like table, along with two functions, one to store things in the table,
# and one to retrieve them from the table. The storePerson function is overloaded: it
# takes either one input or two inputs. When it takes one input and no outputs, the Store will
# internally map the input into the next available integer, giving behaviour of
# an associative array. When it takes two inputs, this will internally map the first input into
# the second input, behaving like a hashMap.
#
# This exposes studets early and naturally to a concept of higher-order functions.
# Nil isn't a null pointer. It simply means "zero parameters"
Nil -> Store -> peopleStore

# peopleStore is a newly defined function, which can store something in an array, in a hashmap
# or retrieve something.
# So, peopleStore has 3 different signatures:
# name, value -> peopleStore -> Nil
# name -> peopleStore -> value
# value -> peopleStore -> Nil
# lets's put both people into our Store, like this:

person1 -> peopleStore -> Nil
"luckyPerson", person2 -> peopleStore -> Nil

# A block can be turned into a function, like this.
# All builtins are capital letters, which is fine,
# because there's no classes, so capital letters don't have
# any other special meaning.
{
  # this matches any input that was passed in, if number of arguments
  # corresponds to the number of outputs (just like haskell!)
  Nil -> Input -> a, b
    # this returns from the function, and stops matching any other inputs.
    # number of values to the right of the second arrow is important, 
    # as it might disambiguate your function if you
    # ever plan to overload it!
  a + b -> Return -> value
  
  # you can overload your function by using multiple Input/Return
  # statements in the same block. Note that you can be ambiguous
  # in number of arguments passed to Input, as long as the corresponding Return
  # non-ambiguous. In arrow you always have to explicitly
  # assign returned value to a variable name (if you don't need it, use something silly like forget or underscore).
  Nil -> Input -> a, b
    # no point to do anything here. We'll return Nil anyway.
  a + b -> Return -> Nil
} -> Function -> addition

# with addition defined, these are now valid statements:
4, 3 -> addition -> sumResult
2, 3 -> addition -> Nil

# you can get something onto your screen by using Write. Block is just a value, like an int or string!
{ "hi", "there" } -> someVar

someVar -> Write -> Nil
# because blocks are values, and will be executed by the interpreter when reached
# the function If will either return unmodified block, or nothing.
# Public is like nonlocal in python3, and can be used for closures or for if statements
# like here.
# block, boolean -> If -> possiblyEmptyBlock
{8 -> Public -> sumResult}, 3 > 2 -> If -> possiblyEmptyBlock

# the for loop will simply repeat a given block however many times is needed to go through entire
# store.
{
  Nil -> Input -> name, value
  {"name:", name} -> Write -> Nil
  {"value:", value} -> Write -> Nil
}, peopleStore -> For -> definedBlock

# or entire block
#blockToExecute, howManyTimes -> For -> anotherBlock

# That's how you can express affection to your partner:
0 -> peopleStorage -> p1
"luckyPerson" -> retrievePerson -> p2
{p1, "loves", p2} -> Print
