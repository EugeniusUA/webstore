package com.ebilon.webstore.domain;


public class Customer {
    private String customerId;
    private String name;
    private String address;
    private long noOfOrderedMade;

    public Customer(String customerId, String name, String address, long noOfOrderedMade) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.noOfOrderedMade = noOfOrderedMade;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNoOfOrderedMade() {
        return noOfOrderedMade;
    }

    public void setNoOfOrderedMade(long noOfOrderedMade) {
        this.noOfOrderedMade = noOfOrderedMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (noOfOrderedMade != customer.noOfOrderedMade) return false;
        if (!customerId.equals(customer.customerId)) return false;
        if (!name.equals(customer.name)) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;

    }

    @Override
    public int hashCode() {
        int result = customerId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (int) (noOfOrderedMade ^ (noOfOrderedMade >>> 32));
        return result;
    }
}
