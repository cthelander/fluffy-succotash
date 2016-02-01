{-
-----------------------------------------------------------------------
CS457/557 Functional Languages                Type Classes (Homework 6)
-----------------------------------------------------------------------
Name of programmer: Robert Shannon
Email to send comments to: rms5@pdx.edu


This program I got lost on. Simple as that. Coudln't get the Finite int class
to work at all, tried with renaming int, with list, etc, but in the end couldn't
get the basic part down. Turning in the discussion part for a hope of some
credit. Sorry.
-}

module Homework6 where

import Test.HUnit(Test(TestCase, TestList), assertEqual, runTestTT)
import Test.QuickCheck

class Finite a where
	elements :: [a]
    
size :: a -> Integer
size x = length (x:elements) - 1


data Day     = Sun | Mon | Tue | Wed | Thu | Fri | Sat
data Month   = Jan | Feb | Mar | Apr | May | Jun
             | Jul | Aug | Sep | Oct | Nov | Dec
data Rainbow = Red | Orange | Yellow | Green | Blue | Indigo | Violet


instance Finite Bool where
	elements = [False, True]

instance Finite Day where
   elements = [Sun, Mon, Tue, Wed, Thu, Fri, Sat]


instance Finite Month where
   elements = [ Jan, Feb, Mar, Apr, May, Jun,
                Jul, Aug, Sep, Oct, Nov, Dec]

instance Finite Rainbow where
   elements = [Red, Orange, Yellow, Green, Blue, Indigo, Violet]


{-
let t = minBound::Int
let z = maxBound::Int
-}

instance Finite Int where 
	elements = [minBound .. maxBound]
{-
data MyInt = Int

instance Bounded MyInt where
	minBound = minBound::Int
	maxBound = maxBound::Int

instance Finite MyInt where
	elements = [minBound::Int .. maxBound::Int]
-}
data Either a b = Left a | Right b


{-
3: Devise an algorithm for calcualting a list of all functions of type a -> b
for any finite types a and b. Show that this can be wrapped up as an instance
of the Finte type class: instance (Eq a, Finte a, Finte b) => Finite (a -> b)

Again, use quick check to verify that your definition satisfies the law specified 
in the introduction.

This I was confused about. Functions are an uncountable list (from 311). So 
are we talking about the functions defined by us, or a list of all functions 
available? If it is a list of all functions available, we shouldn't be able
to figure out the functions. But if it is the ones that we defined, then
we can set up a test to determine the outcome of all the finite sets that
takes two items from each set. This will make a cross product of the set items,
making the size fo the function a X b. so: the test of the function exaustively would 
be very large for Int's.

-}
{-
4: Suppose that we want to be able to calculate the number of elements
in any given finite type. This can be accomplished by adding the folowing
lines to the end of hte definition of the Finite class:

size :: a -> Integer
size x = length (x:elements) - 1

explain why the definition was writting in this manner instead of just writing

size :: Integer
size =  length elements

(if you're not sure why this wouldn't work, maybe you should enter it into your
code and see what happens) Show that you can obtain considerably more efficient 
definitions for size by overriding the implementation of size in specific instances
of the Finite class.

Why it might not work: If the elements was empty, it would return a failure on the legnth.

Also, it doesn't know what the type of items in the list is. It could be a list of lists, so
adding the type out front helps because it will have an assigned type with it.
-}	

{-
Use quickcheck to formulate and test some properties about size for Myabe types,
product types (pairs), and sum types (Either). For example, if the finite type t has
n elements, then how many elements would you expect to find in the type Maybe t? How
useful is quickcheck in cases like this?

Quick check may not be the best check for this because you can't define what you want 
for the sizes of numbers to use. So if you were using a defined finite like
rainbow colors, you might get quick check items too large. Also, checking the entire list
of int's is going to be cost prohibitive for time and system power. 
-}
	