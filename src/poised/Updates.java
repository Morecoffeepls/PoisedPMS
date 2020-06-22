package poised;

import javax.swing.*;
/**
* <h1>Update info in current projects </h1>
* @author Y Taylor
* @since 27/04/2020
* @version 1.0
* this class is part of a larger project management system for a small structural engineering firm called Poised.
* this class is called by the PoisedPMS class to prompt the user with update questions relevant to the given project at hand.
* the update questions are passed as strings to the methods which query the database with the updates.
*/

public class Updates {

  /**
   * this is the update menu for the project data
   * @return - returns the selected field to update, via a respective number as a string.
   */
  public static String updateProjDetails() {
    String update = JOptionPane.showInputDialog("To update enter the corresponding number.\n1 - Number\n2 - Name\n3 - Type\n4 - Address"
        + "\n5 - ERF\n6 - Total\n7 - Total paid\n8 - deadline\n9 - Architect's Name\n10 - Contractor's Name\n11 - Customer's Name\n12 - Engineer's Name");
    return update;
    } 
  /**
   * this method is called when the user chooses to update the project info.
   * @param update - it takes a string in the form of a number to return a respective update string
   * @return update string to be passed to the database for updating
   */

  public static String updateProjectQuestions(String update) {
    String a = "";
    if (update.equals("1")){
      String updateNumber = JOptionPane.showInputDialog("Update Number: ");
      a = "projectNumber = " + "'" + updateNumber + "'" ;
      }
    else if (update.equals("2")){
      String updateName = JOptionPane.showInputDialog("Update Name: ");
      a = "projectName = "+ "'" + updateName + "'" ;
      }
    else if (update.equals("3")) {
      String updateType = JOptionPane.showInputDialog("Update building Type: ");
      a =  "buildingType = " + "'" + updateType + "'";
      }
    else if (update.equals("4")) {
      String updateAddress = JOptionPane.showInputDialog("Update Address: ");
      a =  "buildingAddress = " + "'" + updateAddress + "'";
      }
    else if (update.equals("5")) {
      String updateErf = JOptionPane.showInputDialog("Update ERF: ");
      a =  "ERFnumber = " + "'" + updateErf + "'";
      }
    else if (update.equals("6")) {
      String updateTotal = JOptionPane.showInputDialog("Update Total: ");
      a = "totalFee = " + "'" + updateTotal + "'";
      }
    else if (update.equals("7")) {
      String updateTotalPaid = JOptionPane.showInputDialog("Update total paid: ");
      a = "totalPaid = "+ "'" + updateTotalPaid + "'";
    }
    else if (update.equals("8")) {
      String updateDeadline = JOptionPane.showInputDialog("Update Deadline: (year-month-day)");
      a = "deadline = "+ "'" + updateDeadline + "'";
      }
    else if (update.equals("9")) {
      String updateArchitectName = JOptionPane.showInputDialog("Update Architect's Name! ");
      a = "architechName = " + "'" + updateArchitectName + "'";
      }
    else if (update.equals("10")) {
      String updateContractorName = JOptionPane.showInputDialog("Update Contractor's Name! ");
      a = "contractorName = "+ "'" + updateContractorName + "'";
      } 
    else if (update.equals("11")) {
      String updateCustomerName = JOptionPane.showInputDialog("Update Customer's Name! ");
      a = "customerName = "+ "'" + updateCustomerName + "'";
      } 
    else if (update.equals("12")) {
      String updateEngineerName = JOptionPane.showInputDialog("Update Engineer's Name: ");
      a = "engineerName = "+ "'" + updateEngineerName + "'";
      }
    return a;
    }

  /**
   * this method prompts the user to select a field to update in the persons databases
   * @return a string (in the form of a number), which is passed on to the update method to trigger the correct update question
   */
  public static String updatePerDetails() {
    String updatePer = JOptionPane.showInputDialog("To update enter the corresponding number. \n1 - Architect's Name\n2 - Architect's Number"
        + "\n3 - Architect's Email\n4 - Architects Address\n5 - Contractor's Name\n6 - Contractor's Number\n6 - Contractor's Email"
        + "\n7 - Contractor's Address\n8 - Customer's Name\n9 - Customer's Name\n10 - Customer's Number"
        + "\n11 - Customer's Email\n12 - Customer's Address\n13 - Engineer's Name\14 - engineer's Number\15 - Engineer's Email\n16 - Engineer's address ");
    return updatePer;
    } 
  
  /**
   * this method prompts the user with an update questions pertaining to the persons databases
   * @param updatePer - a string which tells the method what to return
   * @return string of update details, which will be passed to the database query for updating
   */
  public static String updatePerson(String updatePer) {
    String a = "";
    if (updatePer.equals("1")) {
      String updateArchitectName = JOptionPane.showInputDialog("Update Architect's Name! ");
      a = "architechName = " + "'" + updateArchitectName + "'";
      }
    else if (updatePer.equals("2")) {
      String updateArchitectNumber = JOptionPane.showInputDialog("Update Architect's Number! ");
      a = "architechNumber = "+ "'" + updateArchitectNumber + "'";
      }        
    else if (updatePer.equals("3")) {
      String updateArchitectEmail = JOptionPane.showInputDialog("Update Architect's Email! ");
      a = "architechEmail = "+ "'" + updateArchitectEmail + "'";
      }           
    else if (updatePer.equals("4")) {
      String updateArchitectAddress = JOptionPane.showInputDialog("Update Architect's Address! ");
      a = "architechAddress = "+ "'" + updateArchitectAddress + "'";
      }           
    else if (updatePer.equals("5")) {
      String updateContractorName = JOptionPane.showInputDialog("Update Contractor's Name! ");
      a = "contractorName = "+ "'" + updateContractorName + "'";
      }                   
    else if (updatePer.equals("6")) {
      String updateContractorNumber = JOptionPane.showInputDialog("Update Contractor's Number! ");
      a = "contractorNumber = "+ "'" + updateContractorNumber + "'";
      }  
    else if (updatePer.equals("7")) {
      String updateContractorEmail = JOptionPane.showInputDialog("Update Contractor's Email! ");
      a = "contractorEmail = "+ "'" + updateContractorEmail + "'";
      }  
    else if (updatePer.equals("8")) {
      String updateContractorAddress = JOptionPane.showInputDialog("Update Contractor's Address! ");
      a = "contractorAddress = "+ "'" + updateContractorAddress + "'";
      }  
    else if (updatePer.equals("9")) {
      String updateCustomerName = JOptionPane.showInputDialog("Update Customer's Name! ");
      a = "customerName = "+ "'" + updateCustomerName + "'";
      } 
    else if (updatePer.equals("10")) {
      String updateCustomerNumber = JOptionPane.showInputDialog("Update Customer's Number! ");
      a = "customerNumber = "+ "'" + updateCustomerNumber + "'";
      } 
    else if (updatePer.equals("11")) {
      String updateCustomerEmail = JOptionPane.showInputDialog("Update Customer's Email! ");
      a = "customerEmail = "+ "'" + updateCustomerEmail + "'";
      } 
    else if (updatePer.equals("12")) {
      String updateCustomerAddress = JOptionPane.showInputDialog("Update Customer's Address! ");
      a = "customerAddress = "+ "'" + updateCustomerAddress + "'";
      }
    else if (updatePer.equals("13")) {
      String updateEngineerName = JOptionPane.showInputDialog("Update Engineer's Name: ");
      a = "engineerName = "+ "'" + updateEngineerName + "'";
      }
    else if (updatePer.equals("14")) {
      String updateEngineerNumber = JOptionPane.showInputDialog("Update Engineer's Number: ");
      a = "engineerNumber = "+ "'" + updateEngineerNumber + "'";
      }
    else if (updatePer.equals("15")) {
      String updateEngineerAddress = JOptionPane.showInputDialog("Update Engineer's Email: ");
      a = "engineerEmail = "+ "'" + updateEngineerAddress + "'";
      }
    else if (updatePer.equals("16")) {
      String updateEngineerAddress = JOptionPane.showInputDialog("Update Engineer's Address: ");
      a = "engineerAddress = "+ "'" + updateEngineerAddress + "'";
      }
    
    return a ;
  }
  
}
  














