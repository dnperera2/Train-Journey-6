package train.passenger_queue;

public class passenger {
    private String name;
    private int ticketID;

    public passenger(String name, int ticketID) {
        this.name = name;
        this.ticketID = ticketID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    @Override
    public String toString() {
        return "passenger{" +
                "name='" + name + '\'' +
                ", ticketID=" + ticketID +
                '}';
    }
}
