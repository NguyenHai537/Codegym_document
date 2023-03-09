package Coach;

public class Coach {
    private String coachID;
    private String name;
    private String licensePlate;
    private double priceOfSeat;
    private int seat;

    private String placeOfDeparture;

    private String destination;

    public Coach(){}

    public Coach(String coachID , String name , String licensePlate , double priceOfSeat , int seat ,String placeOfDeparture ,String destination){
        this.coachID = coachID;
        this.name = name;
        this.licensePlate= licensePlate;
        this.priceOfSeat = priceOfSeat;
        this.seat = seat;
        this.placeOfDeparture = placeOfDeparture;
        this.destination = destination;
    }


    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPriceOfSeat() {
        return priceOfSeat;
    }

    public void setPriceOfSeat(double priceOfSeat) {
        this.priceOfSeat = priceOfSeat;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return   " CoachID='" + coachID + '\'' +
                ", name='" + name + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", priceOfSeat=" + priceOfSeat +
                ", seat=" + seat +
                ", placeOfDeparture='" + placeOfDeparture + '\'' +
                ", destination='" + destination + '\'' +
                "\n";
    }

    public String toFile(){
        return coachID+","+name+","+licensePlate+","
                +priceOfSeat+","+seat+","+placeOfDeparture+","+destination;
    }

}
