package controller.business;

import controller.model.Client;
import controller.model.ClientType;

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

    public ImportFileAndRetornClient(String path) {
        this.inputFile = new File(path);
    }

    public Client getClient() throws Exception {
        String[] condition = readFileAndReturnStringArray();
        return new Client(inputToClientType(condition[0]), inputToLocalDate(condition[1]));
    }


    private String[] readFileAndReturnStringArray() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line = br.readLine();
        if (!line.isBlank() || !line.isEmpty()) {
            return line.split(":");
        } else {
            throw new Exception("File is empty or null");
        }
    }

    private List<LocalDate> inputToLocalDate(String stringInput) {
        List<LocalDate> dates = new ArrayList<>();
        String[] stringDates = stringInput.split(",");
        DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern("dMMMyyyy", Locale.ENGLISH);
        for (String stringDate : stringDates) {
            String[] parts = stringDate.split("\\(");
            dates.add(LocalDate.parse(parts[0].trim(), dateFormated));
        }
        return dates;
    }

    private ClientType inputToClientType(String clientType) throws Exception {
        if (clientType.equals("Regular")) {
            return ClientType.REGULAR;
        } else if (clientType.equals("Rewards")) {
            return ClientType.REWARDS;
        } else {
            throw new Exception("Client type does not exist");
        }
    }
}
