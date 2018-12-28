package studio.visualdust.product.Randomer.method;

public class Randomer {
    public Randomer() {
    }

    public static int getRand(int left, int right) {
        int lenth = (right - left) * ((right - left) < 0 ? -1 : 1);
        int sub = (int) (Math.random() * lenth);
        return right - sub;
    }

    public static void main(String[] args) {
        Randomer randomer = new Randomer();
        //test
        for (int i = 0; i < 10; i++) {
            System.out.println(randomer.getRand(-2, 5));
        }
    }
}
