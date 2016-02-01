/* Carly Thelander
May 25 2013
cs163
program 4
purpose: creates a binary search tree of job opportunities for easy access.
There are 2 classes; the job class which holds all the information 
about the job, and the table class which creates the binary search tree of 
the job class.
input:is from the user 
output:is to the screen
*/

#include <iostream>
#include <cctype>
#include <cstring>
#include "table.h"

using namespace std;

int menu(void);
int readin_new_job(a_job & to_add);

int main()
{
    char *name = NULL;             //for the company name to passed to functions
    char *position = NULL;         //for the position passed to function
    int menu_ret = 0;              //for int returned from menu function
    a_job to_add;                  //to pass to function
    a_job * found;                 //for arrya of retrieved structs
    table *a_table = NULL;         //pointer for creating a table
    a_table = new table;
    found = NULL;
    name = new char[100];
    position = new char[100];

    cout << endl << "       Welcome to Job Opportunities Note Keeper  " << endl;
    do 
    {
        menu_ret = menu();            //calls the menu function
        if(1 == menu_ret)             //add a job
        { 
            if (!readin_new_job(to_add))
            {
                cout << endl << "Job failed to be added, please try again! " << endl;
            }
            if (!a_table->add_wrap(to_add))
            {    
                cout << endl << "Job failed to be added, please try again! " << endl;
            }
        }
        else if(2 == menu_ret)             //remove a job
        {  
            cout << endl << "What is the company's name of the job you"
                 << " would like to remove?" << endl;
            cin.get(name, 100, '\n');
            cin.ignore(100, '\n');
            cout << endl << "What is the position of the job you"
                 << " would like to remove?" << endl;
            cin.get(position, 100, '\n');
            cin.ignore(100, '\n');
            if (a_table->remove_wrap(name, position))
            {    
                cout << endl << "Job has been removed. " << endl;
            }
            else
            { 
                cout << endl << "Job failed to be removed, or does not exist. \n"
                     << "Please try again! " << endl;
            }
        } 
        else if(3 == menu_ret)             //display a job
        { 
            cout << endl << "What is the company's name of the job you"
                 << "would like to display?" << endl;
            cin.get(name, 100, '\n');
            cin.ignore(100, '\n');
            cout << endl << "What is the position of the job you"
                 << "would like to display?" << endl;
            cin.get(position, 100, '\n');
            cin.ignore(100, '\n');
            if (!a_table->dis_wrap(name, position))
            { 
                cout << endl << "Job failed to be displayed, or does not exist. \n"
                     << "Please try again! " << endl;
            }
        }
        else if(4 == menu_ret)             //retrieve a job
        {
            cout << endl << "What is the company's name of the job you"
                 << "would like to retrieve?" << endl;
            cin.get(name, 100, '\n');
            cin.ignore(100, '\n');
            //cout << endl << "What is the position of the job you"
            //     << "would like to retrieve?" << endl;
            //cin.get(position, 100, '\n');
            //cin.ignore(100, '\n');
            if (a_table->ret_wrap(name, found))
            {    
                cout << endl << "Job has been retrieved. " << endl;
            }
            else
            { 
                cout << endl << "Job fail to be retrieved, or does not exist. \n"
                     << "Please try again! " << endl;
            }
        }    
        else if(5 == menu_ret)           //displays all jobs
        {
            if (!a_table->display_all_wrap())
            {
                cout << endl << "No jobs entered. " << endl;
            } 
        }    
    } while(6 != menu_ret);           //end program
    
    delete a_table;
    return 0;
}



//Menu function asks the user what they would like to do. Returns an int with their choice.
//Continues to ask if the answer input does not fit an option.
int menu(void)
{
    int answer = 0;        //for user input
    
    do
    {
        cout << endl << "What would you like to do? " << endl
             << "Please enter the number next to your selection: " << endl
             << "1. Add a new job " << endl
             << "2. Remove a job " << endl
             << "3. Display the information for a job " << endl
             << "4. Retrieve a job " << endl
             << "5. Display all jobs entered " << endl
             << "6. End program " << endl;
        cin >> answer;
        cin.ignore(100, '\n');

        if(0 >= answer || 7 <= answer)
        {
            cout << endl << "Please try again." << endl;
        }
    } while(0 >= answer || 7 <= answer);

    return answer; 

}

//read_in_new_job function asks the user for the members of a a_job to pass
//to other functions for the job to be added to the table and stored.
int readin_new_job(a_job & to_add)
{
    char *temp_company_name = NULL;         //for company_name array
    char *temp_position = NULL;             //for position array
    char *temp_skills = NULL;               //for skills array
    char *temp_description = NULL;          //for description array
    char *temp_location = NULL;             //for location array
    int temp_rating = 0;                    //for rating
    int length = 0;                         //for the array lengths
    temp_company_name = new char[100];  
    temp_position = new char[100];      
    temp_skills = new char[300];               
    temp_description = new char[600];          
    temp_location = new char[100];             
                
                                    //reads in company name
    cout << endl << "What is the comany's name? " << endl;
    cin.get(temp_company_name, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_company_name) + 1);
    to_add.company_name = new char[length];
    strcpy(to_add.company_name, temp_company_name);
   
                                    //reads in position
    cout << endl << "What is the position? " << endl;
    cin.get(temp_position, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_position) + 1);
    to_add.position = new char[length];
    strcpy(to_add.position, temp_position);
   
                                    //reads in skills
    cout << endl << "What are the skills required? " << endl;
    cin.get(temp_skills, 100, '\n');
    cin.ignore(300, '\n');
    length = (strlen(temp_skills) + 1);
    to_add.skills = new char[length];
    strcpy(to_add.skills, temp_skills);
   
                                   //reads in description
    cout << endl << "What is a description of the job and company? " << endl;
    cin.get(temp_description, 100, '\n');
    cin.ignore(600, '\n');
    length = (strlen(temp_description) + 1);
    to_add.description = new char[length];
    strcpy(to_add.description, temp_description);
   
                                   //reads in location
    cout << endl << "What is the comany's location? " << endl;
    cin.get(temp_location, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_location) + 1);
    to_add.location = new char[length];
    strcpy(to_add.location, temp_location);
   
                                   //reads in the rating and checks for 1 - 5
    cout << endl << "What is the rating of your interest in this job? 1 to 5 " << endl;
    cin >> temp_rating;
    cin.ignore(100, '\n');
    if (0 >= temp_rating)
    {
        cout << endl << "This will be a 1 on this scale" << endl;
        to_add.rating = 1;
    }
    if (5 < temp_rating)
    {
        cout << endl << "You must be really excited about the job,\n"
             << " but on this scale that is a 5." << endl;
        to_add.rating = 5;
    }
    else
        to_add.rating = temp_rating;
                                            //delete dynamically allocated memory
    delete temp_company_name;  
    delete temp_position;      
    delete temp_skills;               
    delete temp_description;          
    delete temp_location;             
    return 1;
}

