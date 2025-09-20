public class Ticket  {
    public String row;
    public int seat;
    public double price;
    public Person person; //Composition = one class contains an instance of another class. A ticket booked by a person

    Ticket (String row, int seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public double getPrice() {
        return price;
    }
    public int getSeat() {
        return seat;
    }
    public Person getPerson() {
        return person;
    }
    public String getRow() {
        return row;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setRow(String row) {
        this.row = row;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void printTicketInfo(){
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
        person.printPersonInfo();
    }
}
