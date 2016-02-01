/* Carly Thelander
cs163
program 5
6.5.2013
purpose: creates a graph ADT of animal class instances so that the animals
can be linked to their children and the locations where they are moved to.
input: is from the user 
output: is to the screen
*/

#include <iostream>
#include <cctype>
#include <cstring>
#include "graph.h"

using namespace std;

int menu(void);
int readin_new_animal(new_animal & to_add);

int main()
{
    graph * the_graph = NULL;      //the graph instance
    char * name = NULL;            //for the animal name to be passed to functions
    char * location = NULL;        //for the animal location to be passed to functions
    char * end_name = NULL;        //for the animal name at the other end of an edge
    char * end_location = NULL;    //for the animal location at the other end of an edge
    int menu_ret = 0;              //for int returned from menu function
    new_animal to_add;             //to pass to functions
    new_animal * found;            //new_animal pointer to pass to retieve function
    int index = 0;                 //index for array
    edge_node * new_edge = NULL;   //edge node to pass to functions
    char answer = 'N';             //for answer returned by user
    name = new char [100];
    location = new char [100];
    end_name = new char [100];
    end_location = new char [100];
    the_graph = new graph;

    cout << endl << "       Welcome to Animal Organizer  " << endl;
    do 
    {
        menu_ret = menu();            //calls the menu function
        if(1 == menu_ret)             //add an animal
        { 
            if (!readin_new_animal(to_add))
            {
                cout << endl << "Animal failed to be added, please try again! " << endl;
            }
            if (!the_graph->add_animal(to_add))
            {    
                cout << endl << "Animal failed to be added, please try again! " << endl;
            }
        }
        else if(2 == menu_ret)             //add edge
        {   
            if (!the_graph->display_all())
            {
                cout << endl << "No Animals entered. " << endl;
            } 
        }
        else if(3 == menu_ret)             //retrieve all children and the next location
        {
            cout << endl << "What is the animal's name you"
                 << "would like to retrieve the children for?" << endl;
            cin.get(name, 100, '\n');
            cin.ignore(100, '\n');
            cout << endl << "What is the location of the animal you"
                 << " would like to retrieve the children for?" << endl;
            cin.get(location, 100, '\n');
            cin.ignore(100, '\n');
            if (the_graph->retrieve(name, location, found))
            {    
                cout << endl << "Animal(s) has been retrieved. " << endl;
            }
            else
            { 
                cout << endl << "Animal failed to be retrieved, or does not exist. \n"
                     << "Please try again! " << endl;
            }
        }    
        else if(4 == menu_ret)           //add a connection
        {
            new_edge = new edge_node;
            cout << endl << "What is the animal's name"
                 << " where the connection will start at?" << endl;
            cin.get(name, 100, '\n');
            cin.ignore(100, '\n');
            cout << endl << "What is the location of that animal? " << endl;
            cin.get(location, 100, '\n');
            cin.ignore(100, '\n');
            cout << endl << "What is the animal's name"
                 << " where the connection will end at?" << endl;
            cin.get(end_name, 100, '\n');
            cin.ignore(100, '\n');
            cout << endl << "What is the location of that animal? " << endl;
            cin.get(end_location, 100, '\n');
            cin.ignore(100, '\n');
            index = the_graph->find_index(end_name, end_location);

            if (index >= 0)
            {
                new_edge->index = index;

                do
                {
                    cout << endl << "Is this a child? Y or N" << endl;
                    cin >> answer;
                    cin.ignore(100, '\n');
                    answer = toupper(answer);
                    if(answer == 'Y')
                        new_edge->child = true;
                    else if (answer == 'N')
                        new_edge->child = false;
                } while (answer != 'Y' && answer != 'N');
                
                
                if (the_graph->add_edge(name, location, new_edge))
                {    
                    cout << endl << "Connection has been added" << endl;
                }
                else
                { 
                    cout << endl << "Connection failed to be added, "
                         << "or animal does not exist." << endl
                         << "Please try again! " << endl;
                }
            }
            else
            { 
                cout << endl << "Animal does not exist" << endl
                     << "Please try again! " << endl;
            }
        }    
    } while(5 != menu_ret);           //end program
    
    delete the_graph;
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
             << "1. Add a new animal " << endl
             << "2. Display all animals " << endl
             << "3. Retrieve all children at location and where the animal went next " 
             << endl
             << "4. Add connection between two animals " << endl
             << "5. End program " << endl;
        cin >> answer;
        cin.ignore(100, '\n');

        if(0 >= answer || 6 <= answer)
        {
            cout << endl << "Please try again." << endl;
        }
    } while(0 >= answer || 7 <= answer);

    return answer; 

}

//read_in_new_animal function asks the user for the members of a new_animal to pass
//to other functions for the animal to be added to the graph.
int readin_new_animal(new_animal & to_add)
{
    char *temp_name = NULL;                 //for company_name array
    char *temp_location = NULL;             //for location array
    char *temp_breed = NULL;                //for skills array
    char *temp_health = NULL;               //for description array
    int length = 0;                         //for array length
    temp_name = new char[100];  
    temp_location = new char[100];      
    temp_breed = new char[300];               
    temp_health = new char[600];                     
                
                                    //reads in name
    cout << endl << "What is the name of the animal? " << endl;
    cin.get(temp_name, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_name) + 1);
    to_add.name = new char[length];
    strcpy(to_add.name, temp_name);
   
                                    //reads in location
    cout << endl << "What is the animal's location? " << endl;
    cin.get(temp_location, 100, '\n');
    cin.ignore(100, '\n');
    length = (strlen(temp_location) + 1);
    to_add.location = new char[length];
    strcpy(to_add.location, temp_location);
   
                                    //reads in breed
    cout << endl << "What is the animal's breed? " << endl;
    cin.get(temp_breed, 100, '\n');
    cin.ignore(300, '\n');
    length = (strlen(temp_breed) + 1);
    to_add.breed = new char[length];
    strcpy(to_add.breed, temp_breed);
   
                                   //reads in health
    cout << endl << "What is a the animal's health, and any other information"
                 << "that may be nedded?" << endl;
    cin.get(temp_health, 100, '\n');
    cin.ignore(600, '\n');
    length = (strlen(temp_health) + 1);
    to_add.health = new char[length];
    strcpy(to_add.health, temp_health);
   
                                   //delete dynamically allocated memory
    delete temp_name;  
    delete temp_location;      
    delete temp_breed;               
    delete temp_health;          
    return 1;
}

