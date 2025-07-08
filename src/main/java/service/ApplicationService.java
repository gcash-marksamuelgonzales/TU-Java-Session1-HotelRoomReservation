package service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Scanner;

@Service
public class ApplicationService {

    public void execute(){
        // Populate Rooms
        Integer[] hotelRooms = {101,102,103,104,105,106,107,108,109,110};
        Boolean[] roomStatus = {false,false,false,false,false,false,false,false,false,false};
        initiateSystem(hotelRooms, roomStatus);
    }

    public void initiateSystem(Integer[] hotelRooms, Boolean[] roomStatus){
        boolean isComplete = true;
        Scanner scanner = new Scanner(System.in);
        Integer userInput = 0;
        System.out.println("Welcome to the Hotel Reservation System");
        System.out.println("1. View Available Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Exit");
        System.out.println("---");
        do{
            while(true){
                System.out.println("Enter choice: ");
                if(scanner.hasNextInt()){
                    userInput = scanner.nextInt();
                    if(userInput >= 1 && userInput <= 4){
                        break;
                    } else{
                        System.out.println("Invalid input. Kindly retry..");
                    }
                }

                else{
                    System.out.println("Invalid input. Kindly retry..");
                    scanner.next();
                }
            }

            switch(userInput){
                case 1:
                    StringBuilder availableRooms = new StringBuilder();
                    for(int i=0; i < hotelRooms.length; i++){
                        if(roomStatus[i] == false){
                            availableRooms.append(hotelRooms[i] + " ");
                        }
                    }
                    System.out.println("Available rooms: ");
                    System.out.println(availableRooms);
                    break;

                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Enter room number to book: ");
                    Integer bookedRoom = scanner1.nextInt();
                    // Get Array Position for Booking
                    Integer bookRoomIndex = Arrays.asList(hotelRooms).indexOf(bookedRoom);
                    // Update Status to Booked
                    roomStatus[bookRoomIndex] = true;
                    System.out.println(String.format("Room %s booked successfully.",bookedRoom));
                    break;

                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Enter room number to cancel: ");
                    Integer cancelRoom = scanner2.nextInt();
                    // Get Array Position for Cancellation
                    Integer cancelRoomIndex = Arrays.asList(hotelRooms).indexOf(cancelRoom);
                    // Update Status to Available
                    roomStatus[cancelRoomIndex] = false;
                    System.out.println(String.format("Room %s reservation cancelled.",cancelRoom));
                    break;

                default:
                    System.out.println("Thank you!");
                    isComplete = false;

            }

        } while(isComplete);

    }
}
