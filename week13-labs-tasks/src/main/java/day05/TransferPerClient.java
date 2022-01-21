package day05;

import java.util.Objects;

public class TransferPerClient implements Comparable<TransferPerClient> {

    private final String clientId;
    private int sumOfTransactions;
    private int numberOfTransactions;

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public int getSumOfTransactions() {
        return sumOfTransactions;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void increase(int amount) {
        sumOfTransactions += amount;
        numberOfTransactions++;
    }

    public void decrease(int amount) {
        increase(-amount);
    }

    @Override
    public int compareTo(TransferPerClient o) {
        return clientId.compareTo(o.clientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferPerClient that = (TransferPerClient) o;
        return Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
