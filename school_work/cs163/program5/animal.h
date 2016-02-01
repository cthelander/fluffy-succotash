/*Carly Thelander
cs 163
program 5
6.5.2013
header file for the animal class and the new_animal struct
input: input is passed in to the class from a struct which is read in from the user
output: the class will only output to the screen through the display function or
return information to the calling routine
*/

struct new_animal
{
    char * name;                                //pointer for name array
    char * location;                            //pointer for location array
    char * breed;                               //pointer for breed array
    char * health;                              //pointer for health array
};


class animal
{
    public:
        animal(void);                            //constructor
        ~animal(void);                           //destructor
        int create_animal(new_animal & to_add);  //fills members from passed in struct
        int display(void);                       //displays all members
        int retrieve(new_animal & found);        //fills passed in struct with members
        bool visited(void);                      //checks if animal is visited and sets flag
        int unvisit(void);                       //unsets visit flag
                                                 //checks if name and location are the same
        bool equals(char * name, char * location);

    private: 
        char * name;                             //pointer for name array
        char * location;                         //pointer for location array
        char * breed;                            //pointer for breed array
        char * health;                           //pointer for health array
        bool visit;                              //for display_all
};
