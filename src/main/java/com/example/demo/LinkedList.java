package com.example.demo;

/* Models an entire linked list. */

public class LinkedList {

    private Node Front;
    private Node Back;
    private int Size;

    // default constructor
    public LinkedList() {
        Front = Back = null;
        Size=0;
    }

    // the get the first element
    // it takes constant time O(1)
    public Node getFront() {
        return Front;
    }

    // the get the last element
    // it takes constant time O(1)
    public Node getBack() {
        return Back;
    }

    /* void addFirst(Object o)
     * Inserts the given element at the beginning of the list. */
   private void addFirst(Object element){
        Node newNode;
        newNode=new Node(element);
        if (Size==0) {// Empty List
            Front=Back=newNode;
        }
        else{
            newNode.setNext(Front);
            Front=newNode;
        }
        Size++;// update Size
    }

    /*Object getFirst()
    Returns the first element in the list. */
    public Object getFirst() {
        if (Size == 0)
            return null;
        else
            return Front.getElement();
    }

    /*void addLast(Object o)
     Appends the given element to the end of the list.*/
    private void addLast (Object element){
        Node newNode;
        newNode=new Node(element);
        if (Size==0){// Empty List
            Front=Back=newNode;
        }
        else{
            Back.setNext(newNode);
            Back=newNode; // Or Back=Back.next;
        }
        Size++;// update Size
    }

    /* Object getLast()
    Returns the last element in the list.*/
    public Object getLast(){
        if (Size==0)
            return null;
        else
            return Back.getElement();
    }

    /*Object get(int index)
    Returns the element at the specified position in the list.*/
    public Object get(int index){
        if (Size==0) return null; //empty list
        else if (index==0) return getFirst(); //first element
        else if (index==Size-1)return getLast(); //last element
        else if (index >0 && index<Size-1){
            Node current=Front;
            for (int i=0;i<index;i++)
                current=current.getNext();
            return current.getElement();
        }
        else
            return null; //out of boundary
    }

    /*Node get(int index)
Returns the Node at the specified position in the list.*/
    private  Node getNode(int index){
        if (Size==0) return null; //empty list
        else if (index==0) return Front; //first element
        else if (index==Size-1)return Back; //last element
        else if (index >0 && index<Size-1){
            Node current=Front;
            for (int i=0;i<index;i++)
                current=current.getNext();
            return current;
        }
        else
            return null; //out of boundary
    }





    /*void add(int index, Object element) Inserts the specified
    element at the specified position index in this list.*/
    public void add(int index, Object element) {
        if (index==0) addFirst(element);
        else if (index>=size())addLast(element);
        else{
            Node newNode= new Node(element);
            Node current=Front; //used to advance to proper position
            for (int i=0;i<index-1;i++)
                current=current.getNext();
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            Size++;// update size
        }
    }

    /*int size()
    Returns the number of elements in the list.*/
    public int size(){
        return Size;
    }

    /*void add(Object o)
    Appends the specified element to the end of the list*/
    private void add(Object element)
    {
        add(size(), element);
    }

    /*boolean removeFirst()
    Removes the first element from the list.*/
    public boolean removeFirst(){
        if (Size==0)
            return false; //empty list
        else if (Size==1) //one element inside list
            Front=Back=null;
        else
            Front=Front.getNext();
        Size--; //update size
        return true;
    }

    /*boolean removeLast()
    Removes the last element from this list.*/
    public boolean removeLast(){
        if (Size==0)
            return false; //empty list
        else if (Size==1) // one element inside the list
            Front=Back=null;
        else{
            Node current= Front;
            for (int i=0;i<Size-2;i++)
                current=current.getNext();
            current.setNext(null);
            Back=current;
        }
        Size--; //update size
        return true;
    }

    /*boolean remove(int index)
     * Removes the element at the specified position in the list*/
    public boolean remove(int index){
        if (Size==0)return false;//empty linked list
        else if (index==0)return removeFirst(); //remove first element
        else if (index==Size-1)return removeLast();//remove last element
        else if (index >0 && index<Size-1){
            Node current=Front;
            for (int i=0;i<index-1;i++)
                current=current.getNext();
            current.setNext(current.getNext().getNext());
            Size--;
            return true;
        }
        else return false; // out of boundary(invalid index)
    }


    /* int search(Object element)
   Returns the index of the first occurrence of the specified element in this list,
   or -1 if this list does not contain the element. */
    public int search(Object element) {
        Node current = Front;
        for (int i = 0; i < Size; i++) {
            if (current.getElement().equals(element)) {
                return i; // Found the element, return its index
            }
            current = current.getNext();
        }
        return -1; // Element not found
    }

    // the method to add the node in order
    // we assume the year and month and day integer
    public  boolean addInOrder( int value) {

        if(search(value)!=-1)// element exist
            return  false;

        if (Size==0) { // empty list
            addLast(value);
            return  true;
        } else {
            int index = 0;
            while (index < size() && (value > (int)get(index))) {
                index++;
            }
            add(index, value);
            return true;
        }

    }


    // the method add the day in the year node
    public boolean add(int day , int month ,int year ,ElectricityRecord record){

        int yearIndex =search(year);

        // chick if the year exist or not
        if(yearIndex==-1) { // year don't exist
            addInOrder(year);
            yearIndex=search(year); // the new index

            // initialization of month list
            getNode(yearIndex).setList(new LinkedList());
        }

        int monthIndex;

        // chick if the month exist
        if( getNode(yearIndex).getList().search(month)==-1){ // month don't exist

            // add the month in the list
            getNode(yearIndex).getList().addInOrder(month);

            monthIndex =  getNode(yearIndex).getList().search(month);

            // initialization of day list
            getNode(yearIndex).getList().getNode(monthIndex).setList(new LinkedList());



        }

        monthIndex =  getNode(yearIndex).getList().search(month);

        // chick if the day exist or not
        if( getNode(yearIndex).getList().getNode(monthIndex).getList()==null ||
                getNode(yearIndex).getList().getNode(monthIndex).getList().search(day)==-1){

            getNode(yearIndex).getList().getNode(monthIndex).getList().addInOrder(day);

            int dayIndex = getNode(yearIndex).getList().getNode(monthIndex).getList().search(day);

            getNode(yearIndex).getList().getNode(monthIndex).getList().getNode(dayIndex).setList(new LinkedList());
            getNode(yearIndex).getList().getNode(monthIndex).getList().getNode(dayIndex).getList().add(record);
            return true;
        }
        else

            return false;

    }

    // the method update the day in the year node
    public boolean update(int day , int month ,int year ,ElectricityRecord record){

        int yearIndex =search(year);

        // chick if the year exist or not
        if(yearIndex==-1) { // year don't exist

            return  false;
        }

        int monthIndex;

        // chick if the month exist
        if( getNode(yearIndex).getList().search(month)==-1){ // month don't exist

            return  false;

        }

        monthIndex =  getNode(yearIndex).getList().search(month);

        // chick if the day exist or not
        if( getNode(yearIndex).getList().getNode(monthIndex).getList()==null ||
                getNode(yearIndex).getList().getNode(monthIndex).getList().search(day)==-1){

            return false ; // the day don't exist
        }

        // update the day record
        int dayIndex = getNode(yearIndex).getList().getNode(monthIndex).getList().search(day);
        ElectricityRecord dayNode= (ElectricityRecord) getNode(yearIndex).getList().getNode(monthIndex).getList().getNode(dayIndex).getList().getFirst();

        dayNode.setDate(record.getDate());
        dayNode.setTemp(record.getTemp());
        dayNode.setEgyptianLinesMWs(record.getEgyptianLinesMWs());
        dayNode.setGazaPowerPlantMWs(record.getGazaPowerPlantMWs());
        dayNode.setIsraeliLinesMWs(record.getIsraeliLinesMWs());
        dayNode.setPowerCutsHoursDay400mg(record.getPowerCutsHoursDay400mg());
        dayNode.setTotalDailySupplyAvailableInMWs(record.getTotalDailySupplyAvailableInMWs());
        dayNode.setOverallDemandInMWs(record.getOverallDemandInMWs());

            return true;

    }

    // to search about the day if the day dont exist return null
    public Object search(int day , int month ,int year ){

        int yearIndex =search(year);

        // chick if the year exist or not
        if(yearIndex==-1) { // year don't exist

            return  null;
        }

        int monthIndex;

        // chick if the month exist
        if( getNode(yearIndex).getList().search(month)==-1){ // month don't exist

            return  null;

        }

        monthIndex =  getNode(yearIndex).getList().search(month);

        // chick if the day exist or not
        if( getNode(yearIndex).getList().getNode(monthIndex).getList()==null ||
                getNode(yearIndex).getList().getNode(monthIndex).getList().search(day)==-1){

            return null ; // the day don't exist
        }

        // update the day record
        int dayIndex = getNode(yearIndex).getList().getNode(monthIndex).getList().search(day);
        ElectricityRecord dayNode= (ElectricityRecord) getNode(yearIndex).getList().getNode(monthIndex).getList().getNode(dayIndex).getList().getFirst();

        return   dayNode;
    }

    // to delete the day in the list
    public  boolean remove(int day,int month,int year){

        int yearIndex =search(year);

        // chick if the year exist or not
        if(yearIndex==-1) { // year don't exist

            return  false;
        }

        int monthIndex;

        // chick if the month exist
        if( getNode(yearIndex).getList().search(month)==-1){ // month don't exist

            return  false;

        }

        monthIndex =  getNode(yearIndex).getList().search(month);

        // chick if the day exist or not
        if( getNode(yearIndex).getList().getNode(monthIndex).getList()==null ||
                getNode(yearIndex).getList().getNode(monthIndex).getList().search(day)==-1){

            return false; // the day don't exist
        }

        // delete the day record
        int dayIndex = getNode(yearIndex).getList().getNode(monthIndex).getList().search(day);
         getNode(yearIndex).getList().getNode(monthIndex).getList().remove(dayIndex);

        return   true;

    }

    // this method to give statistic for a day
     public String dayStatistic(int day){

        StringBuilder stringBuilder=new StringBuilder();

         for( Node i = getFront();i!=null ;i=i.getNext())
             for(Node j = i.getList().getFront();j!=null;j=j.getNext())
                 for(Node k = j.getList().getFront();k!=null;k=k.getNext()){

                             if((int)k.getElement()==day) {
                                 stringBuilder.append(k.getList().getFirst().toString() + "\n");

                                 break;
                             }
                 }

         return stringBuilder.toString();
     }

    // this method to give statistic for a month
    public String monthStatistic(int month){

        StringBuilder stringBuilder=new StringBuilder();

        for( Node i = getFront();i!=null ;i=i.getNext())
            for(Node j = i.getList().getFront();j!=null;j=j.getNext()){

                if((int)j.getElement()==month){ // the month we need to print

                            for(Node k = j.getList().getFront();k!=null;k=k.getNext()) // print all the day
                                    stringBuilder.append(k.getList().getFirst().toString() + "\n");


                            break; // to exit the mont loop
                }
            }

                return  stringBuilder.toString();
            }

    // this method to give statistic for a year
    public String yearStatistic(int year){

        StringBuilder stringBuilder=new StringBuilder();

        for( Node i = getFront();i!=null ;i=i.getNext()){
                        if((int)i.getElement()==year) { // the year we need to print

                            for(Node j = i.getList().getFront();j!=null;j=j.getNext())

                                for(Node k = j.getList().getFront();k!=null;k=k.getNext()) // print all the day

                                    stringBuilder.append(k.getList().getFirst().toString() + "\n");


                            break; // exit the year loop
                        }
        }


        return  stringBuilder.toString();
    }




     }







