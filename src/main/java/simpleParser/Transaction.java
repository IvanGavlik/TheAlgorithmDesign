package simpleParser;

import java.util.Date;
import java.util.Objects;

public final class Transaction {
    private final String customer;
    private final Date date;
    private final double amunt;

    public Transaction(String customer, Date date, double amunt) {
        this.customer = customer;
        this.date = date;
        this.amunt = amunt;
    }

    public String getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public double getAmunt() {
        return amunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amunt, amunt) == 0 && Objects.equals(customer, that.customer) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, date, amunt);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer='" + customer + '\'' +
                ", date=" + date +
                ", amunt=" + amunt +
                '}';
    }
}
