/* Carly Thelander
April 27th 2013
park.cpp file
park class cpp file
contains all the functions for the park class which creates and works with a 
flexible array of ride class instances.
*/

#include "park.h"


using namespace std;


//park constructor sets all dynamic memory to null and all values to 0
park::park(void)
{
    head = NULL;
    size = 5;
}


//park destructor releases all dynamic memory
park::~park(void)
{
    if(head)
        delete []head;
}


//add_ride function, the name and position number of the ride to be added are passed 
//in by value and an int indicating success is returned.
int park::add_ride(char * name, int position)
{
    node_array *current = NULL;      //pointer for traversal
    node_array *previous = NULL;     //pointer for traversal and connecting of new nodes
    int to_traverse = 0;             //represents the number needed to traverse through list
    int index = 0;                   //represent number index in array
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                 	     //empty list case
    {
        head = new node_array;
        head->ride_array = new ride[size];
        head->next = NULL;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        previous = current;
        current = current->next;
        if(!current)
        {
            current = new node_array;
            current->ride_array = new ride[size];
            previous->next = current;
            current->next = NULL;
        }
    }
    current->ride_array[index].set_name(name);
    return 1;
}


//remove_ride function brings in the position of the ride to remove as an argument by 
//value and returns an int indicating success. 
int park::remove_ride(int position)
{
    node_array *current = NULL;        //pointer for traversal       
    int to_traverse = 0;               //represents number of traversals
    int index = 0;                     //represents index of ride to remove
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                          //empty list case
    {
        return 0;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        current = current->next;      
        if(!current)        //no such ride case
        {
            return 0;
        }
    }
    if(current->ride_array[index].is_open());
    {
        if(!current->ride_array[index].close_ride())
            return 0;
    }
    return 1;
}


//display_ride function has an argument for the position number of the wanted ride by value
//and calls display functions of the line class to display lists
//returns an int indicating success
int park::display_ride(int position)
{
    
    node_array *current = NULL;                 //pointer for traversal
    int to_traverse = 0;                        //number to traverse
    int index = 0;                              //index of ride
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                                   //empty list case
    {
        return 0;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        current = current->next;
        if(!current)                     
        {
            return 0;
        }
    }
    if(current->ride_array[index].is_open())
    {
        cout << endl << "      Slow Line:       " << endl;
        current->ride_array[index].display_slow();
        cout << endl << "      Fast Line:       " << endl;
        current->ride_array[index].display_fast();
        return 1;
    }
    return 0;
}


//add_to_ride function has a new_person struct as an argument by reference with members 
//to pass to add to a ride and a position number of the ride and a bool indicating whether 
//the person should be added to fast line by value and returns an int indicating success
int park::add_to_ride(new_person & to_add, int position, bool fast_line)
{ 
    node_array *current = NULL;         //pointer for traversal
    int to_traverse = 0;                //number to traverse
    int index = 0;                      //index of ride
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                          //empty list case
    {
        return 0;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        current = current->next;
        if(!current)
        {
            return 0;
        }
    }
    if(current->ride_array[index].is_open())
    {
        if(!fast_line)
        {
            current->ride_array[index].add_slow(to_add);
        }
        else
        {
            current->ride_array[index].add_fast(to_add);
        }
        return 1;
    }
    return 0;
}


//remove_from_ride function has arguments of the position number of the ride 
//and a bool indicating whether the person should be added to the fast line by value 
//and returns an int indicating success
int park::remove_from_ride(int position, bool fast_line)
{
    node_array *current = NULL;           //pointer for traversal
    int to_traverse = 0;                  //number to traverse
    int index = 0;                        //index of ride
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                             //empty list case
    {
        return 0;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        current = current->next;
        if(!current)
        {
            return 0;
        }
    }
    if(current->ride_array[index].is_open())
    {
        if(fast_line)
        {
            if (!current->ride_array[index].remove_fast())
                return 0;
        }
        else
        {
            if (!current->ride_array[index].remove_slow())
                return 0;
        }
    }
    else
    {
        return 0;
    }

    return 1;
}


//peek_at_first function takes the arguments of two empty new_person structs to be filled
//by functions called by reference, and the position number of the ride by value,
//and returns an int indicating success 
int park::peek_at_first(new_person & first_in_slow, new_person & first_in_fast, int position)
{
    node_array *current = NULL;              //pointer for traversal
    int to_traverse = 0;                     //number to traverse
    int index = 0;                           //index of ride
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                                //empty list case
    {
        return 0;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        current = current->next;
        if(!current)
        {
            return 0;
        }
    }
    if (current->ride_array[index].first_slow(first_in_slow) && current->ride_array[index].first_fast(first_in_fast))
        return 1;
    if (current->ride_array[index].first_slow(first_in_slow))
        return 2;
    if (current->ride_array[index].first_fast(first_in_fast))
        return 3;

    return 0;
}


//is_ride_open function is used to find out if a ride is open. It takes an int 
//for the position number of the ride by value and returns a true bool if the ride is open.
bool park::is_ride_open(int position)
{
    node_array *current = NULL;          //pointer for traversal
    int to_traverse = 0;                 //number to be traversed
    int index = 0;                       //index of ride
    to_traverse = (position - 1) / size;
    index = (position - 1) % size;

    if(!head)                            //empty list case
    {
        return false;
    }
    current = head;
    for (int i = 0; i < to_traverse; ++i)
    {
        current = current->next;
        if(!current)
        {
            return false;
        }
    }
    if(current->ride_array[index].is_open())
        return true;
    else 
        return false;
}
