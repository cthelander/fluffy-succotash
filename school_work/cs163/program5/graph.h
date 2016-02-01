/*Carly Thelander
cs 163
program 5
6.5.2013
header file for the graph class, vertex struct and edge_node struct
input: is done through argments passed in to functions
output: is done through arguments and return values only
*/

#include "animal.h"

struct edge_node
{
    bool child;                                  //is this a child edge or location edge?
    int index;                                   //index of animal being pointed at
    edge_node * next;                            //pointer to next edges
};


struct vertex
{
    animal * an_animal;                          //pointer to animal class instance
    edge_node * head;                            //pointer to LLL of edges
};


class graph
{
    public:
        graph(void);                             //constructor
        ~graph(void);                            //destructor
        int add_animal(new_animal & to_add);     //adds new animal to array
                                                 //adds new edge to a LLL
        int add_edge(char * name, char * location, edge_node * & new_edge); 
                                                 //retrieves all children of an animal at
                                                 //a specific location and where the animal
                                                 //went next
        int retrieve(char * name, char * location, new_animal * found);                    
           
        int display_all(void);                   //display all animals depth first
                                                 //returns the index of a given animal
        int find_index(char * name, char * location);

    private:
        int display_all(vertex & the_animal);    //displays all animals depth first
        vertex * all_animals;                    //pointer to array of animal
        int counter;                             //keeps track of the number of aminals
};
