module Ex01Calendar where

import Excell

-- Carly Thelander
-- tcarly@pdx.edu

-- Each row of the table corresponds to a list.
month:: [ Char]
days:: [String]
week1,week2,week3,week4,week5:: [Integer]

--April table

month =  "APRIL  "
days  = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"]
week1 = [1,2,3,4::Integer]
week2 = [5,6,7,8,9,10,11::Integer]
week3 = [12,13,14,15,16,17,18::Integer]
week4 = [19,20,21,22,23,24,25::Integer]
week5 = [26,27,28,29,30::Integer]


calendar = stack[row month, row days, (blankRow 3`beside`row week1), row week2, row week3, row week4, row week5]

--May table

month_may =  "MAY    "
days_may  = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"]
week1_may = [1,2::Integer]
week2_may = [3,4,5,6,7,8,9::Integer]
week3_may = [10,11,12,13,14,15,16::Integer]
week4_may = [17,18,19,20,21,22,23::Integer]
week5_may = [24,25,26,27,28,29,30::Integer]
week6_may = [31::Integer]


may = stack[row month_may, row days_may, (blankRow 5`beside`row week1_may), row week2_may, row week3_may, row week4_may, row week5_may, row week6_may]

--June table

month_june =  "JUNE   "
days_june  = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"]
week1_june = [1,2,3,4,5,6::Integer]
week2_june = [7,8,9,10,11,12,13::Integer]
week3_june = [14,15,16,17,18,19,20::Integer]
week4_june = [21,22,23,24,25,26,27::Integer]
week5_june = [28,29,30::Integer]


june = stack[row month_june, row days_june, (blankRow 1`beside`row week1_june), row week2_june, row week3_june, row week4_june, row week5_june]

--Calendar of April, May and June

year = stack[calendar,blankRow 7, may,blankRow 7, june]
