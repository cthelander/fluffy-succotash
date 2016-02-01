/* Carly Thelander
April 7th 2013
Program 2
Purpose:
Is to create a program that sets up rides for an amusment park, and creates a fast line and a
slow line for each ride and allows users to add people to wait in line and saves their 
information. The ADT's should be completely abstracted from the client program in main, 
allowing information to be passed by argument but no access to data members from outside of
the classes themselves. 
*/

#include <cctype>
#include <cstring>
#include "park.h"
#include <iostream>

using namespace std;

const int NAME = 100;
int menu(void);
int readin_new_person(new_person & to_add);

int main()
{
    int menu_ret = 0;            //for int returned from menu function
    int position_from_user = 0;  //for the position to pass to functions
    char *temp_name = NULL;      //for the ride name passed to function
    new_person to_add;           //to pass to function 
    bool slow_line = false;      //to ask user if person is slow line
    char is_slow_line = 'N';     //for user input
    park *a_park = NULL;         //pointer for creating a park
    a_park = new park;
    new_person first_in_slow;    //for peeking at first in slow line
    new_person first_in_fast;    //for peeking at first in fast line
    int return_value = 0;	 //for storing the return value
    

    cout << endl << "          Welcome to Oaks Park!!   " << endl;
    do 
    {
        menu_ret = menu();
        if(1 == menu_ret)             //add a new ride
        { 
            cout << endl << "What number is the ride? " << endl;
            cin >> position_from_user;
            cin.ignore(100, '\n');
            cout << endl << "What is the name of the ride? " <<endl;
            temp_name = new char [NAME];
            cin.get(temp_name, NAME, '\n');
            cin.ignore(100, '\n');
            if(!a_park->add_ride(temp_name, position_from_user))
            {
                cout << endl << "Ride failed to be open " << endl;
            }
            delete temp_name;
        }
        if(2 == menu_ret)             //close a ride
        { 
            cout << endl << "What number ride would you like to close? " <<endl;
            cin >> position_from_user;
            cin.ignore(100, '\n');
            if(!a_park->remove_ride(position_from_user))
            {
                cout << endl << "That ride does not exist." << endl;
            }
            else
            {
                cout << endl << "Ride is now closed. " << endl;
            }
        } 
        if(3 == menu_ret)                     //check to see if a ride is open
        {
            cout << endl << "What number ride would you like to check? " << endl;
            cin >> position_from_user;
            cin.ignore(100, '\n');
            if(a_park->is_ride_open(position_from_user))
            {
                cout << endl << "This ride is open. " << endl;
            }
            else
            {
                cout << endl << "Ths ride is closed. " << endl;
            }
        }
        if(4 == menu_ret)                       //display lines for a ride
        {
            cout << endl << "What number ride would you like to see? " << endl;
            cin >> position_from_user;
            cin.ignore(100, '\n');
            if(!a_park->display_ride(position_from_user))
            {
                cout << endl << "This ride is closed. " << endl;
            }
        }
        if(5 == menu_ret)          //add a perosn to a line
        {
            cout << endl << "What ride would you like to wait in line for? " << endl;
            cin >> position_from_user;
            cin.ignore(100, '\n'); 
            readin_new_person(to_add);
            if(!a_park->add_to_ride(to_add, position_from_user, to_add.fast_line))
            {
                cout << endl << "This ride is closed. " << endl;
            }
        }
        if(6 == menu_ret)          //display name of first person in line
        {
            cout << endl << "What ride would you like to see the first in line for? " 
                 << endl;
            cin >> position_from_user;
            cin.ignore(100, '\n');
            return_value = a_park->peek_at_first(first_in_slow, first_in_fast, position_from_user);
            if(!return_value)
            {
                cout << endl << "This ride is closed, or the line is empty. " << endl;
            }
            else if (1 == return_value)
            {
                cout << endl << first_in_slow.name << "  is first in the slow line." ;
                cout << endl << first_in_fast.name << "  is first in the fast line. ";
            }
            else if (2 == return_value)
            {
                cout << endl << first_in_slow.name << "  is first in the slow line." ;
            }
            else if (3 == return_value)
            {
                cout << endl << first_in_fast.name << "  is first in the fast line. ";
            }
        }
        if(7 == menu_ret)            //ermove person from ride queue
        {
            cout << endl << "What ride would you like for the person to ride? " << endl;
            cin >> position_from_user;
            cin.ignore(100, '\n');
            do
            {
                cout << endl << "From the slow line? Y or N" << endl;
                cin >> is_slow_line;
                cin.ignore(100, '\n');
                is_slow_line = toupper(is_slow_line);
            } while(is_slow_line != 'N' && is_slow_line != 'Y');

            if('Y' == is_slow_line)
            {
                 slow_line = true;
            } 
            else
            {
                 slow_line = false;
            }
            if(!a_park->remove_from_ride(position_from_user, slow_line))
            {
                cout << endl << "This ride is closed. " << endl;
            }
            else
            {
                cout << endl << "         WHEEEEEEEEEEEE!!!!      " << endl;        
            }
        }
    } while(8 != menu_ret);           //end program
    
    delete a_park;
    return 0;
}



//Menu function ask the user what they would like to do. Returns an int with their choice.
//Continues to ask if the answer input does not fit an option.
int menu(void)
{
    int answer = 0;        //for user input
    
    do
    {
        cout << endl << "What would you like to do? " << endl
             << "Please enter the number next to your selection: " << endl
             << "1. Open a new ride " << endl
             << "2. Close a ride " << endl
             << "3. See if a ride is open " << endl
             << "4. Display the lines for a ride " << endl
             << "5. Wait in line for a ride " << endl
             << "6. See who is first in line for a ride " << endl
             << "7. Send first in line to the ride " << endl
             << "8. End park trip " << endl;
        cin >> answer;
        cin.ignore(100, '\n');

        if(0 >= answer || 9 <= answer)
        {
            cout << endl << "Please try again." << endl;
        }
    } while(0 >= answer || 9 <= answer);

    return answer; 

}


//read_in_new_person function asks the user for the members of a new_person to pass
//to other functions for the person to be added to the line for a ride.
int readin_new_person(new_person & to_add)
{
    char *temp_name = NULL;         //for name array
    char *temp_phone_num = NULL;    //for phone_num array
    int temp_age = 0;               //for age
    int length = 0;                 //for the array lengths
    char is_fast_line = 'N';        //for user input on fast line or not
    temp_name = new char [100];
    temp_phone_num = new char [20];

    cout << endl << "What is the person's name? " << endl;
    cin.get(temp_name, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_name) + 1);
    to_add.name = new char[length];
    strcpy(to_add.name, temp_name);
   
    cout << endl << "What is the person's phone number? " << endl;
    cin.get(temp_phone_num, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_phone_num) + 1);
    to_add.phone_num = new char[length];
    strcpy(to_add.phone_num, temp_phone_num);
   
    cout << endl << "What is the person's age? " << endl;
    cin >> temp_age;
    cin.ignore(100, '\n');
    to_add.age = temp_age; 
    
    do
    {
        cout << endl << "Does this person belong in the fast line? Y or N" << endl;
        cin >> is_fast_line;
        cin.ignore(100, '\n');
        is_fast_line = toupper(is_fast_line);
    }
    while(is_fast_line != 'N' && is_fast_line != 'Y');
    if('Y' == is_fast_line)
    {
        to_add.fast_line = true;
    }
    else
    {
        to_add.fast_line = false;
    }
    delete temp_name;
    delete temp_phone_num;
    return 1;
}
