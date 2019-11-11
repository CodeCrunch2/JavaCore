package main.java.com.mkudriavtsev.javacore.chapter13;
//Плохое применение оператора assert!!!
class AssertDemo2 {
    static int val = 3;
    static int getnum() {
        return val--;
    }

    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i < 10; i++) {
            assert (n = getnum()) > 0; // bad idea!
            System.out.println("n равно " + n);

        }
    }
}
