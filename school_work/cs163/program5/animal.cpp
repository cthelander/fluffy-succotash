/* Carly Thelander
cs163
program 5
6.5.2013
animal class cpp file
purpose: holds all functions for the animal class, for creating, retrieving, displaying.
input: input is all done through the arguments being passed in
output: output is through arguments and return values and the display function 
prints to the screen
*/

#include "animal.h"
#include <iostream>
#include <cctype>
#include <cstring>

using namespace std;

//animal class constructor, sets all pointers to null and bools to false
animal::animal()
{
    name = NULL;
    location = NULL;
    breed  = NULL;
    health = NULL;
    visit = false;
}


//animal class destructor releases all dynamically allocated memory
animal::~animal()
{  
    delete []name;
    delete []location;
    delete []breed;
    delete []health;
}


//create_animal function copies all data members for the data memebers 
//of the struct passed in and returns an int indicating success
int animal::create_animal(new_animal & to_add)
{
    int length = 0;            //for array lengths

    if (to_add.name)   
    {
        length = (strlen(to_add.name) + 1);
        name = new char[length];
        strcpy(name, to_add.name); 
    }
    if (to_add.location)
    {
        length = (strlen(to_add.location) + 1);
        location = new char[length];
        strcpy(location, to_add.location);        
    }
    if (to_add.breed)  
    {
        length = (strlen(to_add.breed) + 1);
        breed = new char[length];
        strcpy(breed, to_add.breed);
    } 
    if (to_add.health)
    {
        length = (strlen(to_add.health) + 1);
        health = new char[length];
        strcpy(health, to_add.health);        
    }

    return 1;
}


//retrieve function copies all data members to the struct passed in and returns an int
//indicating success
int animal::retrieve(new_animal & found)
{
    int length = 0;            //for array lengths

    if (name)   
    {
        length = (strlen(name) + 1);
        found.name = new char[length];
        strcpy(found.name, name); 
    }
    if (location)
    {
        length = (strlen(location) + 1);
        found.location = new char[length];
        strcpy(found.location, location);        
    }
    if (breed)  
    {
        length = (strlen(breed) + 1);
        found.breed = new char[length];
        strcpy(found.breed, breed);
    } 
    if (health)
    {
        length = (strlen(health) + 1);
        found.health = new char[length];
        strcpy(found.health, health);        
    }

    return 1;
}


//display function displays all data members with no arguments and returns an int 
//indicating success
int animal::display()
{
    if (name)
        cout << endl << "Name:  " << name;
    if (location)
        cout << endl << "Position:  " << location;
    if (breed)
        cout << endl << "Breed: " << breed;
    if (health)
        cout << endl << "Health information:  " << health << endl << endl;

    return 1;
}

//visited function takes in no arguments and returns true if the animal has been visited
bool animal::visited(void)
{
    if (visit)
        return true;

    visit = true;

    return false;
}

//unvisit function sets visit to false, it takes no arguments and returns an int
int animal::unvisit(void)
{
    visit = false;
    return 1;
}

//equals returns a boolean that indicates whether the passed in name and location
//match the animal's name and location
bool animal::equals(char * other_name, char * other_location)
{
    return ((strcmp(other_name, name) == 0) && (strcmp(other_location, location) == 0));
}
