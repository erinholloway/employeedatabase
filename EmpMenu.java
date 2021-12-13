/* Week 8 Final
 * Erin Holloway
 * 10/12/2021
 * This program provides the data to run the employee.java file.
 */
package finalassignment;
import java.util.Scanner;
public class EmpMenu {//open class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = {}; //empty array of Employee objects
        //the loop until user enters 6 (Exit)
        //used a switch case instead of if else for readability purposes
        //the displayMenu method's returning value will be the argument for our switch case
        while (true) {
            System.out.println("\n---------------------------------------------------------");
            switch (displayMenu(sc)) {
                case "1":
                    employees = loadEmployee(sc, employees);
                    break;
                case "2":
                    employees = addEmployee(sc, employees);
                    break;
                case "3":
                    displayEmployee(employees);
                    break;
                case "4":
                    retrieveEmployee(sc, employees);
                    break;
                case "5":
                    rangeSalaryEmployee(sc, employees);
                    break;
                case "6":
                    System.out.println("Exiting the program... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalic choice.");
            }
        }
    }
    //A method that displays the options of the program the user can select
    //the method also returns the option as string
    public static String displayMenu(Scanner sc) {
        System.out.println("Menu:"
                + "\n[1] Load Employees' Data"
                + "\n[2] Add new Employee"
                + "\n[3] Display All Employees"
                + "\n[4] Retrieve an Employee's Data"
                + "\n[5] Retrieve Employees with Salaries based on range"
                + "\n[6] Exit"
                + "\nEnter your choice: ");
        String option = sc.nextLine();
        System.out.println("---------------------------------------------------------");
        return option;
    }
    //loadEmployee takes Scanner and Employee array object as parameters
    //We use sc to take inputs and employees to store Employee objects
    //we return employees and populate the employees in the main
    public static Employee[] loadEmployee(Scanner sc, Employee[] employees) {
        System.out.print("Enter the number of employees: "); //prompts for input
        int numEmployees = Integer.parseInt(sc.nextLine());
        employees = new Employee[numEmployees];
        System.out.println();
        for (int i = 0; i < numEmployees; i++) {
            System.out.print("Enter the employee's id: "); //prompts for input
            int id = Integer.parseInt(sc.nextLine()); //collects an employee's id
            System.out.print("Enter the employee's name: "); //prompt for input
            String name = sc.nextLine(); //store employee's name
            System.out.print("Enter the employee's salary: "); //prompt for input
            double salary = Double.parseDouble(sc.nextLine()); //stores employee's salary
            Employee newEmployee = new Employee(name, id, salary); //creating an Employee object with id name salary 
            employees[i] = newEmployee; //adding the created employee objects to array
            System.out.println();
        }
        return employees;
    }
    //addEmployee takes Scanner and Employee object as parameter
    //we add a new employee, add it to the employees array and return it
    public static Employee[] addEmployee(Scanner sc, Employee[] employees) {
        System.out.print("Enter the employee's id: "); //prompt for an input
        int id = Integer.parseInt(sc.nextLine()); //stores an employee's id
        System.out.print("Enter the employee's name: "); //prompt user for input
        String name = sc.nextLine(); //stores an employee's name
        System.out.print("Enter the employee's salary: "); //prompt user for input
        double salary = Double.parseDouble(sc.nextLine()); //stores an employee's salary
        Employee newEmployee = new Employee(name, id, salary); //creating an Employee object with id name salary  
        //expand the array
        Employee[] temp = new Employee[employees.length + 1];
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i] = employees[i]; //pass each element in employees array to the temp array
        }
        temp[temp.length - 1] = newEmployee; //add the created employee object to the array
        employees = temp.clone(); //pass the temp array to the employees array
        return employees;
    }
    //display the employees information in a table format
    //where id, name and salary is a header
    public static void displayEmployee(Employee[] employees) {
        System.out.printf("%-10s%-30s%s\n", "ID", "Name", "Salary");
        for (Employee emp : employees) {
            //display each employee's information
            System.out.println(emp.toString());
        }
    }
    //retrieve an employee information by using id as an argument
    //display the employee information in a table format
    public static void retrieveEmployee(Scanner sc, Employee[] employees) {
        System.out.print("Enter the employee's id: "); //prompt for input
        int id = Integer.parseInt(sc.nextLine()); //gets an employee's id
        int i = 0;
        boolean exists = false;
        //check to see if an employee with the id inputed by the user is in array
        for (i = 0; i < employees.length; i++) {
            if (employees[i].getID() == id) {
                exists = true;
                break;
            }
        }
        if (exists) {
            //printing out the user with the specified id's data
            System.out.printf("%-10s%-30s%s\n", "ID", "Name", "Salary");
            System.out.println(employees[i].toString());
        } else {
            System.out.println("Employee not found.");
        }
    }
    //rangeSalaryEmployee takes Scanner and Employee objects as parameters
    //retrieve and display employee information base on the range of salary
    //display it in a formatted table. 
    public static void rangeSalaryEmployee(Scanner sc, Employee[] employees) {
        System.out.print("Enter the lowest salary: "); //prompt for input
        double lowest = Double.parseDouble(sc.nextLine()); //get lowest value of the range
        System.out.print("Enter the highest salary: "); //prompt for input
        double highest = Double.parseDouble(sc.nextLine()); //gets highest value of the range
        System.out.printf("%-10s%-30s%s\n", "ID", "Name", "Salary");
        for (Employee emp : employees) {
            if (emp.getSalary() >= lowest && emp.getSalary() <= highest) {
                //displays the employee's info if the salary is within the range
                System.out.println(emp.toString());
            }
        }
    }
}//end class