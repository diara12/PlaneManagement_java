import java.util.Scanner;

public class PlaneManagement {

    static int[][] planeSeats = new int[4][];
    static int[] tickets = new int[100];
    static int ticketCount = 0;

    public static void initialiseRows() {
        planeSeats[0] = new int[14];
        planeSeats[1] = new int[12];
        planeSeats[2] = new int[12];
        planeSeats[3] = new int[14];
    }


    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application\n");
        initialiseRows();
        showMenu();

    }

    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("***********************************************");
            System.out.println("*            MENU OPTIONS                     *");
            System.out.println("***********************************************\n");
            System.out.println("     1) Buy a seat                         ");
            System.out.println("     2) Cancel a seat                      ");
            System.out.println("     3) Find first available seat          ");
            System.out.println("     4) Show seating plan                  ");
            System.out.println("     5) Print tickets information and total sales");
            System.out.println("     6) Search ticket                      ");
            System.out.println("     0) Quit                               ");
            System.out.println("*************************************************\n");
            System.out.println("Please select an option: ");

            option = input.nextInt();
            input.nextLine(); //so that leftover inputs taken to a new line

            switch (option){
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Please select an option in the menu.");
            }
        }while (option != 0);
    }

    public static void buy_seat(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter row (A-D): ");
        String row = input.nextLine().toUpperCase();

        System.out.println("Enter seat number: ");
        int seat = input.nextInt();
        input.nextLine();

        int rowIndex = -1; // this is set when the rowInput is not A-D so the switch won’t match any case, and rowIndex stays -1. That’s your signal that the input was invalid.
        switch (row) {
            case "A":
                rowIndex = 0;
                break;
            case "B":
                rowIndex = 1;
                break;
            case "C":
                rowIndex = 2;
                break;
            case "D":
                rowIndex = 3;
                break;
            default:
                System.out.println("Entered row is not valid.");
                return;
        }

        //validate seat
        if (seat < 1 || seat > planeSeats[rowIndex].length){
            System.out.println("Invalid seat number. Please enter a valid number.");
            return;
        }

        //Seat availability
        if(planeSeats[rowIndex][seat - 1] == 0){
            planeSeats[rowIndex][seat -1 ] = 1;
            System.out.println("Row " + row + " seat " + seat + "booked.");
        }else {
            System.out.println("Row " + row + " seat " + seat + "sold.");
        }
    }

    public static void cancel_seat(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter row (A-D): ");
        String row = input.nextLine().toUpperCase();

        System.out.println("Enter seat number: ");
        int seat = input.nextInt();
        input.nextLine();

        int rowIndex = -1; // this is set when the rowInput is not A-D so the switch won’t match any case, and rowIndex stays -1. That’s your signal that the input was invalid.
        switch (row) {
            case "A":
                rowIndex = 0;
                break;
            case "B":
                rowIndex = 1;
                break;
            case "C":
                rowIndex = 2;
                break;
            case "D":
                rowIndex = 3;
                break;
            default:
                System.out.println("Entered row is not valid.");
                return;
        }

        //validate seat
        if (seat < 1 || seat > planeSeats[rowIndex].length){
            System.out.println("Invalid seat number. Please enter a valid number.");
            return;
        }

        //Seat availability
        if(planeSeats[rowIndex][seat - 1] == 1){
            planeSeats[rowIndex][seat -1 ] = 0;
            System.out.println("Row " + row + " seat " + seat + "cancelled.");
        }else {
            System.out.println("Row " + row + " seat " + seat + "is already available.");
        }
    }

    public static void find_first_available(){
        String[] rowLabels = {"A", "B", "C", "D"};

        for (int rowIndex =0; rowIndex < planeSeats.length; rowIndex++){
            for(int seatIndex = 0; seatIndex < planeSeats[rowIndex].length; seatIndex++){
                if(planeSeats[rowIndex][seatIndex] == 0){
                    System.out.println("First available seat: " + rowLabels[rowIndex] + (seatIndex + 1));
                    return;
                }
            }
        }
        System.out.println("No seats left. Plane is fully booked.");
    }

    public static void show_seating_plan(){
        for (int rowIndex =0; rowIndex < planeSeats.length; rowIndex++) {
            for (int seatIndex = 0; seatIndex < planeSeats[rowIndex].length; seatIndex++) {
                if (planeSeats[rowIndex][seatIndex] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}