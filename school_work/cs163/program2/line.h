/* Carly Thelander
April 27th 2013
Program 2
line.h file
line class header file
*/

#include <cstring>
#include <iostream>
#include <cctype>
#include "person.h"


//node struct for the circular linked list of person classes
struct node
{
    person a_person;
    node * next;
};

class line
{
    public:
        line(void);                    //constructor for the line class sets pointers to NULL
        ~line(void);                   //destruction releases all dynamic memory in the list
        int enqueue(const new_person & to_add); //adds node to list
        int dequeue(void);                          //removes node from list
        int display_all(void);                      //displays all nodes in list
        int peek(new_person & first_in_line);   //peeks the first node in list
    private:
        node *qu_ptr;
        int num_in_line;
};
