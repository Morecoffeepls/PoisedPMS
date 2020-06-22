package poised;

import javax.swing.JOptionPane;

/**
* <h1>Add new projects to the database </h1>
* @author Y Taylor
* @since 27/04/2020
* @version 1.0
* this class is part of a larger project management system, it contains methods which return string data about new projects and persons, which are entered into a database. 
*/
/**
 * New project - collects new data for entry into a database
 */
public class NewProject{

  /**
   * this method prompts the user with a series of new project data questions. It returns a string of new project info, where each field is separated by a comma
   * @return string of new project data
   */
  public static  String project( ) {
    
    String projectname = JOptionPane.showInputDialog("Please enter the project name: ");
    
    String projectNumber = JOptionPane.showInputDialog("Please enter project number! ");

    String buildingType = JOptionPane.showInputDialog("Please enter the building type: ");

    String buildingAddress = JOptionPane.showInputDialog("Please enter the building address: ");

    String ERF = JOptionPane.showInputDialog("Please enter the project ERF number: ");

    String totalCharged = JOptionPane.showInputDialog("Please enter the total charged: ");

    String totalPaid = JOptionPane.showInputDialog("Please enter the total paid: ");

    String deadline = JOptionPane.showInputDialog("Please enter the project deadline in the format of (year-month-day): ");

    String architectName = JOptionPane.showInputDialog("Please enter the architect's name: ");
    
    String contractorName = JOptionPane.showInputDialog("Please enter the contractor's name: ");
   
    String customerName = JOptionPane.showInputDialog("Please enter the customer's Name! ");
    
    String engineerName = JOptionPane.showInputDialog("Please enter the engineer's Name! ");
    
    return projectNumber + "," + "'" + projectname +"'" + "," + "'" + buildingType + "'" + "," + "'" + buildingAddress + "'" + "," + ERF + ","  + totalCharged +  "," + totalPaid + "," + "DATE " +"'"+ deadline + "'" + "," + "'" + architectName + "'" + ","
           + "'" + contractorName + "'" + "," + "'" + customerName + "'" + "," + "'" + engineerName + "'" + "," + "'" + "A" + "'" +"," + "DATE " + "'" + "2020-01-03" + "'";
    }
  /**
   * this method prompts the user with a series of new architect data questions. It returns a string of the new info, where each field is separated by a comma
   * @return string of new architect data
   */
  public static String architect() {
    String architectName = JOptionPane.showInputDialog("Please enter the architect's name: ");
    
    String architectTelephone = JOptionPane.showInputDialog("Please enter the architect's telephone number: ");
    
    String architectEmail = JOptionPane.showInputDialog("Please enter the architect's email address: ");
    
    String architectAddress = JOptionPane.showInputDialog("Please enter the architect's address: ");
    
    return "'" + architectName + "'" + "," + "'" + architectTelephone + "'" + "," + "'" + architectEmail + "'" + "," + "'" + architectAddress + "'" ;
    }

  /**
   * this method prompts the user with a series of new contractor data questions. It returns a string of the new info, where each field is separated by a comma
   * @return string of new contractor data
   */

  public static String contractor() {
    String contractorName = JOptionPane.showInputDialog("Please enter the contractor's name: ");

    String contractorTelephone = JOptionPane.showInputDialog("Please enter the contractor's telephone number: ");
  
    String contractorEmail = JOptionPane.showInputDialog("Please enter the contractor's email address: ");

    String contractorAddress = JOptionPane.showInputDialog("Please enter the contractor's address: ");
    
    return "'" + contractorName + "'" + ","+ "'" + contractorTelephone+ "'" + "," + "'" +contractorEmail + "'" + "," + "'" + contractorAddress+ "'";
    }

  /**
   * this method prompts the user with a series of new customer data questions. It returns a string of the new info, where each field is separated by a comma
   * @return string of new customer data
   */

  public static String customer() {
    String customerName = JOptionPane.showInputDialog("Enter the customer's Name! ");
    
    String customerTelephone = JOptionPane.showInputDialog("Please enter the customer's telephone number: ");
    
    String customerEmail = JOptionPane.showInputDialog("Please enter the customer's email address: ");
    
    String customerAddress = JOptionPane.showInputDialog("Please enter the customer's address: ");
    
    return "'" + customerName + "'" + "," + "'" + customerTelephone + "'" + "," + "'" + customerEmail  + "'" + "," + "'" + customerAddress + "'";
    }


  /**
   * this method prompts the user with a series of new engineer data questions. It returns a string of the new info, where each field is separated by a comma
   * @return string of new engineer data
   */

  public static String engineer() {
    String engineerName = JOptionPane.showInputDialog("Enter the engineer's Name! ");
  
    String engineerTelephone = JOptionPane.showInputDialog("Please enter the engineer's telephone number: ");
  
    String engineerEmail = JOptionPane.showInputDialog("Please enter the engineer's email address: ");
  
    String engineerAddress = JOptionPane.showInputDialog("Please enter the engineer's address: ");
    
    return "'" + engineerName + "'" + "," + "'" + engineerTelephone + "'" + "," + "'" + engineerEmail  + "'" + "," + "'" + engineerAddress + "'";
    }
  
}
  

  
  
  

