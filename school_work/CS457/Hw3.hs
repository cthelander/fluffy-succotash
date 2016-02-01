module Hw3 where

--Carly Thelander
--tcarly@pdx.edu

--Consider the following definition of a datatype of bits:

data Bit = O | I    deriving Show

{-
This datatype has two different values, written O and I, which we
will use to represent the bits 0 and 1.  We'll talk more about the
"deriving Show" part of this declaration in class soon, but for
now you can just treat it as an indication that we want to be able
to print out values of the Bit type, as in the following example:
  Main> [I, O, I, O, I, I]
  [I,O,I,O,I,I]
  Main>

-}

type BinNum = [Bit]

{-
We'll assume that the least significant bit is stored
at the head of the list so that, for example, [O, O, I] represents the
number 4 and [O, I, I, O, I, O] represents 22.
-}

--a) Define functions:

toBinNum   :: Integer -> BinNum
fromBinNum :: BinNum -> Integer

{-
   that convert backwards and forwards between Integers and their
   corresponding BitNum representations.

-}

toBinNum n | n==0   = []
           | even n = O: (toBinNum(halfOfN))
           | odd n  = I: (toBinNum(halfOfNOdd))
             where halfOfN = n `div` 2  
                   halfOfNOdd = (n-1) `div` 2 


fromBinNum []     = 0
fromBinNum (O:ds) = 2 * (fromBinNum ds)
fromBinNum (I:ds) = 2 * (fromBinNum ds) + 1


--b) Define a BinNum increment function

inc :: BinNum -> BinNum
{-
   inc . toBinNum = toBinNum . (1+)

   For example, inc [I,I,O,I,O,I] should yield [O,O,I,I,O,I]
-}

inc [] = []
inc (O:ds) = I: ds
inc (I:ds) = O: inc ds

--c) Define a function

add :: BinNum -> BinNum -> BinNum

{-
   that computes the sum of its arguments. More formally, your add
   function should satisfy the following law (but your implementation
   should not make any use of Integer values):

   add x y = toBinNum (fromBinNum x + fromBinNum y)
-}


add []     ds     = ds
add ds     []     = ds
add (O:ds) (e:es) = e:add ds es
add (I:ds) (O:es) = I:add ds es
add (I:ds) (I:es) = O:(carry(add ds es))
        where carry [] = I:[]
              carry xs = add [I] xs


--d) Define a function:

mul :: BinNum -> BinNum -> BinNum

{-
    computes the multiplication of its arguments.
   
    mul x y = toBinNum (fromBinNum x * fromBinNum y)
-}

mul []     ds     = []
mul ds     []     = []
mul (O:ds) (es)   = mul ds (O:es)
mul (I:ds) (es)   = add (es) (mul ds (O:es))
              



