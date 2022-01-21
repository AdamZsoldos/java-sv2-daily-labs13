package day05;

import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TransferAggregator aggregator = new TransferAggregator();
        List<TransferPerClient> transfers = aggregator.readTransfers(Path.of("src/test/resources/transfers.csv"));
        for (TransferPerClient transfer : transfers) {
            System.out.println(transfer.getClientId() + addWhitespace(transfer.getSumOfTransactions(), 12) + addWhitespace(transfer.getNumberOfTransactions(), 5));
        }
    }

    private static String addWhitespace(int number, int totalSpaces) {
        return " ".repeat(totalSpaces - String.valueOf(number).length()) + number;
    }
}
