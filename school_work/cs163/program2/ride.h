/* Carly Thelander
April 7th 2013
program 2
ride.h file
header for ride class:
*/


#include <cstring>
#include <iostream>
#include <cctype>
#include "line.h"


class ride
{
    public:
        ride(void);                 //constructor sets pointers to null and values to 0
        ~ride(void);                //destructor releses dynamic memory
        int set_name(char *name);   //sets name member to char array passed in
        int close_ride(void);          //closes a ride so that it can't be accessed
        bool is_open(void);            //checks if ride is open
	int add_slow(const new_person & to_add);  //adds a person to the slow line
	int add_fast(const new_person & to_add);  //adds a person to the fast line
	int remove_slow(void);                    //removes a person from the slow line
	int remove_fast(void);                    //removes a person from the fast line
	int display_slow(void);                   //displays all nodes in slow line
	int display_fast(void);                   //displays all nodes in fast line
	int first_slow(new_person & first_in_line);   //returns first person in slow line
	int first_fast(new_person & first_in_line);   //returns first person in fast line
    private:
        char * ride_name;
        bool open;
        line *slow_line;
        line *fast_line;
        int num_fast;
        int num_slow;
};
