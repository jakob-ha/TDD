package utils;

public class Calculator implements HasAName {
    private String injectedName;
    private final String constructorName;

    public Calculator(String constructorName){
        this.constructorName = constructorName;
    }

    @Override
    public void injectName(String injectedName) {
        this.injectedName = injectedName;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mul(int a, int b) {
        return a*b;
    }

    public int div(int a, int b) {
        if(b == 0){
            throw new ArithmeticException("Division by zero");
        }
        return 5;
    }
}
