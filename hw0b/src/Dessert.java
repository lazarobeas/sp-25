public class Dessert {
    public int flavor, price;
    public static int numOfDesserts = 0;
    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numOfDesserts++;
    }
    public void printDessert() {
        System.out.print(flavor + " " + price + " " + numOfDesserts);
    }
    public static void main(String[] args) {
        System.out.println("I love dessert!");

    }
}
