package ui;

import model.Company;


public class Main {

    private Company company;

    public Main() {
        company = new Company();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addEmployee();


    }
    public void addEmployee (){
        company.addGeneric("13","Juan Marcos",13);
        company.addGeneric("14","Juan Marcos",13);
        company.addGeneric("12","Juan Marcos",13);
        company.addGeneric("9","Juan Marcos",13);
        company.addGeneric("11","Juan Marcos",13);
        company.addGeneric("15","Juan Marcos",13);
        company.addGeneric("10","Juan Marcos",13);
        System.out.println("Pre orden");
        System.out.println(company.printPreOrder());
        //System.out.println("Post orden");
        //System.out.println(company.printPostOrder());
        //System.out.println("In orden");
        //System.out.println(company.printInOrder());


    }
     /*
        company.add("12","Juan Marcos",13);
        company.add("13","Juan Marcos",13);
        company.add("14","Juan Marcos",13);
        company.add("15","Juan Marcos",13);
        company.add("10","Juan Marcos",13);
        company.add("11","Juan Marcos",13);
        company.add("9","Juan Marcos",13);
        company.add("8","Juan Marcos",13);
        company.add("7","Juan Marcos",13);
        company.inOrder();

         */
}
