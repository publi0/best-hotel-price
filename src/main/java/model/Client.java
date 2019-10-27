package model;

import java.time.LocalDate;
import java.util.List;

public class Client {
    private ClientType clientType;
    private List<LocalDate> dates;

    public Client(ClientType clientType, List<LocalDate> dates) {
        this.clientType = clientType;
        this.dates = dates;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public List<LocalDate> getDates() {
        return dates;
    }
}
