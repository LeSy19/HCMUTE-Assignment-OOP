public class Rectangle {

    double width;
    double height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double side) {
        width = side;
        height = side;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public boolean isSquare() {
        return width == height;
    }

    public void displayInfo() {
        System.out.println("Hinh chu nhat: " + width + " x " + height);
        System.out.println("Dien tich: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
        System.out.println("Co phai la hinh vuong? " + isSquare());
    }

    public static void main(String[] args) throws Exception {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(7);
        Rectangle rect3 = new Rectangle(4, 4);

        System.out.println("Thong tin hinh chu nhat 1:");
        rect1.displayInfo();
        System.out.println("Thong tin hinh chu nhat 2:");
        rect2.displayInfo();
        System.out.println("Thong tin hinh chu nhat 3:");
        rect3.displayInfo();
    }

}
