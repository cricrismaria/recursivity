package model;

public class Employee implements Comparable<Employee> {

    private String id;
    private String name;
    private int office;
    private Employee left;
    private Employee right;
    private Employee parent;


    public Employee(String id, String name, int office){
        this.id = id;
        this.name = name;
        this.office = office;
        left = null;
        right = null;
        parent = null;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getOffice(){
        return office;
    }
    public Employee getLeft(){
        return left;
    }
    public Employee getRight(){
        return right;
    }
    public Employee getParent(){
        return parent;
    }
    public void setParent(Employee parent){
        this.parent = parent;
    }
    public void setLeft(Employee left){
        this.left = left;
    }
    public void setRight(Employee right){
        this.right = right;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return " ID: "+id;
    }
}
