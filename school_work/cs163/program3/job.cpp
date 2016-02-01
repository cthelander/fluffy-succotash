/* Carly Thelander
May 25 2013
cs163
program 4
job class cpp file
purpose: holds all functions for the job class, for adding, retrieving, displaying.
*/


#include "job.h"


//job class constructor, sets all pointers to null and values to 0
job::job()
{
    company_name = NULL;
    position = NULL;
    skills = NULL;
    description = NULL;
    location = NULL;
    rating = 0;
}


//job class destructor releases all dynamically allocated memory
job::~job()
{  
    delete []company_name;
    delete []position;
    delete []skills;
    delete []description;
    delete []location;
}


//create_job function copies all data members for the data memebers of the struct passed in
// and returns an int indicating success
int job::create_job(a_job & to_add)
{
    int length = 0;            //for array lengths

    if (to_add.company_name)   
    {
        length = (strlen(to_add.company_name) + 1);
        company_name = new char[length];
        strcpy(company_name, to_add.company_name); 
    }
    if (to_add.position)
    {
        length = (strlen(to_add.position) + 1);
        position = new char[length];
        strcpy(position, to_add.position);        
    }
    if (to_add.skills)  
    {
        length = (strlen(to_add.skills) + 1);
        skills = new char[length];
        strcpy(skills, to_add.skills);
    } 
    if (to_add.description)
    {
        length = (strlen(to_add.description) + 1);
        description = new char[length];
        strcpy(description, to_add.description);        
    }
    if (to_add.location)      
    {
        length = (strlen(to_add.location) + 1);
        location = new char[length];
        strcpy(location, to_add.location); 
    }

    rating = to_add.rating;
    return 1;
}


//retrieve function copies all data members to the struct passed in and returns an int
//indicating success
int job::retrieve(a_job & found)
{
    int length = 0;            //for array lengths

    if (company_name)   
    {
        length = (strlen(company_name) + 1);
        found.company_name = new char[length];
        strcpy(found.company_name, company_name); 
    }
    if (position)
    {
        length = (strlen(position) + 1);
        found.position = new char[length];
        strcpy(found.position, position);        
    }
    if (skills)  
    {
        length = (strlen(skills) + 1);
        found.skills = new char[length];
        strcpy(found.skills, skills);
    } 
    if (description)
    {
        length = (strlen(description) + 1);
        found.description = new char[length];
        strcpy(found.description, description);        
    }
    if (location)      
    {
        length = (strlen(location) + 1);
        found.location = new char[length];
        strcpy(found.location, location); 
    }

    found.rating = rating;
    return 1;
}


//display function displays all data members with no arguments and returns an int 
//indicating success
int job::display()
{
    if (company_name)
        cout << endl << "Company name:  " << company_name;
    if (position)
        cout << endl << "Position:  " << position;
    if (skills)
        cout << endl << "Skills required: " << skills;
    if (description)
        cout << endl << "Description of the company:  " << description;
    if (location)
        cout << endl << "Company location:  " << location;
    cout << endl << "Rating of interest in position, 1 to 5 :  " << rating << endl << endl;
    return 1;
}


//get_name function passes in a char pointer and copies the company_name member
//to that pointer and returns an int indicating success.
int job::get_name(char * & name)
{

    int length = 0;              //holds the length of the array

    if (company_name)   
    {
        length = (strlen(company_name) + 1);
        name = new char[length];
        strcpy(name, company_name); 
        return 1;
    }
    return 0;
}

//get_position function passes in a char pointer and copies the position member
//to that pointer and returns an int indicating success.
int job::get_position(char * & temp_position)
{
    int length = 0;              //holds the length of the array

    if (position)   
    {
        length = (strlen(position) + 1);
        temp_position = new char[length];
        strcpy(temp_position, position); 
        return 1;
    }
    return 0;
}
