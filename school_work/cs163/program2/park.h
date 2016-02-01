/* Carly Thelander
April 27th 2013
park.h file 
park class header file
*/

#include <iostream>
#include <cstring>
#include <cctype>
#include "ride.h"

//node_array struct for the flexible array of ride classes
struct node_array
{
    ride *ride_array;      //ride pointer
    node_array *next;      //next pointer
};

class park
{
    public:
        park();           //constructor to set pointers to NULL and values to 0
        ~park();          //destructor releases dynamic memory
        int add_ride(char * name, int position); //adds new ride
        int remove_ride(int position);           //removes a ride
        int display_ride(int position);          //displays lines in a ride
                                            //adds a person to a ride
        int add_to_ride(new_person & to_add, int position, bool fast_line);
                                            //removes a person from a ride
        int remove_from_ride(int position, bool fast_line);
                                            //retrieves embers form first to persons in lines
        int peek_at_first(new_person & first_in_slow, new_person & first_in_fast,
                          int position);
                                           //retreives bool if ride is open    
        bool is_ride_open(int position);
    private:
        node_array *head;    
        int size;

};
