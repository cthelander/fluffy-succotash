/* Carly Thelander
April 16th 2013
cs163 program 1
section header file for the section class.
*/

#include <iostream>
#include <cstring>
#include <cctype>

using namespace std;

struct new_section
{
    int section_num;
    int seats_reserved;
    int seat_counter;
    float cost;
};

class section
{
    public:
        section();
        ~section();
        int create(new_section & to_add);     //fills new section with info passed in from struct
                                              //if section_num matches one passed in it fills
                                              //section passed in
        int retrieve(section & found, int section_to_find);
        int display(void);                    //displays all section members
        int reserve(int to_reserve);          //adds seats to seats_reserved member
        float retrieve_cost(void);            //returns cost
        int retrieve_section(void);           //returns section number
        int copy_section(section & copied);   //copies section members

    private:
        int section_num;                      
        int seats_reserved;
        int seat_counter;
        float cost;
};
