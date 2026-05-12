public class Rectangle {

    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return (width + height) * 2;
    }

    public boolean isSquare() {
        return width == height;
    }

    public static void main(String[] args) throws Exception {
        Rectangle rect1 = new Rectangle(5, 10);
        Rectangle rect2 = new Rectangle(7, 7);

        System.out.println("Dien tich hinh chu nhat 1: " + rect1.area());
        System.out.println("Chu vi hinh chu nhat 1: " + rect1.perimeter());
        System.out.println("Hinh chu nhat 1 co phai la hinh vuong? " + rect1.isSquare());
        System.out.println("----------------------");
        System.out.println("Dien tich hinh chu nhat 2: " + rect2.area());
        System.out.println("Chu vi hinh chu nhat 2: " + rect2.perimeter());
        System.out.println("Hinh chu nhat 2 co phai la hinh vuong? " + rect2.isSquare());
    }

}
