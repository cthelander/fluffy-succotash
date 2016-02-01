/* Carly Thelander
April 16th 2013
cs163 program 1
purpose: allow user to add an event and section in the event,
and then reserve tickets for an event in a section. The user
will be able to display section by 3 different criteria.
*/

#include "event.h"

using namespace std;

//event_info struct to hold info entered by user about the event they are entering.
struct event_info
{
    char *title;
    char *date;
    char *details;
    char *facility;
    //struct constructor setting pointers to NULL
    event_info()
    {
        title = NULL;
        date = NULL;
        details = NULL;
        facility = NULL;
    } 
    //struct destructor releasing dynamic memory
    ~event_info()
    {
        if(title)
            delete title;
        if(details)
            delete details;
        if(date)
            delete date;
        if(facility)
            delete facility;

    }
};

void welcome(event_info an_event);
int menu(void);
void fill_section(new_section & section_to_add);
int display_how(void);


int main(void)
{
    event_info new_event;        //creates new event_info struct instance
    int menu_num = 0;            //for number returned by menu
    event *all_events;           //event class pointer
    all_events = new event;
    new_section section_to_add;  //struct to be filled and passed to class functions
    int display_num = 0;         //for number returned by display_how
    int section_to_reserve = 0;  //for section to reserve
    int to_reserve = 0;          //for the number of tickets to reserve


    welcome(new_event);
    
    while(menu_num != 5)
    {
        menu_num = menu(); 
        if(menu_num == 1)
        {
            fill_section(section_to_add);
            all_events->add_new(section_to_add);
        }
        else if(menu_num == 2)
        {
            display_num = display_how();
            if (display_num == 1)
            {
                if (!all_events->display_all())
                    cout << endl << "No sections entered!" << endl;
            }
            else if(display_num == 2)
            {
                if (!all_events->print_by_cost())
                    cout << endl << "No sections entered!" << endl;
            }
            else if(display_num == 3)
            {
                if (!all_events->print_by_section())
                    cout << endl << "No sections entered!" << endl;
            }
            else if(display_num == 4)
            {
                if (!all_events->print_by_view())
                    cout << endl << "No sections entered!" << endl;
            }
        }
        else if(menu_num == 3)
        {
            cout << endl << "What section would you like to reserve tickets in? " << endl;
            cin >> section_to_reserve;
            cin.ignore(100, '\n');
            cout << endl << "How many seats would you like to reserve?  " << endl;
            cin >> to_reserve;
            cin.ignore(100, '\n');
            if (!all_events->reserve_section(section_to_reserve, to_reserve))
                cout << endl << "No sections entered!" << endl;
        }
        else if(menu_num == 4)
        {
            delete all_events;
        }
    }

    return 0;
}


//welcome function for welcoming user and reading in information and returning nothing.

void welcome(event_info an_event)
{
    char temp_title[100];              //tempory static arrays
    char temp_date[40];
    char temp_details[1000];
    char temp_facility[150];
    int length = 0;                    //to hold the strlens
                                       //read in fields and store them in temp arrays
    cout << endl << "         Welcome to the ticket ordering program" << endl
         << endl << "Please enter the name of the event you would like to enter:  ";
    cin.get(temp_title, 100, '\n');
    cin.ignore(100, '\n');
    cout << endl << "Please enter the event's date:    ";
    cin.get(temp_date, 40, '\n');
    cin.ignore(100, '\n');
    cout << endl << "Please enter details about the event:" << endl;
    cin.get(temp_details, 1000, '\n');
    cin.ignore(100, '\n');
    cout << endl << "Please enter the name of the facility holding the event:  ";
    cin.get(temp_facility, 150, '\n');
    cin.ignore(100, '\n');

    //transfer temp arrays to dynamic arrays
    length = (strlen(temp_title) + 1);
    an_event.title = new char[length];
    strcpy(an_event.title, temp_title);

    length = (strlen(temp_date) + 1);
    an_event.date = new char[length];
    strcpy(an_event.date, temp_date);

    length = (strlen(temp_details) + 1);
    an_event.details = new char[length];
    strcpy(an_event.details, temp_details);

    length = (strlen(temp_facility) + 1);
    an_event.facility = new char[length];
    strcpy(an_event.facility, temp_facility);
}


//menu function to direct the user to the activity they would like to preform by
//returning an int with their answer.
int menu(void)
{
    int num_return = 0;       //for user's input

    do
    {
        cout << endl << "What would you like to do?" << endl
             << "Please enter the number next to your choice: " << endl
             << "1  Add a new section" << endl
             << "2  Display sections" << endl
             << "3  Reserve a ticket" << endl
             << "4  Remove all sections that have been added" << endl
             << "5  End program" << endl;
        cin >> num_return;
        cin.ignore(100, '\n');

        if(num_return < 1 || num_return > 5)
        {
            cout << endl << "Please try again!" << endl;
        }
    } while(num_return < 1 || num_return > 5);

    return num_return;
}


//fill_section function reads in and fills new_section struct members from users. 
//returns nothing and takes an empty new_section struct to fill.
void fill_section(new_section & section_to_add)
{
    cout << endl << "Please enter the section number (such as 300 or 101:  "; 
    cin >> section_to_add.section_num;
    cin.ignore(100, '\n');
    cout << endl << "Please enter the number of seats in the section:  ";
    cin >> section_to_add.seat_counter;
    cin.ignore(100, '\n');
    cout << endl << "Please enter the cost of each seat in the section:  $";
    cin >> section_to_add.cost;
    cin.ignore(100, '\n');
    section_to_add.seats_reserved = 0;

    return;
}

//display_how function asks the user how they would like to display the sections and returns
//an int indicating their choice.
int display_how(void)
{
    int num_return = 0;             //for number entered by user.

    do                              //do while loop for error checking
    {
        cout << endl << "How would you like to display the sections?" << endl
             << "Please enter the number next to the option you would like." 
             << endl << "1  Rendom"
             << endl << "2  Least to most expensive"
             << endl << "3  Ascending row numbers"
             << endl << "4  Best to worst view" << endl;
        cin >> num_return;
        cin.ignore(100, '\n');
        if(num_return < 1 || num_return > 4)
        {
            cout << endl << "Please try again!";
        }
    } while(num_return < 1 || num_return > 4);
    return num_return;
}
