/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dlinkedlist;

/**
 *
 * @author Reem
 */
public class DoubleLinkedList {

    public Node1 Head = null;
    public Node1 Tail = null;

    public Node1 CreateNode(String data) {
        Node1 node = new Node1();
        if (node != null) {
            node.Data = data;
            node.Prev = null;
            node.Next = null;
        }
        return node;
    }

//Add New Node 
    public boolean AddStudent(String data) {
        boolean retval = false;
        Node1 node = CreateNode(data);
        if (node != null) {
            if (Head == null) {
                Head = Tail = node;
            } else {
                Tail.Next = node;
                node.Prev = Tail;
                Tail = node;
            }
            retval = true;
        }
        return retval;
    }

//Insert New Node
    public boolean InsertStudent(String data, int loc) {
        boolean retval = false;
        Node1 node = CreateNode(data);
        if (node != null) {
            if (Head == null) {
                Head = Tail = node;
            } else {
                if (loc == 0) {
                    node.Next = Head;
                    Head.Prev = node;
                    Head = node;
                } else { //Insert in Middle or Last
                    Node1 temp = Head;
                    for (int i = 0; i < loc - 1 && temp != null; i++) {
                        temp = temp.Next;
                    }
                    if (temp != null) {
                        temp.Next.Prev = node.Next;
                        node.Next = temp.Next;
                        node.Prev = temp;
                        temp.Next = node;
                    } else {
                        Tail.Next = node;
                        node.Prev = Tail;
                        Tail = node;
                    }
                }
            }
            retval = true;
        }
        return retval;
    }

//Search Node
    public Node1 SearchStudent(String id) {
        Node1 node = Head;
        
        while (node != null) {
            String [] array =node.Data.split("\n");
            if(array[1].equals(id)){
             break;
            }
            node = node.Next;
        }
        return node;
    }

//Delete Node
    public boolean DeleteStudent(int loc) {
        boolean retval = false;
        if (Head != null) {
            if (loc == 0) {
                if (Head == Tail) {
                    Head = Tail = null;
                } else {
                    Head = Head.Next;
                    Head.Prev = null;
                }
                retval = true;
            } else {

                Node1 temp = Head;
                for (int i = 0; i < loc && temp != null; i++) {
                    temp = temp.Next;
                }
                if (temp != null) {
                    if (temp == Tail) {
                        Tail = Tail.Prev;
                        Tail.Next = null;
                    } else {
                        temp.Prev.Next = temp.Next;
                        temp.Next.Prev = temp.Prev;
                    }
                    retval = true;
                }
            }
        }
        return retval;
    }

    public int countStudents() {
        int count = 0;
        Node1 temp = Head;
        while (temp != null) {
            count++;
            temp = temp.Next;
        }

        System.out.println("Number of Students: " + count);
        return count;
    }

    public void DeleteAllNodes() {
        Node1 temp = new Node1();

        while (Head != null) {
            temp = Head;
            Head = Head.Next;
            temp = null;
        }
        Tail = null;
        System.out.println("All Data are deleted successfully.");
    }

    public void UpdateData(String dataOld, String dataNew) {
        int pos = 0;
        if (Head == null) {
            System.out.print("List not initialized");
            
        } else {
            Node1 current = Head;
            while (current != null) {
                pos++;
                if (current.Data.equals(dataOld)) {
                    current.Data = dataNew;
                    System.out.printf(" Found student " + pos + ": replaced \n" + dataOld + " \n with \n" + dataNew +"\n");
                    return;
                }
                if (current.Next != null) {
                    current = current.Next;
                } else {
                    break;
                }
            }
        }
    }

    public void showData() {
        Node1 current = Head;
        if (Head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Students list: ");
            int count=countStudents();
            for (int i =1; i<=count && current != null;i++) {
                System.out.print("student "+i+": \n"+current.Data + "\n");
                current = current.Next;
            }
        }
    }

}
