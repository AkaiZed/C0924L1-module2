package ss16_io_text_file.model;

public class ITStudent extends Student {

    private double java;
    private double css;

    public ITStudent(String id, String name, Address address, double java, double css) {
        super(id, name, address);
        this.java = java;
        this.css = css;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getCss() {
        return css;
    }

    public void setCss(double css) {
        this.css = css;
    }

    @Override
    public double calculateAvg() {
        return (3 * java + css) / 4;
    }

    @Override
    public String toString() {
        return "ITStudent{"
                + "id='" + getId() + '\''
                + ", fullName='" + getName() + '\''
                + ", address=" + getAddress().toString()
                + ", java=" + java
                + ", css=" + css
                + ", average=" + calculateAvg()
                + '}';
    }
}
