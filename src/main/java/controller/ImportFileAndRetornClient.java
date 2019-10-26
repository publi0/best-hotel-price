package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImportFileAndRetornClient {
    private File inputFile;
    private List<ClientReservation> clientReservation = new ArrayList<>();

    public ImportFileAndRetornClient(String path) {
        this.inputFile = new File(path);
    }

    public List<ClientReservation> getClientReservation() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            for (String line; (line = br.readLine()) != null; ) {
                String[] condition = line.split(":");
                clientReservation.add(new ClientReservation(condition[0].toString(), condition[1].split(",")));
            }
            return Collections.unmodifiableList(clientReservation);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
            System.exit(1);
            return null;
        }
    }
}
