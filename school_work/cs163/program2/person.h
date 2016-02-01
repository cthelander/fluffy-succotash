/* Carly Thelander
April 27th 2013
program 2
person.h file
header file for the person class
*/

#include <iostream>
#include <cctype>
#include <cstring>

//new_person struct for easier passing of members to and from client program.

struct new_person
{
    char *name;            //char pointer to hold name
    char *phone_num;       //char pointer to hold phone number
    int age;               //int to hold age
    bool fast_line;        //bool whether person is in fast line or not
};


//person class for the data in the nodes in the queues for each ride.

class person
{
    public:
        person(void);     //construtor for person class sets values and pointers to NULL or 0
        ~person(void);    //destructor for person class releases dynamic memory
        int create(const new_person & to_add); //copies members from struct 
        int display(void);                         //displays all members of class
        int retrieve(new_person & found);      //copies members for use outside of class
    private:
        char *name;
        char *phone_num;
        int age;
        bool fast_line;
};
