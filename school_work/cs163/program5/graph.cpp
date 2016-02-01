/* Carly Thelander
cs 163
program 5
6.5.2013
cpp file for the graph class
functions for creating a graph data structure
input: input is done through argments
output: output is done through arguments and return types
*/

#include "graph.h"
#include <iostream>
#include <cctype>
#include <cstring>

using namespace std;

const int SIZE = 50;

//graph class constructor sets all dynamic memory to NULL and creates an array
graph::graph()
{
    counter = 0;
    all_animals = new vertex[SIZE];      //creating the array
    for (int i = 0; i < SIZE; ++i)       //set all pointers to null
    {
        all_animals[i].an_animal = NULL;
        all_animals[i].head = NULL;
    }
}


//destructor deletes all dynamic memory
graph::~graph()
{
    edge_node * temp = NULL;                      //node pointer for traversal

    for (int i = 0; i < SIZE; i++)
    {
        while (all_animals[i].head)
        {
            temp = all_animals[i].head->next;
            delete all_animals[i].head;
            all_animals[i].head = temp;
        }
        all_animals[i].head = NULL;
    }
    delete [] all_animals;
}

//add_animal adds a new animal to the array of the graph and sets head pointer to NULL.
//takes in a new_animal struct and passes it to the create animal function and returns 
//an int 1 if successful
int graph::add_animal(new_animal & to_add)
{
    if (!all_animals[counter].an_animal)
    {
        all_animals[counter].an_animal = new animal;
        all_animals[counter].an_animal->create_animal(to_add);
        counter++;
    }
    else
        return 0;

    return 1;
}

//edge_node function for connecting a node to the linear linked list of an animal.
//returns an int indicating success. It takes a name and location of the animal
//to connect to, and the node to connect.
int graph::add_edge(char * name, char * location, edge_node * & new_edge)
{
    for (int i = 0; i < counter; ++i)
    {
        if (all_animals[i].an_animal)
        { 
            if (all_animals[i].an_animal->equals(name, location))
            {
                new_edge->next = all_animals[i].head;
                all_animals[i].head = new_edge;

                return 1;
            }
        }
    }

    return 0;
}


//retrieve function takes the name and location of the animal to retreive adjacent
//vertices to and a pointer to hold the array of structs adjacent to the vertex.
//returns an int indicating success or failure. 
int graph::retrieve(char * name, char * location, new_animal * found)
{
    new_animal * temp = NULL;                  //temp array for holding structs
    temp = new new_animal[100];                
    edge_node * current = NULL;                //node pointer for traversal
    int num = 0;                               //int to indicate if any adjecent vertices

    for (int i = 0; i < counter; ++i)
    {
        if (all_animals[i].an_animal->equals(name, location))
        {
            current = all_animals[i].head;

            while (current)
            {
                all_animals[current->index].an_animal->retrieve(temp[num++]);
                current = current->next;
            }

            found = new new_animal[num];
            for (int j = 0; j < num; j++)
                found[j] = temp[j];
        }
    }

    delete temp;                           //delete dynamic memory

    if (num)
        return 1;

    return 0;

}

//find_index finds the index of the animal with the passed in name and location
//returns the index of the animal, or a -1 if the animal doesn't exist.
int graph::find_index(char * name, char * location)
{
    for (int i = 0; i < counter; ++i)
    {
        if (all_animals[i].an_animal)
        {
            if (all_animals[i].an_animal->equals(name, location))
                return i;
        }
    }
    return -1;
}

//display_all wrapper function that takes no arguments and returns an
//int indicating success or failure.
int graph::display_all(void)
{
    for (int i = 0; i < counter; ++i)
    {
        if (!all_animals[i].an_animal->visited())
            display_all(all_animals[i]);
    }
    for (int i = 0; i < counter; ++i)
    {
        all_animals[i].an_animal->unvisit();
    }
}

//display_all function that takes a vertex as an argument and returns
//an int indicating success or failure and displays all vertices in the array.
int graph::display_all(vertex & the_animal)
{
    edge_node * current = NULL;                    //node pointer for traversal
    current = the_animal.head;

    the_animal.an_animal->display();

    while (current)
    {
        if (!all_animals[current->index].an_animal->visited())
            display_all(all_animals[current->index]);
    
        current = current->next;
    }

    return 0;
}

