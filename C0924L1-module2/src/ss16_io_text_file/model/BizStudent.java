package ss16_io_text_file.model;

public class BizStudent extends Student {

    private double acc;
    private double mkt;

    public BizStudent(String id, String name, Address address, double acc, double mkt) {
        super(id, name, address);
        this.acc = acc;
        this.mkt = mkt;
    }

    public double getAcc() {
        return acc;
    }

    public void setAcc(double acc) {
        this.acc = acc;
    }

    public double getMkt() {
        return mkt;
    }

    public void setMkt(double mkt) {
        this.mkt = mkt;
    }

    @Override
    public double calculateAvg() {
        return (acc * 2 + mkt) / 3;
    }

    @Override
    public String toString() {
        return "BizStudent{"
                + "id='" + getId() + '\''
                + ", fullName='" + getName() + '\''
                + ", address=" + getAddress().toString()
                + ", acc=" + acc
                + ", mkt=" + mkt
                + ", average=" + calculateAvg()
                + '}';
    }
}
