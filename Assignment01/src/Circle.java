public class Circle {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) throws Exception {
        Circle[] c = new Circle[5];

        c[0] = new Circle(1);
        c[1] = new Circle(9);
        c[2] = new Circle(2);
        c[3] = new Circle(4);
        c[4] = new Circle(5);

        double totalArea = 0;

        for (int i = 0; i < c.length; i++) {
            System.out.println("Dien tich: " + c[i].area());

            totalArea += c[i].area();
        }

        System.out.println("Tong dien tich: " + totalArea);
    }

}
