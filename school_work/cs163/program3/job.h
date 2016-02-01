/* Carly Thelander
May 25 2013
cs163
program 4
header file of the job class and the a_job struct
purpose: includes all the data members needed for a job and the functions that deal with them
*/

#include <iostream>
#include <cctype>
#include <cstring>

using namespace std;

//a_job struct for passing data members to and from functions
struct a_job
{
    char *company_name;                
    char *position;
    char *skills;
    char *description;
    char *location;
    int rating;
};


//holds data members and functions of the job class
class job
{
    public:
        job();                            //constructor
        ~job();                           //destructor
        int create_job(a_job & to_add);   //fills members from struct passed in
        int retrieve(a_job & found);      //fills passed in struct
        int display();                    //displays all members
        int get_name(char * & name);      //passes the company_name array
        int get_position(char * & temp_position);      //passes the position array
    private:
        char *company_name;
        char *position;
        char *skills;
        char *description;
        char *location;
        int rating;
};
