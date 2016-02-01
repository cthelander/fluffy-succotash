/* Carly Thelander
April 16th 2013
cs163 program 1
header file for the event class and the section struct.
create a linear linked list of sections
*/

#include <iostream>
#include <cstring>
#include <cctype>
#include "section.h"

//struct node for the event LLL
struct node
{
    section a_section;
    node *next;
};

class event
{
    public:
        event();
        ~event();
        int add_new(new_section & to_add);       //adds a new node to the list
        int display_one(section & found, int section_to_find); //finds 1 node to display
        int display_all(void);                   //displays the whole list of sections
        int print_by_cost(void);                 //displays list by cost from least to most
        int print_by_section(void);              //displays list by section from least to most
        int print_by_view(void);                 //displays list by section from highest to most
                                                 //shifts elements to the right to make room for
                                                 //new items in the array to be printed
        int shift_elements_to_right(section array[], int array_count, int start); 
                                                 //reserves the number of  seats in the 
                                                 //section sent in 
        int reserve_section(int section_to_reserve, int to_reserve);

    private:
        node *head;
        int counter;

};
