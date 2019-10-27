package business;

import model.Client;
import model.ClientType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImportFileAndRetornClientTest {

    @Test
    void getClient(@TempDir Path tempDir) throws Exception {
        Path inputFile = tempDir.resolve("input.txt");
        String inputText = "Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)";
        Files.write(inputFile, inputText.getBytes());
        List<LocalDate> localDates = List.of(LocalDate.of(2009, 3, 26), LocalDate.of(2009, 3, 27), LocalDate.of(2009,
                3, 28));

        ImportFileAndRetornClient importFileAndRetornClient =
                new ImportFileAndRetornClient(inputFile.toRealPath().toString());
        Client client = importFileAndRetornClient.getClient();

        assertEquals(client.getClientType(), ClientType.REWARDS, "Test client type");
        assertEquals(client.getDates(), localDates, "Test client input dates");
    }
}