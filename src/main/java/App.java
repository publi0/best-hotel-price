import business.CalculateHotelPrice;
import business.ImportFileAndRetornClient;
import model.Client;
import model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(3, "Lakewood", 110.00, 90.00, 80.00, 80.00));
        hotels.add(new Hotel(4, "Bridgewood", 160.00, 60.00, 110.00, 50.00));
        hotels.add(new Hotel(5, "Ridgewood", 220.00, 150.00, 100.00, 40.00));

        try {
            String path = args[0];
            Client client = new ImportFileAndRetornClient(path).getClient();
            CalculateHotelPrice calculateHotelPrice = new CalculateHotelPrice(hotels, client);
            System.out.println(calculateHotelPrice.getBestHotel());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Arquivo não encontrado");
        }
        finally {
            System.out.println("Finalizando aplicação");
        }
    }
}