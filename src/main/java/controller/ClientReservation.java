package controller;

public class ClientReservation {
    private String clientType;
    private String[] dates;

    public ClientReservation(String clientType, String[] dates) {
        this.clientType = clientType.trim().toLowerCase();
        this.dates = dates;
    }

    public String getClientType() {
        return clientType;
    }

    public String[] getDates() {
        return dates;
    }
}
