/* Week 8 Final
 * Erin Holloway
 * 10/12/2021
 * This program runs the program to and and retrieve employee data by their salary, name, and employee ID.
 */
package finalassignment;

public class Employee {
    private String name;
    private int id;
    private double salary;
    //constructor which sets the values of variables
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    //name 
    public String getName() {
        return name;
    }
    //id 
    public int getID() {
        return id;
    }
    //salary 
    public double getSalary() {
        return salary;
    }
    //displays formatted string of an employee's data
    
    public String toString() {
        return String.format("%-10d%-30s$%.2f", id, name, salary);
    }
}//end class