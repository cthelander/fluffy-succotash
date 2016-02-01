-- | Main entry point to the application.
module Main where

-- | The main entry point.
main :: IO ()
main = do
    print $ append [1,2,3] [6,7,9]
    print $ addup [1,2,3]
    print $ rev [1,2,3]
    print $ insert 1 [1,2,3,4]
    print $ insert 3 [1,2,4]
    print $ sort [5,4,3,2,1]
    print $ sort [1,1,6,6,4,3,2]
    print $ splits [1,2,3,4]

-- Question 1

-- a) [Int] -> [Bool]
-- b) [Int] -> [Int]
-- c) [Char] -> [Char]
-- d) Int -> [Int]
-- e) [String] -> [String]
-- f) [ [], [[]], [[[]]], [[[[]]]], [[[[[True]]]]] ] :: [[[[[[True]]]]]] -- (Polymorphic arrays can still expand)
-- g) Ill typed: The nested polymorphic lists can't possibly be typed to match [Bool]
-- h) [Int -> Char] -> [[Int] -> [Char]] -- (Maps map over a list of functions and returns a list of partial applications)
-- i) [[Int]] -> [[Bool]]
-- j) (a -> b) -> [[a]] -> [[b]] -- (map a function to inner elements of a list of lists)
-- k) ((a -> b) -> [a] -> [b], (a1 -> b1) -> [a1] -> [a2]) -- Just a tuple type, with both elements having the typical type of map

-- Question 2

-- a) Adds 1 to a number and then checks if it is odd
-- b) Multiplies a number by 2, and checks if it is odd. Always is false.
-- c) Takes the nth number in the series 1.., which turns out to be always n+1
-- d) Returns the first element of a list
-- e) Reverses a list and then reverses it again, returning the original list
-- f) Removes the last element of a list
-- g) Takes a list of lists, reversing each inner list, then reversing the outer list, and then returns the inner lists to original form

-- Question 3

append :: [a] -> [a] -> [a]
append [] ys     = ys
append (x:xs) ys = x : (append xs ys)

addup            :: [Int] -> Int
addup []     = 0
addup (x:xs) = x + (addup xs)

rev       :: [Int] -> [Int]
rev []     = []
rev (x:xs) = append (rev xs) [x]

insert         :: Int -> [Int] -> [Int]
insert x [] = [x]
insert x (y:ys)
            | (x <= y) = append (append [x] [y]) ys
            | (x > y) = append [y] (insert x ys)

sort       :: [Int] -> [Int]
sort []     = []
sort (n:ns) = insert n $ sort ns

splits       :: [Int] -> [([Int], Int, [Int])]
splits [x] = [([]::[Int], x, []::[Int])]
splits (x:xs) = ([], x, xs) : [ (x:us, v, ws) | (us, v, ws) <- splits xs ]

-- Question 4
-- The list comprehension will loop over all pairs of x,y up to n and substract them, putting the results into a list, which is then summed.
-- eg. zeroes 3 will first evaluate to [1-1, 1-2, 1-3, 2-1, 2-2, 2-3, 3-1, 3-2, 3-3], and is then summed. The result will always be zero
-- because we are substracting every number up to n with itself, essentially.
zeroes n = sum [ x - y | x <- [1..n], y <- [1..n] ]
