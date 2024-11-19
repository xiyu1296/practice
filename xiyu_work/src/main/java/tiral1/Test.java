package tiral1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.exit;

// 1. 定义接口 Shape
interface Shape {
    double area();
    double girth();
}

// 2. 定义圆形类 Circle 实现 Shape 接口
class Circle implements Shape {
    protected double radius;

    // 构造方法（重载）
    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // 求面积
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    // 求周长
    @Override
    public double girth() {
        return 2 * Math.PI * radius;
    }

    // 显示面积和周长
    public void show() {
        System.out.println("圆的面积: " + area());
        System.out.println("圆的周长: " + girth());
    }
}

// 3. 定义矩形类 Rectangle 实现 Shape 接口
class Rectangle implements Shape {
    protected double length;
    protected double width;

    // 构造方法（重载）
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // 求面积
    @Override
    public double area() {
        return length * width;
    }

    // 求周长
    @Override
    public double girth() {
        return 2 * (length + width);
    }

    // 显示面积和周长
    public void show() {
        System.out.println("矩形的面积: " + area());
        System.out.println("矩形的周长: " + girth());
    }
}

// 4. 定义圆柱体类 Cylinder 继承 Circle 类
class Cylinder extends Circle {
    private double height;

    // 构造方法（重载）
    public Cylinder(double radius, double height) {
        super(radius); // 调用父类 Circle 的构造方法
        this.height = height;
    }
    //创建圆柱体的空参构造，默认半径和高度为1.0
    public Cylinder() {
        super(1.0);

    }

    // 求体积
    public double volume() {
        return area() * height;
    }

    // 显示体积
    public void show() {
        System.out.println("圆柱体的底面积: " + area());
        System.out.println("圆柱体的体积: " + volume());
    }
}



// 6. 定义主类 Test


public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // 输入圆柱体的参数
                System.out.println("请输入圆形与圆柱体的半径: ");
                double radius = readDouble(scanner, "请输入有效的半径: ");
                System.out.println("请输入圆柱体的高度: ");
                double heightCylinder = readDouble(scanner, "请输入有效的高度: ");

                // 创建圆柱体对象
                Circle  circle= new Circle(radius);
                Cylinder cylinder = new Cylinder(radius, heightCylinder);

                // 输入长方体的参数
                System.out.println("请输入矩形的长度: ");
                double length = readDouble(scanner, "请输入有效的长度: ");
                System.out.println("请输入矩形的宽度: ");
                double width = readDouble(scanner, "请输入有效的宽度: ");

                //创建长方体对象
                Rectangle cuboid = new Rectangle(length, width);

                //调用圆柱体对象和长方体对象的show方法
                circle.show();
                cylinder.show();
                cuboid.show();

                System.out.println("输入0退出，输入其他继续");
                if(scanner.nextInt() == 0){
                    exit(0);
                }


            } catch (NoSuchElementException e) {
                System.out.println("输入流已结束，程序将退出。");
                break;
            } catch (Exception e) {
                System.out.println("发生未知错误: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static double readDouble(Scanner scanner, String errorMessage) {
        while (true) {
            try {
                if (scanner.hasNextDouble()) {
                    double k = scanner.nextDouble();
                    if(k<0){
                        throw new IllegalArgumentException("不能小于0");
                    }
                    return k;
                } else {
                    System.out.println("类型错误");

                    System.out.println(errorMessage);
                    scanner.next(); // 清除无效输入
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next(); // 清除无效输入
            }
        }
    }
}

