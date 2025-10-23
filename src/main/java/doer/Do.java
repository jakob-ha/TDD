package doer;

public class Do implements HasAName {
    String injectedName;
    String constructorName;

    public Do(String constructorName){
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
/*
    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

 */
}
