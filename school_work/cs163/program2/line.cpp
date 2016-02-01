/* Carly Thelander
April 27th 2013
Program 2
line.cpp file
line class cpp file
The line class creates a circular linked list queue of nodes that have person class 
instances and next pointers.
*/

#include "line.h"

//line class constructor sets pointers to NULL and counter to 0
line::line(void)
{
    qu_ptr = NULL;
    num_in_line = 0;
}


//line class destructor traverses through list, releaseing all dynamic memory
line::~line(void)
{
    node *temp;

    if (qu_ptr)
    {
        temp = qu_ptr->next;
        qu_ptr->next = NULL;
        while (temp)
        {
            qu_ptr = temp;
            temp = qu_ptr->next;
            delete qu_ptr;
        }
    }
}


//enqueue function adds a node to the list. It takes in a struct as an argument by
//referance that is to be passed to the create function in the person class
//and returns an int indicating success
int line::enqueue(const new_person & to_add)
{
    node *temp;                 //temp node pointer for traversal

    if (!qu_ptr)                //empty list case
    {
        qu_ptr = new node;
        qu_ptr->a_person.create(to_add);
        qu_ptr->next = qu_ptr;
        ++num_in_line;
        return 1;
    }
    temp = new node;             //all other cases
    temp->a_person.create(to_add);
    temp->next = qu_ptr->next;
    qu_ptr->next = temp;
    qu_ptr = temp;
    ++num_in_line;
    return 1;
}


//dequeue function removes a node from the list and deletes the dynamic memory,
//it takes no arguments and returns an int indicating success.
int line::dequeue(void)
{
    node *temp;               //temporary node for traversal of list

    if(!qu_ptr)                //empty list case
        return 0;
    if(qu_ptr == qu_ptr->next) //only one node case
    { 
        delete qu_ptr;
        qu_ptr = NULL;
        --num_in_line;
        return 1;
    }
    temp = qu_ptr->next;       //all other cases
    qu_ptr->next = qu_ptr->next->next;
    delete temp;
    --num_in_line;
    return 1;
}


//display_all function displays all nodes in the list by calling the display person function
//it takes no arguments and returns an int indicating success.
int line::display_all(void)
{
   node *temp = qu_ptr->next;            //temporary node for traversal

    if (!qu_ptr)                         //empty list case
        return 0;
    for (int i = 0; i != num_in_line; ++i)
    {
        temp->a_person.display();
        temp = temp->next;
    }
    return 1;   
}


//peek function takes in an empty struct by referance and copies in the members
//from the first person in the list and returns an int indicating success.
int line::peek(new_person & first_in_line)
{
    if(!qu_ptr)
        return 0;
    qu_ptr->next->a_person.retrieve(first_in_line);
    return 1;
}

