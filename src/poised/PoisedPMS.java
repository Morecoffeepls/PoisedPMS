package poised;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Project management system for a structural engineering firm called "Poised"
 * @author yehud
 * @since 27/04/2020
 */
public class PoisedPMS {
  
  public static void main ( String [] args ) {
    
    mainMenu();
    }

  /**
   * main menu method, which contains the database connection object, statement object and the calls to other methods of the menu
   */
  public static void mainMenu() {
    try ( 
        /**
         * Database 'Connection' object
         */
        Connection conn = DriverManager . getConnection ( "jdbc:mysql://localhost:3306/PoisedPMS?useSSL=false" , "myuser" , "xxxx" );
        
        /**
         * 'Statement' object in the Connection, passed to the respective methods 
         */
        Statement stmt = conn . createStatement ();
        ) 
    { 

      /**
       * main menu options
       */
      System.out.println("\nPlease choose an option: \n1 - Enter new project  \n2 - Update project  \n3 - Finalise project \n4 - Search for projects that are overdue or still need to be completed \n5 - Show all projects \n0 - exit");
      @SuppressWarnings("resource")
      Scanner bd = new Scanner(System.in);
      String menu = bd.next();
      if(menu.equals("1")) {
        // call new project method to add a new project
        newProject(stmt);
        // once finished call the main menu method to return to the menu
        mainMenu();
      }
      else if (menu.equals("2")) {
        // call update book info method
        updateProject(stmt);
        mainMenu();
      }
      else if (menu.equals("3")) {
        // call finalize method
        finalise(stmt);
        mainMenu();
      }
      else if(menu.equals("4")) {
        // call search method
        search(stmt);
        mainMenu();
      }
      else if (menu.equals("0")){
        //exit system
         System.exit(0);
      }
      else if (menu.equals("5")) {
        // call show projects in the database method
        showall(stmt);
        mainMenu();
      }
      
      } catch ( SQLException ex ) { 
        ex . printStackTrace ();
        } 
  }
  /**
   * this method shows all the projects in the database
   * @param stmt - take the statement object to execute sql queries and pass that the result set object
   * @throws SQLException
   */
  private static void showall(Statement stmt) throws SQLException {
    // SHOW all the projects in the database
      try {
        // string of sql query code to be executed
        String query = "SELECT * FROM projects  ";
        System . out . println ( "The SQL query is " + query ); 
        // collect results in result set
        ResultSet rset = stmt . executeQuery ( query );
        // display the results
        while ( rset . next ()) { 
          System . out . println ( "project number: " + rset . getInt ( "projectNumber" ) + ", " 
              + "\nProject Name: "+ rset . getString ( "projectName" ) + ", " 
              + "\nBuilding type: " + rset . getString ( "buildingType" ) + ", " 
              + "\nBuilding Address: " + rset . getString ( "buildingAddress" ) + ", " 
              + "\nERF Number: " + rset . getInt ( "ERFnumber" ) + ", " 
              + "\nTotal Fee: " + rset . getInt ( "totalFee" ) + ", " 
              + "\nTotal paid: " + rset . getInt ( "totalPaid" ) + ", " 
              + "\nDeadline: " + rset . getDate ( "deadline" ) + ", " 
              + "\nArchitect Name: " + rset . getString ( "architechName" ) + ", " 
              + "\nContractor Name: " + rset . getString ( "contractorName" ) + ", " 
              + "\nCustomer Name: " + rset . getString ( "customerName" ) + ", " 
              + "\nEngineer Name: " + rset . getString ( "engineerName" ) + ", " 
              + "\nCompleted:" + rset . getString ( "completed" ) + ", " 
              + "\nDate completed: " + rset . getDate( "datecompleted" ));
          }
        } catch (SQLException e) {
        e.printStackTrace();
      }
  }
  /**
   * this method searches the database for all projects that still need to be completed or are overdue and displays the results
   * @param stmt - statement object to pass to the sql query and result set
   * @throws SQLException
   */
  private static void search(Statement stmt) throws SQLException {
    try {
      // prompt the user for the project name or number 
      String projects = JOptionPane.showInputDialog("Show projects that still need to be completed (1) or are overdue (2) : ");
      // option 1 - projects that still need to be completed
      if(projects.equals("1")) {
        // query database
        String query = "SELECT * FROM projects WHERE completed != 'yes' ";
        System . out . println ( "The SQL query is " + query ); 
        ResultSet rset = stmt . executeQuery ( query );
        // display results
        while ( rset . next ()) { 
          System . out . println ( "project number: " + rset . getInt ( "projectNumber" ) + ", " 
              + "\nProject Name: "+ rset . getString ( "projectName" ) + ", " 
              + "\nBuilding type: " + rset . getString ( "buildingType" ) + ", " 
              + "\nBuilding Address: " + rset . getString ( "buildingAddress" ) + ", " 
              + "\nERF Number: " + rset . getInt ( "ERFnumber" ) + ", " 
              + "\nTotal Fee: " + rset . getInt ( "totalFee" ) + ", " 
              + "\nTotal paid: " + rset . getInt ( "totalPaid" ) + ", " 
              + "\nDeadline: " + rset . getDate ( "deadline" ) + ", " 
              + "\nArchitect Name: " + rset . getString ( "architechName" ) + ", " 
              + "\nContractor Name: " + rset . getString ( "contractorName" ) + ", " 
              + "\nCustomer Name: " + rset . getString ( "customerName" ) + ", " 
              + "\nEngineer Name: " + rset . getString ( "engineerName" ) + ", " 
              + "\nCompleted:" + rset . getString ( "completed" ) + ", " 
              + "\nDate completed: " + rset . getDate( "datecompleted" ));
          }
      }
      else if(projects.equals("2")) {
        //option 2 - overdue projects
        String query = "SELECT * FROM projects WHERE CURDATE() > deadline ";
        System . out . println ( "The SQL query is " + query + "\n\nThe following projects are overdue! \n"); 
        ResultSet rset = stmt . executeQuery ( query );
        while ( rset . next ()) { 
          System . out . println ( "project number: " + rset . getInt ( "projectNumber" ) + ", " 
              + "\nProject Name: "+ rset . getString ( "projectName" ) + ", " 
              + "\nBuilding type: " + rset . getString ( "buildingType" ) + ", " 
              + "\nBuilding Address: " + rset . getString ( "buildingAddress" ) + ", " 
              + "\nERF Number: " + rset . getInt ( "ERFnumber" ) + ", " 
              + "\nTotal Fee: " + rset . getInt ( "totalFee" ) + ", " 
              + "\nTotal paid: " + rset . getInt ( "totalPaid" ) + ", " 
              + "\nDeadline: " + rset . getDate ( "deadline" ) + ", " 
              + "\nArchitect Name: " + rset . getString ( "architechName" ) + ", " 
              + "\nContractor Name: " + rset . getString ( "contractorName" ) + ", " 
              + "\nCustomer Name: " + rset . getString ( "customerName" ) + ", " 
              + "\nEngineer Name: " + rset . getString ( "engineerName" ) + ", " 
              + "\nCompleted:" + rset . getString ( "completed" ) + ", " 
              + "\nDate completed: " + rset . getDate( "datecompleted" ));
          }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /**
   * this method finalizes projects and generates an invoice if there is any outstanding money
   * @param stmt - statement object to pass to the sql query and result set 
   * @throws SQLException
   */
  private static void finalise(Statement stmt) throws SQLException {
    try {
      // string to store the customers name - used to query the customers table, once this name is found from finalizing the project
      String custName = "";
      String project = JOptionPane.showInputDialog("Please enter the name or number of the project you would like to finalise: ");
      
      System.out.println("Checking for outstanding fee's");
      /**
       * check if money is still owed, if yes then generate an invoice
       */
      String query = "SELECT * FROM projects WHERE projectName = " + "'" + project + "'" + " or projectNumber = " + project + " And  totalFee > totalPaid ";
      System . out . println ( "\nINVOICE FOR THIS PROJECT:\n " ); 
      ResultSet rset = stmt . executeQuery ( query );
      // display results (invoice in this case)
      while ( rset . next ()) { 
        System . out . println ( "project number: " + rset . getInt ( "projectNumber" ) + ", " 
            + "\nProject Name: "+ rset . getString ( "projectName" ) + ", " 
            + "\nOutstanding amount: " + (rset . getInt ( "totalFee" ) - rset . getInt ( "totalPaid" )) + ", " 
            + "\nCustomer Name: " + (custName = rset . getString ( "customerName" )));
      }
      // display customer details for the invoice
      String queryCust = "SELECT * FROM customers WHERE customerName = " + "'" + custName + "'" ;
      //System . out . println ( "The SQL query is " + queryCust + "\n\nCustomer details: \n"); 
      ResultSet rsetCust = stmt . executeQuery ( queryCust );
      while ( rsetCust . next ()) { 
        System . out . println ( "Customer number: "+ rsetCust . getString ( "customerNumber" ) + ", " 
            + "\nCustomer Email: " + rsetCust . getString ( "customerEmail" ) + ", " 
            + "\nCustomer Address: " + rsetCust . getString ( "customerAddress" ));
        //TODO display customers details
        }
      /**
       * finalize the project by adding 'yes' to the completed column and the date to the datefinalised column
       */
      String fin = "update projects set completed = 'yes', datecompleted = CURDATE() where projectName = " + "'" + project + "'" + " or projectNumber =  " + project ; 
      //System . out . println ( "The SQL query is: " + fin ); 
      int countFinalised = stmt . executeUpdate ( fin );
      System . out . println ( countFinalised + "\n records finalised.\n" );

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  /**
   * this method updates project and person details
   * @param stmt - statement object to pass to the sql query and result set 
   */
  private static void updateProject(Statement stmt) {
    try {
      String update = JOptionPane.showInputDialog("Would you like to update project details (1) or person details (2) ? ");
      // if update project details is chosen then call the project details method
      if (update.equals("1")) {
        projectDetails(stmt);
      }
      // if the person details option is chosen then call the person details method
      else if (update.equals("2")) {
        personDetails(stmt);
      }

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * update details about the project
   * @param stmt - statement object to pass to the sql query and result set 
   * @throws SQLException
   */
  private static void projectDetails(Statement stmt) throws SQLException {
    // choose a project to update via its name or number
    String project = JOptionPane.showInputDialog("Please enter the name or number of the project you want to update: ");
    
    // choose a field to update
    String update =  Updates.updateProjDetails();

    // update questions for the respective choice of field
    String updateVal = Updates.updateProjectQuestions(update);
    // update query
    String strUpdate = "update projects set " + updateVal +  " where projectNumber = " + project + " or projectName = " + project ;
    // print the query and execute it
    System . out . println ( "The SQL query is: " + strUpdate ); 
    int countUpdated = stmt . executeUpdate ( strUpdate ); 
    System . out . println ( countUpdated + " records affected." );
  }
  /**
   * update details about persons working on the project
   * @param stmt - statement object to pass to the sql query and result set
   * @throws SQLException
   */
  private static void personDetails(Statement stmt) throws SQLException {
    // choose a field to update
    String updatePer =  Updates.updatePerDetails();
    // tablename and tableN are used to choose the respective table of the given person in choice
    String tablename = " ";
    String tableN = "";
    if(updatePer.equals("1") || updatePer.equals("2") || updatePer.equals("3") || updatePer.equals("4")) {
      tablename = "architects";
      tableN = "architech";
    }
    else if(updatePer.equals("5") || updatePer.equals("6") || updatePer.equals("7") || updatePer.equals("8")) {
      tablename = "contractors";
      tableN = "contractor";
    }
    
    else if(updatePer.equals("9") || updatePer.equals("10") || updatePer.equals("11") || updatePer.equals("12")) {
      tablename = "customers";
      tableN = "customer";
    }
    else if(updatePer.equals("13") || updatePer.equals("14") || updatePer.equals("15") || updatePer.equals("16")) {
      tablename = "engineers";
      tableN = "engineer";
    }
    // prompt the user with the update questions
    String updateVal = Updates.updatePerson(updatePer);
    
    // choose a project to update via its name or number
    String person = JOptionPane.showInputDialog("Please enter the name of the person you are updating");
    // update query
    String strUpdate = "update " + tablename +" set " + updateVal +  " where " + tableN +"Name " + " = " + "'" + person + "'";
    // print and execute query
    System . out . println ( "The SQL query is: " + strUpdate ); 
    int countUpdated = stmt . executeUpdate ( strUpdate ); 
    System . out . println ( countUpdated + " records affected." );
  }
  /**
   * Add a new project to the database.
   * the persons info must be entered first as their name fields are foreign keys in the project database and adding them to the project database first will cause an error in this configuration
   * @param stmt- statement object to pass to the sql query and result set
   * @throws SQLException
   */
  private static void newProject(Statement stmt) throws SQLException {
    try {
      /**
       * add new architect by calling the architect questions from the architect method in the newProject class, and adding the results to the database
       */
      String arch = NewProject.architect();
      
      String sqlInsertArch = "insert into architects values ("+ arch +");" ;
      System . out . println ( "The SQL query is: " + sqlInsertArch ); 
      //ResultSet rset = stmt . executeQuery ( sqlInsert );
      int countInsertedArch = stmt . executeUpdate ( sqlInsertArch ); 
      System . out . println ( countInsertedArch + " records inserted.\n" );
      /**
       * add new contractor by calling the contractor questions from the contractor method in the newProject class, and adding the results to the database
       */
      String cont = NewProject.contractor();
      
      String sqlInsertCont = "insert into contractors values ("+ cont +");" ;
      System . out . println ( "The SQL query is: " + sqlInsertCont ); 
      //ResultSet rset = stmt . executeQuery ( sqlInsert );
      int countInsertedCont = stmt . executeUpdate ( sqlInsertCont ); 
      System . out . println ( countInsertedCont + " records inserted.\n" );
      /**
       * add new customer by calling the customer questions from the customer method in the newProject class, and adding the results to the database
       */
      String cust = NewProject.customer();
      
      String sqlInsertCust = "insert into customers values ("+ cust +");" ;
      System . out . println ( "The SQL query is: " + sqlInsertCust ); 
      //ResultSet rset = stmt . executeQuery ( sqlInsert );
      int countInsertedCust = stmt . executeUpdate ( sqlInsertCust ); 
      System . out . println ( countInsertedCust + " records inserted.\n" );
      /**
       * add new engineer by calling the engineer questions from the engineer method in the newProject class, and adding the results to the database
       */
      String eng = NewProject.engineer();
      
      String sqlInsertEng = "insert into engineers values ("+ eng +");" ;
      System . out . println ( "The SQL query is: " + sqlInsertEng ); 
      //ResultSet rset = stmt . executeQuery ( sqlInsert );
      int countInsertedEng = stmt . executeUpdate ( sqlInsertEng ); 
      System . out . println ( countInsertedEng + " records inserted.\n" );
      /**
       * add new project by calling the newproject questions from the project method in the newProject class, and adding the results to the database
       */
      String proj = NewProject.project();
      
      String sqlInsertProj = "insert into projects values ("+ proj +");" ;
      System . out . println ( "The SQL query is: " + sqlInsertProj ); 
      //ResultSet rset = stmt . executeQuery ( sqlInsert );
      int countInsertedProj = stmt . executeUpdate ( sqlInsertProj ); 
      System . out . println ( countInsertedProj + " records inserted.\n" );

      /**
       * catch the error of not adding persons to the persons database before the project database
       */
    } catch (SQLIntegrityConstraintViolationException e) {
      System.out.println("Enter person's details in the respective tables before adding them in the project");
    }
     catch (SQLException e) {
      e.printStackTrace();
      }
    }
  
}
 


