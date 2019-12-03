#include<stdio.h>
#include<stdlib.h>
struct node
  {
    int info;
    struct node *link;
  };
typedef struct node *NODE;

NODE getnode()
{
  NODE N;
  N = (NODE)malloc(sizeof(struct node));
  if(N==NULL)
  {
    printf("MEMORY INSUFFICIENT\n");
    exit(0);
  }
  return N;
}

NODE reverse(NODE first)
{
   NODE temp,CN;
   if(first == NULL){
     printf("The list is empty!!!\n");
     return first;
   }
   CN = NULL;
   while(first)
   {
     temp = first->link;
     first->link = CN;
     CN = first;
     first = temp;
   }
   printf("The reverse operation is successful\n");
   return CN;
}

NODE insertfront(NODE first)
{
  NODE NN = getnode();
  printf("Enter the information\n");
  scanf("%d",&NN->info);
  NN->link = first;
  printf("%d successfully inserted at the front end\n",NN->info);
  return NN;  
}

NODE insertfront1(NODE first,int item)
{
  NODE NN = getnode();
  NN->info = item;
  NN->link = first;
  printf("%d successfully inserted at the front end\n",NN->info);
  return NN;  
}

NODE deletefront(NODE first)
{
  NODE T;
  if(first == NULL)
    printf("The list is empty!!!\n");
  else
  {
    T = first;
    printf("Information deleted from the front end is %d\n",T->info);
    first = first->link;
    free(T);
  }
  return first;
}

void display(NODE first)
{
   NODE T = first;
   if(first == NULL)
   {
     printf("The list is empty!!!\n");
     return;
   }
   printf("The elements in the list\n");
   while(T)
   {
     printf("%d\t",T->info);
     T = T->link;
   } 
   printf("\n"); 
}

NODE insertrear(NODE first)
{
   NODE NN = getnode();
   NODE T;
   printf("Enter the information\n");
   scanf("%d",&NN->info);
   NN->link = NULL;
   if(first == NULL)
      return NN;
   T = first;
   while(T->link!=NULL)
     T=T->link;
   T->link = NN;
   printf("%d successfully inserted at the rear end\n",NN->info);
   return first;     
}

NODE deleterear(NODE first)
{
   NODE T,PN;
   if(first==NULL)
     printf("The list is empty!!!\n");
   else
   {
      T = first;
      if(T->link == NULL)
      {
        printf("Information deleted from the rear end is %d\n",T->info);
        free(T);
        return NULL;
      }
      PN = NULL;
      while(T->link!=NULL)
      {
        PN = T;
        T = T->link;
      }
      PN->link = NULL;
      printf("Information to be deleted is %d\n",T->info);
      free(T);
    }
    return first;   
}

void search(NODE first,int key)
{
  NODE T;int pos=1;
  T = first;
  while(T)
  { 
    if(T->info==key)
    {
      printf("%d found in the list at position %d\n",key,pos);
      return;
    }
    pos++;
    T=T->link;    
  }
  printf("%d is not present in the list\n",key);   
}

NODE delete(NODE first,int key)
{
  NODE T,PN;
  T = first;
  PN = NULL;
  if(first->info == key)
  {
    printf("%d deleted successfully\n",key);
    first = first->link;
    free(T);
    return first;
  }
  while(T)
  {   
    if(T->info==key)break;
    PN = T;
    T=T->link;
  }
  if(!T)
  {
    printf("%d is not present in the list\n",key);
  }
  else
  {
    PN->link = T->link;
    free(T);
    printf("%d deleted successfully\n",key);
  }
  return first;  
}

void count(NODE first)
{
  int l=0;
  NODE T = first;
  while(T)
  {
     l++;
     T=T->link;
  }
  if(!l)
   printf("There are no nodes in the linked list\n");
  else
   printf("Total number of nodes in the list = %d\n",l);   
}
 
NODE insertbypos(NODE first)
{
  int pcnt=1,pos;
  NODE CN,PN;
  CN=first;PN=NULL;
  NODE NN=getnode();
  printf("Enter the information to be inserted and its position\n");
  scanf("%d%d",&NN->info,&pos);
  NN->link=NULL;
  if(pos==1)
  {
     NN->link = first;
     return NN;
  }
  while((pos!=pcnt)&&(CN!=NULL)) 
  {
    pcnt++;
    PN=CN;
    CN=CN->link;
  }
  if((!CN)&&(pos!=pcnt))
    printf("%d cannot be inserted at position %d\n",NN->info,pos);
  else
  {
    PN->link=NN;
    NN->link=CN;
    printf("%d successfully inserted at position %d\n",NN->info,pos);
  }
  return first;
}

NODE sort(NODE first)
{
  NODE f,s;
  int temp;
  if(first==NULL) { printf("The list is empty!!!\n");return first; }
  for(f = first;f->link! = NULL;f = f->link)
    for(s=f->link; s!=NULL;s=s->link)
    {
      if(f->info > s->info)
      {
        temp = f->info;
        f->info=s->info;
        s->info=temp;
      }
    }
   printf("Sorting operation done successfully\n");
   return first;
}
        
void detectloop(NODE first)
{
  NODE f,s;
  if(first==NULL)
    printf("The list is empty!!!\n");
  else
  {
    f = first;
    s = first->link;
    while(f&&s)
    {
      if(f==s)
      {
        printf("Loop Detected\n");
        return;
      }
      else
      {
        f=f->link;
        s=s->link->link;
      }      
    }
    printf("There is no loop\n");
  }
}

void split(NODE f,NODE *s1,NODE *s2)
{
  NODE a,b;int c = 0,i;
  if(f==NULL){ printf("Empty list cannot be split\n"); return;}
  NODE t =f;

  a = NULL;
  b = NULL;
  
  if(f->link==NULL)a = f;
  else
  { 
    while(t!=NULL)
    { 
      c++;
      t=t->link;
    }
    t = f;
    for(i=0;i<(c-1)/2;i++)
    { 
      t=t->link;
    }
    a = f;
    b = t->link;
    t->link = NULL;
   }
   *s1=a;*s2=b;
}  

void movenode(NODE *dest,NODE *src)
{
  NODE t;
  t = *src;
  *src = t->link;
  t->link=*dest;
  *dest=t;  
}

void alter_split(NODE f,NODE *s1,NODE *s2)
{
  NODE t=f;
  NODE a=NULL,b=NULL;
  if(f==NULL){
    printf("Empty list cannot be split\n");
    return;
  }
  if(f->link==NULL)
    a=f;
  else
  {
     while(t!=NULL)
     {
       movenode(&a,&t);
       if(t!=NULL)
       movenode(&b,&t);
     } 
   }
   *s1 =a;*s2=b;
}

void dup(NODE f)
{
  int c=0;
  NODE t,n;
  if(f == NULL)
  {
    printf("Empty list has no duplicates\n");
    return;
  }
  f = sort(f);
  t = f;
  while(t->link!=NULL)
  {
    if(t->info == t->link->info)
     {
      c++;
      n = t->link->link;
      free(t->link);
      t->link=n;
    }
    else
      t= t->link;
  } 
  printf("Number of duplicates = %d\n",c);
}  

NODE shuffle_merge(NODE f,NODE s)
{
  //struct node dummy;
  NODE m = getnode();
  NODE T = m;
  
 // dummy.link = NULL;
  
  while(1)
  {
    if(f == NULL)
    {
      T->link=s;
      break;
    }
    else if(s==NULL)
    {
      T->link = f;
      break;
    }
    else
    {
      movenode(&T->link,&f);
      T=T->link;
     /* T->link=f;
      T=f;
      f = f->link;*/
      movenode(&T->link,&s);
      T=T->link;
      /*T->link=s;
      T=s;
      s=s->link;   */   
    } 
  }
  return m->link;
}

NODE sorted_merge(NODE f,NODE s)
{
  NODE m = getnode();
  NODE T = m;  
  while(1)
  {
    if(f==NULL)
    {
      T->link=s;
      break;
    }
    else if(s==NULL)
    {
      T->link=f;
      break;
    }
    else
    {
      if(f->info<s->info)
        movenode(&T->link,&f);
      else
        movenode(&T->link,&s);
      T =T->link;
    }
  }
  return m->link;
} 

void mergesort(NODE *f)
{
  NODE T =*f;
  NODE a=NULL,b=NULL;
  if(T == NULL || T->link == NULL)
  {
    //printf("Empty list\n");
    return;
  }
  split(T,&a,&b);
  mergesort(&a);
  mergesort(&b);
  *f = sorted_merge(a,b);
}

void push(NODE *dest,int info)
{
  NODE NN=getnode();
  NN->info=info;
  NN->link=*dest;
  *dest=NN;
}

NODE sorted_intersect(NODE f,NODE s)
{
  NODE m=getnode(),T;
  T =m;
  while(f!=NULL && s!=NULL)
  {
    if(f->info == s->info)
    {
      push(&T->link,f->info);
      T =T->link;
      f=f->link;
      s=s->link;
    }
    else if(f->info<s->info)
      f=f->link;
    else
      s=s->link;
  }
  return m->link;
}

void deletemid(NODE N)
{
  NODE next = N->link;
  N->info = next->info;
  N->link = next->link;
  free(next);
}
  
void nth(NODE f,int n)
{
  NODE p1,p2;int i;
  p1 = p2 = f;
  if(f==NULL || n<1)
    printf("Invalid operation\n");
  else
  {
    for(i=0;i<n;i++)
    {
      if(p2 == NULL){ printf("Invalid N\n");return;}
      p2 = p2->link;
    }
    while(p2)
    {
      p1=p1->link;
      p2=p2->link;
    }
    printf("%d element from last = %d\n",n,p1->info);
  }
}
     
int main()
{
  NODE first=NULL,second = NULL,M1=NULL,M2=NULL;
  NODE MID = NULL;
  NODE a=NULL,b=NULL;
  int key,n;
  int ch;
  printf("\n                                              Singly Linked List\n");
  for(;;)
  {
  printf("-------------------------------------------------------------------------------------------------------------------------\n\n");
  printf("Available Choices\n1:Insert Front\n2:Delete Front\n3:Display The List\n4:Insert Rear\n5:Delete Rear\n6:Search A Node\n7:Count Nodes\n8:Reverse the list\n9:Delete A Node\n10:Insert A Node By Position\n11:Detect A Loop\n12:Sort the Linked List\n13:Split the Linked List into 2 half\n14:Alternating split\n15:Remove duplicates\n16:Shuffle Merge\n17:Sorted Merge\n18:Merge Sort\n19:Sorted Intersect\n20:Delete Middle Element\n21:Find Nth Element From Last Node\n\n");
  printf("-------------------------------------------------------------------------------------------------------------------------\n");
  printf("Enter A Choice:");
  scanf("%d",&ch);
  
  switch(ch)
  {
    case 1:first = insertfront(first);break;
    case 2:first = deletefront(first);break;
    case 3:display(first);break;
    case 4:first = insertrear(first);break;
    case 5:first = deleterear(first);break;
    case 6:if(first==NULL)
             printf("The list is empty!!!\n");
           else
           {
             printf("Enter the node information field to be searched\n");
             scanf("%d",&key);
             search(first,key);
           }
           break;
    case 7:count(first);break;
    case 8:first = reverse(first);break;
    case 9:if(first==NULL)
             printf("The list is empty!!!\n");
            else
            {
             printf("Enter the node information field to be deleted\n");
             scanf("%d",&key);
             first = delete(first,key);
            }
            break;
    case 10:first = insertbypos(first);break;
    case 11://first->link->link->link=first;
            detectloop(first);break;
    case 12:first=sort(first);break;
    case 13:split(first,&a,&b);
            display(a);
            display(b);
            break;
    case 14:alter_split(first,&a,&b);
            display(a);
            display(b);
            break;
    case 15:dup(first);break;
    case 16:second = insertfront1(second,20);
            second = insertfront1(second,10);
           // second = insertfront(second);
           // second = insertfront(second);
            printf("The lists to be merged\n");
            display(first);           
            display(second); 
            printf("\n");                    
            display(shuffle_merge(first,second));
            break;
     case 17:second = insertfront1(second,20);
             second = insertfront1(second,10);
           // second = insertfront(second);
           // second = insertfront(second);
             printf("The lists to be merged\n");
             display(first);
             printf("\n");
             display(second);         
            
            display(sorted_merge(first,second));
            break;
     case 18:mergesort(&first);break;
     case 19:second=insertfront1(second,20);
             second=insertfront1(second,10);
             printf("The two lists\n");
             display(first);
             display(second);printf("\n");
             display(sorted_intersect(first,second));break;   
     case 20:second = insertfront1(second,60);
             second = insertfront1(second,50);
             second = insertfront1(second,40);
             second = insertfront1(second,20);
             second = insertfront1(second,10);
             printf("List before deletion of middle element\n");
             display(second);
             MID = second->link->link;
             deletemid(MID);
             printf("List after deletion of middle element\n");
             display(second);
             break;
     case 21:printf("Enter the value of n:");
             scanf("%d",&n);
             nth(first,n); 
             break;
    default:printf("Program Quits\n\n");
            exit(0);
  }
  }
  return 0;
}
