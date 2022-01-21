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
        int amount = Integer.parseInt(fields[2]);
        increaseTransfer(result, fields[0], -amount);
        increaseTransfer(result, fields[1], amount);
    }

    private void increaseTransfer(Map<String, TransferPerClient> result, String clientId, int amount) {
        if (!result.containsKey(clientId)) {
            result.put(clientId, new TransferPerClient(clientId));
        }
        result.get(clientId).increase(amount);
    }
}
