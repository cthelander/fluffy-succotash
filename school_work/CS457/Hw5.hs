module Hw5 where

-- Carly Thelander
-- tcarly@pdx.edu

import Test.HUnit
import Test.QuickCheck
import Test.QuickCheck.Test(isSuccess)

{-

-- Definitions and Equations --

1   map f [] = []
2   map f (x:xs) = (f x):(map f xs)
3   id xs = xs
4   (x:xs++ys) = x:(xs++ys)
5   length [] = 0
6   length (x:xs) = 1 + length (xs)
7   map f bottom = bottom
8   bottom ++ xs = bottom
 
-- Question 1 --

map f x ++ map f y = map f (x ++ y)
 
1) Show equation holds for the empty list 

  map f [] ++ map f [] 
  [] ++ []                                    -> (by 1)
  []                                          -> (by 3)
  map f [] ++ map f [] = [] 
QED

2) Assume: map f x ++ map f y = map f (x ++ y)
   Prove: map f (x:xs) ++ map f (y) = map f ((x:xs) ++ y) 

  map f (x:xs) ++ map f (y)
  (f x):(map f xs) ++ (map f y)              -> (by 2)
  (f x): map f (x ++ y)                      -> (by IH)
  map f ((x:xs) ++ y)                        -> (by 2 backwards)
    QED

3) Show map f bottom ++ map f ys = map f (bottom ++ ys)

  map f bottom ++ map f ys 
  bottom ++ map f ys                         -> (by 7)
  map f (bottom ++ ys)                       -> (by 4)
    QED

-- Question 2 --

length (xs ++ ys) = length xs + length ys

1) Show equation holds for the empty list 

  length ([] ++ [])
  length []                                     -> (by 3)
  0                                             -> (by 5)

  length [] + length []
  0 + 0                                         -> (by 5)
  0                                             -> (trivial)
  
  0 = 0
    QED

2) Assume: length (xs ++ ys) = length xs + length ys
   Prove: length ((x:xs) ++ ys) = length (x:xs) + length (ys)
  
  length ((x:xs) ++ ys)
  1 + length (xs ++ ys)                          -> (by 6)
  1 + length xs + length ys                      -> (by IH)
  length (x:xs) + length (ys)                    -> (by 6 backwards) 
    QED

3) Show: length (bottom ++ ys) = length bottom + length ys

  length (bottom ++ ys) 
  length bottom                                  -> (by 8)
  length bottom + length ys                      -> (by definition of bottom) 
    QED
-}


-- Question 3 --

conLen:: [Int] -> [Int] -> Bool
conLen xs ys = length (xs ++ ys) == length  xs + length ys 


checkconLen = quickCheck conLen  

-- Question 4 --
data Bit = O | I deriving (Show, Eq)
type BinNum = [Bit]


{- Original add
add []     ds     = ds
add ds     []     = ds
add (O:ds) (e:es) = e:add ds es
add (I:ds) (O:es) = I:add ds es
add (I:ds) (I:es) = O:(carry(add ds es))
        where carry [] = I:[]
              carry xs = add [I] xs
-}



-- New add
add []     ds     = ds
add ds     []     = ds
add (d:ds) (e:es) | d == O = e:add ds es
                  | d == I && e == O = I:add ds es
                  | d == I && e == I = O:add [I] (add ds es)



-- hUnit tests for add functions
--
-- empty list tests
test1 = TestCase (assertEqual "add [] [I,O,O,I] " (add [] [I,O,O,I]) [I,O,O,I])
test2 = TestCase (assertEqual "add [I,O,O,I] [] " (add [I,O,O,I] []) [I,O,O,I])
test6 = TestCase (assertEqual "add [] [] " (add [] []) [])
--
-- basic add tests
test3 = TestCase (assertEqual "add [I,O] [O,I] " (add [I,O] [O,I]) [I,I])
test8 = TestCase (assertEqual "add [I,I,I] [O,O,O] " (add [I,I,I] [O,O,O]) [I,I,I])
test9 = TestCase (assertEqual "add [O,O] [I,I] " (add [O,O] [I,I]) [I,I])
--
-- carry tests
test4 = TestCase (assertEqual "add [I,I] [I,I] " (add [I,I] [I,I]) [O,I,I])
test7 = TestCase (assertEqual "add [I,O,I] [I] " (add [I,O,I] [I]) [O,I,I]) 
test10 = TestCase (assertEqual "add [O,O,O,I] [O,O,O,I] " (add [O,O,O,I] [O,O,O,I]) [O,O,O,O,I])
--
-- all O test
test5 = TestCase (assertEqual "add [O,O] [O,O] " (add [O,O] [O,O]) [O,O])
--
-- run test function 
tests = runTestTT $ TestList[test1, test2, test3, test4, test5, test6, test7, test8, test9, test10]




