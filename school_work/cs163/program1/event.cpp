/* Carly Thelander
April 16th 2013
cs163 program 1
cpp file for the event class functions.
*/

#include "event.h"

//constructor for event class, sets all dynamic mamory to NULL and variables to zero
event::event()
{
    head = NULL;
    counter = 0;
}

//destructor for event class to release all dynamic memory in the linear linked list.
event::~event()
{
    node *current;    //tempory node for traversal
    current = NULL;

    while(head)       //while there are nodes in the list
    {
        current = head->next;
        delete head;
        head = current;
    }
}


//add_new function for adding new nodes of sections to the LLL. Adds nodes at the 
//beginning of the list and passes a new_section stuct as an argument and returns an
//int indicating success or failure. Increments counter for each added node.
int event::add_new(new_section & to_add)
{
    node *current;       //temp node for traversal
    current = NULL;

    if(!head)           //for empty list
    {
        head = new node;
        head->next = NULL;
        head->a_section.create(to_add);
        ++counter;
        return 1;
    }
                        //adds node to the beginning of the list
    current = new node;
    current->a_section.create(to_add);
    current->next = head;
    head = current;
    ++counter;
    return 1;
}


//display_one function for the event class displays one section class that is found by a 
//section number passed in by value and fills in an empty section class passed in
//by reference. Returns an int indicating success or failure.
int event::display_one(section & found, int section_to_find)
{
    int was_found = 0;     //int for returned value
    node *current;         //temp node pointer for traversal
    current = NULL;

    if(!head)          //empty list case
        return 0;

    current = head;     //finds and displays section
    while (current && was_found == 0)
    {
        was_found = head->a_section.retrieve(found, section_to_find);
        current = current->next;
    }
    if (current)
    {
        found.display();
        return 1;
    }
    return 0;
}

//display_all functions for the event class. Takes no arguments but returns an int for 
//success or failure. Displays all nodes in reverse order from how they were entered. 
int event::display_all()
{
    node *current;             //node pointer for traversal
    current = NULL;

    if(!head)                  //empty list case
        return 0;

    current = head;            //displays entire list
    while(current)
    {
        current->a_section.display();
        current = current->next;
    }
    return 1;
}



//print_by_cost function for the event class. takes no arguments and returns an int
//indicating success or failure. Displays sections from least expensive to most expensive.
int event::print_by_cost()
{
    section *ordered_sections;           //array of sections ordered by cost.
    ordered_sections = NULL;
    ordered_sections = new section[counter];
    node *current;                        //node pointer for traversal
    current = NULL;
    int num_sections = 1;                 // number of sections in ordered_sections

    if(!head)                             //empty list case
        return 0;

    current = head;
    current->a_section.copy_section(ordered_sections[0]);
    current = current->next;

    while (current)
    {
	bool found = false;
        for (int i = 0; i < num_sections && !found; ++i)
        {
            // if ordered_section[i] less than current
	    //    shift all remaining elements from i to counter to the right by one
            //    copy current to ordered_section[i] 
            //    end loop
            if (ordered_sections[i].retrieve_cost() >=
                current->a_section.retrieve_cost())
            {
                shift_elements_to_right(ordered_sections, num_sections, i);
                current->a_section.copy_section(ordered_sections[i]);
                ++num_sections;
                found = true;
            }
        }

        // if we get here and haven't found a spot then we just add it to the end
        if (!found)
        {
            current->a_section.copy_section(ordered_sections[num_sections]);
            ++num_sections;
        }

        current = current->next;

    }

    // print everything in ordered_sections
    for(int i = 0; i < counter; ++i)
    {
        (ordered_sections[i]).display();
    }
    delete ordered_sections;
    return 1;
}

//print_by_section function for the event class. Takes no argumants and returns an int
//indicating success or failure. Displays sections from lowest numeric section to highest.
int event::print_by_section()
{
    section *ordered_sections;            //array of sections ordered by section_num.
    ordered_sections = NULL;
    ordered_sections = new section[counter];
    node *current;                        //node pointer for traversal
    current = NULL;
    int num_sections = 1;                 //number of sections in ordered_sections

    if(!head)                             //empty list case
        return 0;

    current = head;
    current->a_section.copy_section(ordered_sections[0]);
    current = current->next;

    while (current)
    {
	bool found = false;
        for (int i = 0; i < num_sections && !found; ++i)
        {
            // if ordered_section[i] less than current
	    //    shift all remaining elements from i to counter to the right by one
            //    copy current to ordered_section[i] 
            //    end loop
            if (ordered_sections[i].retrieve_section() >=
                current->a_section.retrieve_section())
            {
                shift_elements_to_right(ordered_sections, num_sections, i);
                current->a_section.copy_section(ordered_sections[i]);
                ++num_sections;
                found = true;
            }
        }

	// if we get here and haven't found a spot then we just add it to the end
        if (!found)
        {
            current->a_section.copy_section(ordered_sections[num_sections]);
            ++num_sections;
        }

        current = current->next;

    }

    // print everything in ordered_sections
    for(int i = 0; i < counter; ++i)
    {
        (ordered_sections[i]).display();
    }
    delete ordered_sections;
    return 1;
}

//print_by_view function for the event class. Takes no argumants and returns an int
//indicating success or failure. Displays sections from best to worst view.
int event::print_by_view()
{
    section *ordered_sections;            //array of sections ordered by section_num.
    ordered_sections = NULL;
    ordered_sections = new section[counter];;
    node *current;                        //node pointer for traversal
    current = NULL;
    int num_sections = 1;                 //number of sections in ordered_sections

    if(!head)                             //empty list case
        return 0;

    current = head;
    current->a_section.copy_section(ordered_sections[0]);
    current = current->next;

    while (current)
    {
	bool found = false;
        for (int i = 0; i < num_sections && !found; ++i)
        {
            // if ordered_section[i] less than current
	    //    shift all remaining elements from i to counter to the right by one
            //    copy current to ordered_section[i] 
            //    end loop
            if (ordered_sections[i].retrieve_section() <=
                current->a_section.retrieve_section())
            {
                shift_elements_to_right(ordered_sections, num_sections, i);
                current->a_section.copy_section(ordered_sections[i]);
                ++num_sections;
                found = true;
            }
        }

        // if we get here and haven't found a spot then we just add it to the end
        if (!found)
        {
            current->a_section.copy_section(ordered_sections[num_sections]);
            ++num_sections;
        }

        current = current->next;

    }

    // print everything in ordered_sections
    for(int i = 0; i < counter; ++i)
    {
        (ordered_sections[i]).display();
    }
    delete ordered_sections;
    return 1;
}


//shift_elements_to_right in the event class moves all the sections in the array sent in from 
//the starting point also passed in and returns an int indicating success or failure.
int event::shift_elements_to_right(section array[], int num_sections, int start)
{
    for (int i = num_sections; i > start; --i)
    {
        array[i - 1].copy_section(array[i]);
    }
    return 1;
}

//reserve_section function in the event class finds a section in the LLL and
//reserves a number of seats in that section that is passed in. It returns an
//int indicating success or failure.
int event::reserve_section(int section_to_reserve, int to_reserve)
{
    node *current;         //node pointer for trversal
    current = NULL;

    if(!head)              //empty list case
        return 0;
    
    current = head;        //finds section and calls function to reserve seats
    while(current)
    {
        if(section_to_reserve = current->a_section.retrieve_section())
        {
            current->a_section.reserve(to_reserve);
            return 1;
        }
    }
    return 0;
}
