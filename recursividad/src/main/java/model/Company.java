package model;

import structure.BinarySearchTree;

public class Company {

    private Employee root;
    private BinarySearchTree<Employee> tree;

    public Company (){
        root = null;
        tree = new BinarySearchTree<>();
    }

    public void addGeneric (String id, String name, int office){
        Employee employee = new Employee(id, name, office);
        tree.add(employee);
    }

    public String printPreOrder (){
        return tree.preOrder();
    }
    public String printInOrder (){
        return tree.inOrder();
    }
    public String printPostOrder (){
        return tree.postOrder();
    }
    public Employee getRoot() {
        return root;
    }

    public int ascii (String id){
        int result = 0;
        for(int i=0; i<id.length(); i++){
            char character = id.charAt(i);
            result += (int) character;

        }
        return result;
    }

    //add

    public void add (String id, String name, int office){
        Employee employee = new Employee(id, name, office);

        if(root == null){
            root = employee;
        }else {
            add(root, employee);
        }
    }

    public void add (Employee currentRoot, Employee employee){
        if (ascii(currentRoot.getId()) > ascii(employee.getId())){
            if (currentRoot.getLeft() == null){
                currentRoot.setLeft(employee);
            } else {
                add(currentRoot.getLeft(),employee);
            }
        }else{
            if (currentRoot.getRight() == null){
                currentRoot.setRight(employee);
            } else {
                add(currentRoot.getRight(),employee);
            }
        }
    }

    public void addIterative (String id, String name, int office){
        Employee newEmployee = new Employee(id, name, office);

        if (root == null){
            root = newEmployee;
            return;
        }

        boolean placed = false;
        Employee current = root;
        while (!placed) {

            if (ascii(current.getId()) > ascii(newEmployee.getId())) {
                if (current.getLeft() != null) {
                    current.setLeft(newEmployee);
                    placed = true;
                } else {
                    current = current.getLeft();
                }
            }
            if (ascii(current.getId()) < ascii(newEmployee.getId())) {
                if (current.getRight() != null) {
                    current.setRight(newEmployee);
                    placed = true;
                } else {
                    current = current.getRight();
                }
            }
        }

    }

    //search

    public Employee search (String id){
        return search(id,root);
    }

    public Employee search (String id, Employee currentRoot){
        if (currentRoot == null || ascii(id) == ascii(currentRoot.getId())){
            return currentRoot;
        } else {
            if (ascii(currentRoot.getId()) > ascii(id)){
                search(id,currentRoot.getLeft());
            }else{
                search(id,currentRoot.getRight());
            }
        }
        return null;
    }

    public Employee searchIterative (String id){
        Employee current = root;

        while (current != null){
            if (ascii(current.getId()) == ascii(id)) {
                return current;
            }else {
                if (ascii(current.getId()) > ascii(id)) {
                    current=current.getLeft();
                } else {
                    current=current.getRight();
                }
            }
        }
        return null;
    }

    //minimum

    public Employee minimum (){
        return minimum(root);
    }

    public Employee minimum (Employee currentRoot){
        if (currentRoot == null || currentRoot.getLeft() == null){
            return currentRoot;
        } else {
            return minimum(currentRoot.getLeft());
        }
    }

    public Employee minimumIterative (){
        Employee currentRoot = root;

        while (currentRoot != null){
            if (currentRoot.getLeft() == null){
                return currentRoot;
            } else {
                currentRoot = currentRoot.getLeft();
            }
        }

        return null;
    }

    // maximum

    public Employee maximum (){
        return maximum(root);
    }

    public Employee maximum (Employee currentRoot){
        if (currentRoot == null || currentRoot.getRight() == null){
            return currentRoot;
        } else {
            return maximum(currentRoot.getRight());
        }
    }

    public Employee maximumIterative (){
        Employee currentRoot = root;

        while (currentRoot != null){
            if (currentRoot.getRight() == null){
                return currentRoot;
            } else {
                currentRoot = currentRoot.getRight();
            }
        }

        return null;
    }
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Employee root) {
        if (root != null) {
            System.out.println(root.getId());
            preOrderRec(root.getLeft());
            preOrderRec(root.getRight());
        }
    }
    public void inOrder(){
        inOrderRec(root);
    }
    public void inOrderRec(Employee root) {
        if (root != null) {
            preOrderRec(root.getLeft());
            System.out.println(root.getId());
            preOrderRec(root.getRight());
        }
    }



}
