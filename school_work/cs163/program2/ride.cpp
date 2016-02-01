/* Carly Thelander
April 7th 2013
program 2
ride.cpp file
cpp file for ride class:
ride class has two lines; one fast and one slow, and seperates the persons in together
and keeps track of the number in each, and a name for the ride, and whether it is open
or not.
*/

#include "ride.h"

//constructor for ride class sets values to 0 and pointers to null
ride::ride(void)
{
    ride_name = NULL;
    open = false;
    slow_line = NULL;
    fast_line = NULL;
    num_fast = 0;
    num_slow = 0;
}


//ride class destructor releases all dynamic memory
ride::~ride(void)
{
    if (ride_name)
        delete ride_name;
    if (slow_line)
        delete slow_line;
    if (fast_line)
        delete fast_line;
}


//set_name function has an argument containing the name to be added passed by value
//and returns an int indicating success
int ride::set_name(char *new_name)
{
    int length = 0;                     //holds the length of the array passed in
    length = (strlen(new_name) + 1);
    ride_name = new char[length];
    for (int i = 0; i < length; ++i)
    {
        ride_name[i] = new_name[i];
    }
    open = true;
    return 1;
}


//close_ride function sets open bool to false. It takes no arguments and returns an
//int indicating success.
int ride::close_ride(void)
{
    open = false;
    return 1;
}


//is_open returns a bool indicating whether the ride is open and takes no arguments.
bool ride::is_open(void)
{
    return open;
}


//add_slow function takes a new_person by references an argument to pass to the
//enqueue function of a line and returns an int indicating success
int ride::add_slow(const new_person & to_add)
{
    if(!slow_line)
    {
        slow_line = new line;
    }
    slow_line->enqueue(to_add);
    ++num_slow;
    return 1;
}


//add_fast function takes a new_person by references an argument to pass to the
//enqueue function of a line and returns an int indicating success
int ride::add_fast(const new_person & to_add)
{
    if(!fast_line)
    {
        fast_line = new line;
    }
    fast_line->enqueue(to_add);
    ++num_fast;
    return 1;
}


//remove_slow function takes no arguments, calls the dequeue function on a line
//and returns an int indicating success
int ride::remove_slow(void)
{
    if(!slow_line)
        return 0;
    if(!slow_line->dequeue())
        return 0;
    --num_slow;
    return 1;
}


//remove_fast function takes no arguments, calls the dequeue function on a line
//and returns an int indicating success
int ride::remove_fast(void)
{
    if(!fast_line)
        return 0;
    if(fast_line->dequeue())
        return 0;
    --num_fast;
    return 1;
}


//display_slow function calls the display all function on the slow line, takes
//no arguments and returns an int indicating success
int ride::display_slow(void)
{
    if (!slow_line)
         return 0;
    slow_line->display_all();
    return 1;
}


//display_slow function calls the display all function on the slow line, takes
//no arguments and returns an int indicating success
int ride::display_fast(void)
{
    if (!fast_line)
         return 0;
    fast_line->display_all();
    return 1;
}


//first_slow function sends the new_person struct passed in as an argument by reference
//to the peek function in the line class and returns an int indicating success
int ride::first_slow(new_person & first_in_line)
{
    if (!slow_line)
         return 0;
    slow_line->peek(first_in_line);
    return 1;
}


//first_fast function sends the new_person struct passed in as an argument by reference
//to the peek function in the line class and returns an int indicating success
int ride::first_fast(new_person & first_in_line)
{
    if (!fast_line)
         return 0;
    fast_line->peek(first_in_line);
    return 1;
}

