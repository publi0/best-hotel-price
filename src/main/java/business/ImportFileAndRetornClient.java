package business;

import model.Client;
import model.ClientType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ImportFileAndRetornClient {

    private File inputFile;
    private String datesString;
    private String typeString;

    public ImportFileAndRetornClient(String path) {
        this.inputFile = new File(path);
    }

    public Client getClient() throws Exception {
        readFile();
        return new Client(getType(), getLocalDate());
    }


    private void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line = br.readLine();
        if (!line.isBlank() || !line.isEmpty()) {
           String[] conditions = line.split(":");
            datesString = conditions[1];
            typeString = conditions[0];

        } else {
            throw new Exception("File is empty or null");
        }
    }

    private List<LocalDate> getLocalDate() {
        List<LocalDate> dates = new ArrayList<>();
        String[] stringDates = datesString.split(",");
        DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern("dMMMyyyy", Locale.ENGLISH);
        for (String stringDate : stringDates) {
            String[] parts = stringDate.split("\\(");
            dates.add(LocalDate.parse(parts[0].trim(), dateFormated));
        }
        return dates;
    }

    private ClientType getType() throws Exception {
        String clientType = typeString;
        if (clientType.equals("Regular")) {
            return ClientType.REGULAR;
        } else if (clientType.equals("Rewards")) {
            return ClientType.REWARDS;
        } else {
            throw new Exception("Client type does not exist");
        }
    }
}
