
package eventyonzonmain;

import java.util.Scanner;

public class EventYonzonMain {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String response;
        
        do{
            System.out.println("=============================");
            System.out.println("Welcome to Event Organization");
            System.out.println("=============================");
            System.out.println("\n1.Add Event");
            System.out.println("\n2.View Event");
            System.out.println("\n3.Update Event");
            System.out.println("\n4.Delete Event");
            System.out.println("\n5.Exit");
            System.out.println("\nSelect Option: ");
            System.out.println("-----------------------------");
            int options = sc.nextInt();                                  
            EventYonzonMain eym = new EventYonzonMain();
            
            switch(options){
                
                case 1:
                    eym.addEvent();
                     break;
                case 2:
                    eym.viewEvents();
                    break;
                case 3:
                    eym.updateEvent();
                    break;
                case 4:
                    eym.deleteEvent();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
                
            }
            System.out.println("Would you like to continue? (y/n): ");
            response = sc.next();
            
        }while(response.equalsIgnoreCase("y"));
        
        System.out.println("Thank you, Come back again!");
    }
    
    public void addEvent(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Event Name: ");
        String ename = sc.next();
        System.out.print("Event Date: ");
        String edate = sc.next();
        System.out.print("Event Location: ");
        String elocation = sc.next();
        System.out.print("Event Description: ");
        String edesc = sc.next();
        System.out.println("Event Organizer: ");
        String eorg = sc.next();
           
        String sql = "INSERT INTO tbl_events (event_name, event_date, location, description, organizer) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, ename, edate, elocation, edesc, eorg);
    }
    
    private void viewEvents() {
        config conf = new config();
        String eymQuery = "SELECT * FROM tbl_events";
        String[] eymHeaders = {"ID","Event Name", "Event Date", "Event Location", "Event Description", "Event Organizer"};
        String[] eymColumns = {"event_id","event_name", "event_date", "location", "description", "organizer"};

        conf.viewRecords(eymQuery, eymHeaders, eymColumns);
    }
    
    private void updateEvent() {
        
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Event ID to Update: ");
        int id = sc.nextInt();

        System.out.print("New Event Name: ");
        String ename = sc.next();
        System.out.print("New Event Date: ");
        String edate = sc.next();
        System.out.print("New Event Location: ");
        String elocation = sc.next();
        System.out.print("New Event Description: ");
        String edesc = sc.next();
        System.out.print("New Event Organizer: ");
        String eorg = sc.next();       
                  
        String sql = "UPDATE tbl_events SET event_name = ?, event_date = ?, location = ?,  description = ?, organizer = ? WHERE c_id = ?";
        conf.updateRecord(sql, ename, edate, elocation, edesc, eorg, id);
    }
    
    private void deleteEvent() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Event ID to Delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM tbl_events WHERE event_id = ?";
        conf.deleteRecord(sql, id);
    }
}