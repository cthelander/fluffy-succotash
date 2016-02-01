module Hw6 where

--Carly Thelander
--tcarly@pdx.edu
--
--import Test.HUnit
import Test.QuickCheck
import Test.QuickCheck.Test(isSuccess)

-- I made an effort to do this assignment but came up short on 
-- answering all of the questions.

{-
1) Define instances of Finite for the Int type (whose minimum and
maximum values can be obtained as (minBound::Int) and (maxBound::Int),
respectively), the product type (a, b) (assuming, of course that both
a and b are finite), and the sum type Either a b, which is defined in
the prelude as:

   data Either a b = Left a | Right b

Explain how your definitions work and use QuickCheck to verify that
your definitions satisfy the proposed law, at least on the basis of
some random tests.  [Note that a finite type can still have many
elements; you might want to think carefully about how you write your
instance definitions, especially the one for Int, to ensure that
testing does not take too long!]
-}

class Finite a where
   all_elements :: [a]

-- This instance of Finite for the Int type includes the elements in 
-- the list from the minumum bond of the int type to the maximum bound

instance Finite Int where 
    all_elements = [minBound..maxBound]

prop_AllElementsAppear n  =  n `elem` all_elements

-- This instance of Finite for the product type (a, b) includes the 
-- elements in the list where the first element in each tuple is of 
-- type a and the second is from type b.

instance (Finite a, Finite b) => Finite (a, b) where
    all_elements = [(x , y) | x <- all_elements, y <- all_elements] 

-- Ths instance of Finite for the sum Type Either has the elements in
-- the list where each element is either left and an element of type a 
-- or right and an element of type b.
   
instance (Finite a, Finite b) => Finite (Either a b) where
    all_elements = ([Left x | x <- all_elements]) ++ ([Right x | x <- all_elements])

{-
2) If a is a Finite type, then we can use elements :: [a] to obtain
the list of all values in the domain of a function of type a -> b.
Use this observation to define the following instances for displaying
functions (you may use whatever notation you prefer) and for testing
functions for equality:
-}



instance (Finite a, Show a, Show b) => Show (a -> b) where
    show f =  "[(x, y) | x <- all_elements, let y = f x]"



instance (Finite a, Eq b) => Eq (a -> b) where
    f == g  = if  [f x | x <- all_elements] == [g y | y <- all_elements]
                then  True
                else False

{-
You may, of course, define any auxiliary functions that you need to
make these definitions work as you would expect.

3) Devise an algorithm for calculating a list of all functions of type
a -> b for any finite types a and b.  Show that this can be wrapped
up as an instance of the Finite type class:
-}


--instance (Eq a, Finite a, Finite b) => Finite (a -> b) where
  --  all_elements = [(x -> y) | x <- all_elements, y <- all_elements] 


{-
Again, use QuickCheck to verify that your definition satisfies the law
specified in the introduction.

4) Suppose that we want to be able to calculate the number of elements
in any given finite type.  This can be accomplished by adding the
following lines to the end of the definition of the Finite class:

   size  :: a -> Integer
   size x = length (x:all_elements) - 1

Explain why the definition was written in this (rather odd) manner
instead of just writing:

   size  :: Integer
   size   = length all_elements

(If you're not sure why this wouldn't work, maybe you should enter it
into your code and see what happens ...)

Show that you can obtain considerably more efficient definitions for
size by overriding the implementation of size in specific instances of
the Finite class.

-- Types susch as maybe and either woudl be much easier to calculate 
-- the size of in a different way becasue they are easy to calculate
-- because maybe just adds one to the list and either just adds the 
-- size of the 2 types together.


5) Use QuickCheck to formulate and test some properties about size for
Maybe types, product types (pairs), and sum types (Either).  For
example, if the finite type t has n elements, then how many elements
would you expect to find in the type Maybe t?  How useful is QuickCheck
in cases like this?

-- The maybe time of t would add only the nothing element to the list of
--  elements of maybe t. 

-}

