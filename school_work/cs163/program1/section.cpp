/* Carly Thelander
April 16th 2013
cs163 program 1
cpp file for the function in the section class.
*/

#include "section.h"

//default constructor sets all members to 0
section::section()
{
    section_num = 0;                
    seats_reserved = 0;             
    seat_counter = 0;               
    cost = 0.0;
}

//default destructor, no dynamic memory to release
section::~section()
{
}

//create function passes in a new_section struct and copies its members into this section's
//members and returns an int indicating success or failure.
int section::create(new_section & to_add)
{
    section_num = to_add.section_num;
    seats_reserved = to_add.seats_reserved;
    seat_counter = to_add.seat_counter;
    cost = to_add.cost;

    return 1;
}

//retrieve_section function checks passed in int section_to_find to section_num, if they match
//it fills section passed in with all members and passes it back by reference. Returns an int 
//indicating whether section was filled or not.
int section::retrieve(section & found, int section_to_find)
{
    if(section_num == section_to_find)   //if section numbers match then it fills section
    {
        found.section_num = section_num;
        found.seats_reserved = seats_reserved;
        found.seat_counter = seat_counter;
        found.cost = cost;
        return 1;
    }
    return 0;
}

//copy_section copies all members over to passed in section and returns an int indicating
//success or failure.
int section::copy_section(section & copied)
{
    copied.section_num = section_num;
    copied.seats_reserved = seats_reserved;
    copied.seat_counter = seat_counter;
    copied.cost = cost;
    return 1;
}

//display function displays all members and returns an int indicating success or failure 
int section::display(void)
{
    cout << "Section number: " << section_num << endl
         << "Total number of seats in section: " << seat_counter << endl
         << "Number of seats available: " << (seat_counter - seats_reserved) << endl
         << "Price per seat : $" << cost << endl; 
    return 1;
}


//reserve function adds int passed in to the member seats_reserved and returns an 
//int indicating sucsess or failure.
int section::reserve(int to_reserve)
{
    seats_reserved = (seats_reserved + to_reserve);
    return 1;
}

//retrieve_cost function returns a float equal to the cost member.
float section::retrieve_cost(void)
{
    return cost;
}

//retrieve_section function returns an int equal to the section_num member.
int section::retrieve_section(void)
{
    return section_num;
}
