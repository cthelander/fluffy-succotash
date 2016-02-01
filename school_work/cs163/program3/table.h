/* Carly Thelander
May 25 2013
cs163
program 4
header file for the table class
node struct for the binary search tree created in the table class
table class creates a binary search tree of node structs
*/


#include <iostream>
#include <cctype>
#include <cstring>
#include "job.h"

//node struct for the hash table
struct node
{
    job * the_job;            //pointer to job class instance
    node * left;              //left pointer
    node * right;             //right pointer
};

//table class creates a binary search tree of nodes with jobs as data member
class table
{
    public:
        table();
        ~table();
        int add_wrap(a_job & to_add);
        int add_job(a_job & to_add, node * & root);      //adds a new node to the tree
        int remove_wrap(char * company_name, char * position);
        int remove(char * company_name, char * position, node * & root);  //removes a node from the tree
                                          //retrieves members from job
        int ret_wrap(char * company_name, a_job * & found);
        int retrieve(char * company_name, node * root, a_job * & found, int & num_found);
                                           //calls the function to display a job
        int dis_wrap(char * company_name, char * position);
        int display(char * company_name, char * position, node * & root);
                                        //displays all nodes in order from losest to highest
        int display_all_wrap(void);
        int display_all(node * & root);
    private:
        node * root;
};
