package day05;

import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TransferAggregator aggregator = new TransferAggregator();
        List<TransferPerClient> transfers = aggregator.readTransfers(Path.of("src/test/resources/transfers.csv"));
        for (TransferPerClient transfer : transfers) {
            System.out.printf("%s %,12d %5d%n", transfer.getClientId(), transfer.getSumOfTransactions(), transfer.getNumberOfTransactions());
        }
    }
}
