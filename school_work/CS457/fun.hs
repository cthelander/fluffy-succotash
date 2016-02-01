module Hw4 where

--Carly Thelander
--tcarly@pdx.edu

-- Sierpinski carpet in blue in front of some simple black, red and white stripes. 

import PPM6

--
--draws pictures
--
squares = mapDouble "squares.ppm" (pretty) (-100,-100) (100,100) (500,500)

--calls forground and background functions 
pretty x y = fromJust (over (fill) (back) (newx,newy))
    where newx = floor x
          newy = floor y

fromJust (Just x) = x
fromJust Nothing = black

--Put one functions picture "over" anothers
over funcation1 function2 args = case funcation1 args of
                                Nothing -> function2 args
                                Just a -> Just a
--                 
--forground functions
--
-- finds points to fill or to check
fill :: (Integer, Integer) -> Maybe Colour
fill(x, y) | x > 0 = check(x, y)
           | y > 0 = check(x, y)
           | x <= 0 = test (x, y)
           | y <= 0 = test (x, y)

test(x, y) | x+y > 150 = Just red
           | x+y > 100 = Just cyan
           | x+y > 50 = Just red
           | x+y >= 0 = Just cyan
           | x+y > -50 = Just red
           | x+y > -100 = Just cyan
           | x+y > -150 = Just red
           | x+y <= -150 = Just cyan

--checks to see if a point should be a color for a square or not
check :: (Integer, Integer) -> Maybe Colour
check(x, y) = 
        if mod x 3 == 1
            then if mod y 3 == 1
                    then Nothing
                    else fill (div x 3, div y 3)
            else fill (div x 3, div y 3)

-- 
--background function
--
back (x, y) | x+y > 150 = Just white
            | x+y > 100 = Just black
            | x+y > 50 = Just white
            | x+y >= 0 = Just black
            | x+y > -50 = Just white
            | x+y > -100 = Just black
            | x+y > -150 = Just white
            | x+y <= -150 = Just black

