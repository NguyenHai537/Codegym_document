package Customer;

import java.util.Comparator;

public class ComparatorCustomer implements Comparator<Customer> {

    public ComparatorCustomer(){}

    @Override
    public int compare(Customer o1, Customer o2) {

        return o1.getName().compareTo(o2.getName());

    }
}
