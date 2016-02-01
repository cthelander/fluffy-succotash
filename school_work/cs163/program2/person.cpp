/* Carly Thelander
April 27th 2013
program 2
person.cpp file
header file for the person class
*/


#include "person.h"

using namespace std;

//person class constructor. Sets all values to zero or null, no arguments or return value.
person::person(void)
{
    name = NULL;                 //holds person's name
    phone_num = NULL;            //holds person's phone number
    age = 0;                     //holds person's age
    fast_line = false;           //holds a bool for whether the person is in a fast line
}


//destructor for the person class releases all dynamic memory
person::~person(void)
{    
    if (name)            
        delete []name;            //releases memory
    if (phone_num)
        delete []phone_num;       //releases memory
}



//create function, a struct is sent in through an argument by referance and the
//members are copied into the class and an int is returned indicating success or failure.
int person::create(const new_person & to_add)
{
    int length = 0;            //for array lengths

    if (to_add.name)           //in case struct sent in is empty
    {
        length = (strlen(to_add.name) + 1);
        name = new char[length];
        strcpy(name, to_add.name); 

        length = (strlen(to_add.phone_num) + 1);
        phone_num = new char[length];
        strcpy(phone_num, to_add.phone_num);        

        age = to_add.age;
        fast_line = to_add.fast_line;
        return 1;
    }
    return 0;
}

//display function for the person class, takes no arguments, reads out all members of
//the struct and returns an int depending on success or failure.
int person::display(void)
{
    cout << endl << "Name:  " << name << endl;
    cout << "Phone Number:  " << phone_num << endl;
    cout << "Age:   " << age << endl;
    if(fast_line)
    {
        cout << "Fast line" << endl;
    }
    else
    {
        cout << "Slow line" << endl;
    }
    return 1;  
}

//retrieve function of the person class, takes in an empty struct as an argument by 
//refereance and returns an int indictating success or failure. The class
//members are copied over to the struct members.
int person::retrieve(new_person & found)
{
    int length = 0;            //for array lengths

    length = (strlen(name) + 1);
    found.name = new char[length];
    strcpy(found.name, name);
    
    length = (strlen(phone_num) + 1);
    found.phone_num = new char[length];
    strcpy(found.phone_num, phone_num);
    found.age = age;
    found.fast_line = fast_line;

    return 1;
}

