package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readLines(path);
        return summarize(lines);
    }

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private List<TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> result = new TreeMap<>();
        for (String line : lines) {
            parseLine(result, line);
        }
        return new ArrayList<>(result.values());
    }

    private void parseLine(Map<String, TransferPerClient> result, String line) {
        String[] fields = line.split(",");
        String sourceClientId = fields[0];
        String targetClientId = fields[1];
        int amount = Integer.parseInt(fields[2]);
        increaseTransfer(result, sourceClientId, -amount);
        increaseTransfer(result, targetClientId, amount);
    }

    private void increaseTransfer(Map<String, TransferPerClient> result, String clientId, int amount) {
        TransferPerClient transfer = result.computeIfAbsent(clientId, k -> new TransferPerClient(clientId));
        transfer.increase(amount);
    }
}
