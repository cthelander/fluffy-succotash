/* Carly Thelander
May 25 2013
cs163
program 4
table class cpp file
purpose: conatins all functions for the table class
adds a node node to a binary search tree, removes a node retrieves the embers of a node, 
diplays a single nodes members or all the nodes. 
inputs: takes inputs as arguments to the functions 
outputs: outputs are to and from frunction calls and arguments
*/


#include "table.h"



//table class constructor sets pointer to null
table::table()
{
    root = NULL;             //sets root pointer to null
}


//destuctor for the table class releases all dynamic memory
table::~table()
{
    if (root)
    {
        delete root->the_job;
        delete root->left;
        delete root->right;
        delete root;
        root = NULL;
    }
}


//add wrapper function, add_wrap, sends the root to the add_job function and returns and int
//indicating success or failure.
int table::add_wrap(a_job & to_add)
{
    return add_job(to_add, root);
}

//add_job function takes in a_job struct as an argument and passes it to the job
//class's add function and returns an int indicating success
int table::add_job(a_job & to_add, node * & root)
{
    char * temp_name = NULL; // for holding the company name
    char * temp_position = NULL; // for holding the company position
    if (!root)                   //adding at the root, or a leave recurssivly
    {
        root = new node;
        root->the_job = new job;
        root->the_job->create_job(to_add);
        root->left = NULL;
        root->right = NULL;
        return 1;
    }
    root->the_job->get_name(temp_name); 
    if (strcmp(temp_name, to_add.company_name) > 0)   //new nade is less
    {
        return add_job(to_add, root->left);
    }
    else if (strcmp(temp_name, to_add.company_name) < 0)  //new node is more
    {
        return add_job(to_add, root->right);
    }
    else                                                  //nodes are equal
    {
        root->the_job->get_position(temp_position); 
        if(strcmp(temp_position, to_add.position) > 0)    //new position is less
        {
            return add_job(to_add, root->left);
        }
        else                                              //new position is more
        {
            return add_job(to_add, root->right);
        }
    }
}

//remove wrapper function, remove_wrap, calls remove function and takse in the 
//company name and position of the job to remove and returns an int indicating success.
int table::remove_wrap(char * company_name, char * position)
{
    return remove(company_name, position, root);
}


//remove function takes in the company name and position to be removed as an argument
//and passes it the the hash function. removes the node that has the same name if any 
//and returns an int indicating success.
int table::remove(char * company_name, char * position, node * & root)
{
    node * temp = NULL;            //node pointer for traversal
    node * previous = NULL;        //node pointer for traversal
    char * temp_name = NULL;       //for holding the company name
    char * temp_position = NULL;   //for holding the company position

    if(!root)                      //empty tree of end of tree has been found
        return 0;
    root->the_job->get_name(temp_name); 
    if (strcmp(temp_name, company_name) > 0)         //if the node to be found is less them
    {
        return remove(company_name, position, root->left);
    }
    else if (strcmp(temp_name, company_name) < 0)    //if the node is greater then
    {
        return remove(company_name, position, root->right);
    }
    else                                             //if the nodes are equal
    {
        root->the_job->get_position(temp_position); 
        if(strcmp(temp_position, position) > 0)      //if the position is less
        {
            return remove(company_name, position, root->left);
        }
        else if (strcmp(temp_name, company_name) > 0)  //if the position is greater
        {
            return remove(company_name, position, root->right);
        }
        else                             //if they are equal and the job should be removed
        {
            if(!root->left && !root->right)   //node with no children
            {
                delete root;
                root = NULL;
            }
            else if(root->left && root->right)     //node with 2 children
            {
               previous = root;
               temp = root->right;
               if(temp->left)
               {
                   while(temp->left)
                   {
                       previous = temp;
                       temp = temp->left;
                   }
                   previous->left = temp->right;
                   delete root->the_job;
                   root->the_job = NULL;
                   root->the_job = temp->the_job;
                   delete temp;
                   temp = NULL;
                   return 1;
               }
               else
               {
                   previous->right = temp->right;
                   delete root->the_job;
                   root->the_job = NULL;
                   root->the_job = temp->the_job;
                   delete temp;
                   temp = NULL;
                   return 1;
               }
            }
            else       //nodes with only one child
            {
                if(root->left)         //only a left child
                {   
                     temp = root->left;
                     delete root;
                     root = temp;
                     return 1;
                }
                else                   //only a right child
                {
                     temp = root->right;
                     delete root;
                     root = temp;
                     return 1;
                }
            }
        }
    }
}

//wrapper function for the retrieve function, ret_wrap, takes in the company name
// of the node to be retrieved and a struct to be filled with the members
//and calls the retrieve function and returns and int indicating success.
int table::ret_wrap(char * company_name, a_job * & found)
{
    found = new a_job[100];
    int num_found = 0;
    return retrieve(company_name, root, found, num_found);
    //a_job * temp = NULL;
    //int counter = 0;
    //a_job to_send;
    //temp = new a_job [100];
    //
    //for (int i = 0; (retrieve(company_name, position, root, to_send) == 1) && i < 100; ++i)
    //{
    //    temp[i] = to_send;
    //    ++counter;
    //}
    //found = new a_job[counter + 1];
    //for(int i = 0; i < counter; ++1)
    //{
    //    found[i] = temp[i];
    //}
}

//retrieve function takes the company name of the job to find and an 
//empty struct to fill with data members and returns a int indicating success.
int table::retrieve(char * company_name, node * root, a_job * & found, int & num_found)
{   
    char * temp_name = NULL;              //for holding the company name
    a_job found_temp;

    if (!root)                            //empty tree case or end of tree case
    {
        return 0;
    }
    root->the_job->get_name(temp_name); 
    if (strcmp(temp_name, company_name) > 0)   //company name is less then
    {
        return retrieve(company_name, root->left, found, num_found);
    }
    else if (strcmp(temp_name, company_name) < 0) //company name is more then
    {
        return retrieve(company_name, root->right, found, num_found);
    }    
    else                                          //companies are equal
    {
        root->the_job->retrieve(found_temp);
        found[num_found++] = found_temp;
        retrieve(company_name, root->right, found, num_found);
        return 1; 
    }
}


//display wrapper function, dis_wrap calls the wrapper function and sends it
//the company and postiont to find and the root pointer returns and int indicating success.
int table::dis_wrap(char * company_name, char * position)
{
    return display(company_name, position, root);
}

//display function takes in the name of the company and position to display and the
// root pointer and calls the job class function to display that company,
// returns an int indicating success.
int table::display(char * company_name, char * position, node * & root)
{   
    char * temp_name = NULL; // for holding the company name
    char * temp_position = NULL; // for holding the company position
    if (!root)                           //empty tree or end of tree case
    {
        return 0;
    }
    root->the_job->get_name(temp_name); 
    if (strcmp(temp_name, company_name) > 0)        //company name is less then
    {
        return display(company_name, position, root->left);
    }
    else if (strcmp(temp_name, company_name) < 0)     //company name is greater then
    {
        return display(company_name, position, root->right);
    }    
    else                                               //companies are equal
    {
        root->the_job->get_position(temp_position); 
        if(strcmp(temp_position, position) > 0)      //position is less then
        {
            return display(company_name, position, root->left);
        }
        else if(strcmp(temp_position, position) < 0)  //position is greater then
        {
            return display(company_name, position, root->right);
        }
        else                          //positions are equal and node should be displayed
        {
            return root->the_job->display();
        }
    }
}

//display_all wrapper, takes no arguments, calls the display all function passing it the
//root pointer and returns and int indiscting success
int table::display_all_wrap(void)
{
    return display_all(root);
}

//display_all function takes the root pointer as and argument displays all nodes and 
//returns and int indicating success.
int table::display_all(node * & root)
{
    if(!root)
        return 1;
    display_all(root->left);
    root->the_job->display();
    display_all(root->right);
    return 1;
}
