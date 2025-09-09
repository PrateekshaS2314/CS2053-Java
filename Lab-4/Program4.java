// Parent class: represents a complex number
class Complex {
    int real;
    int imag;

    // Constructor overloading
    Complex() {  // default constructor
        this.real = 0;
        this.imag = 0;
    }

    Complex(int r, int i) {  // parameterized constructor
        this.real = r;
        this.imag = i;
    }

    // Display method
    void display() {
        System.out.println(real + " + " + imag + "i");
    }
}

// Child class: operations on complex numbers
class ComplexOperations extends Complex {

    // Constructor using parent constructor
    ComplexOperations(int r, int i) {
        super(r, i);  // calls Complex(int r, int i)
    }

    // Method overloading for addition
    Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    Complex add(int r, int i) { // overloaded: add integers directly
        return new Complex(this.real + r, this.imag + i);
    }

    // Method overloading for subtraction
    Complex subtract(Complex c) {
        return new Complex(this.real - c.real, this.imag - c.imag);
    }

    Complex subtract(int r, int i) { // overloaded: subtract integers directly
        return new Complex(this.real - r, this.imag - i);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Using constructor overloading
        ComplexOperations c1 = new ComplexOperations(4, 5);
        Complex c2 = new Complex(2, 3);

        System.out.print("First complex number: ");
        c1.display();
        System.out.print("Second complex number: ");
        c2.display();

        // Addition using object
        Complex result1 = c1.add(c2);
        System.out.print("Addition result: ");
        result1.display();

        // Addition using integers (method overloading)
        Complex result2 = c1.add(1, 2);
        System.out.print("Addition with integers: ");
        result2.display();

        // Subtraction using object
        Complex result3 = c1.subtract(c2);
        System.out.print("Subtraction result: ");
        result3.display();

        // Subtraction using integers (method overloading)
        Complex result4 = c1.subtract(1, 1);
        System.out.print("Subtraction with integers: ");
        result4.display();
    }
}
