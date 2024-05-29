public class GoldenRetriever extends Dog{
    public void makeSound(){
        super.makeSound();
        System.out.println("I am a Golden Retriever");
    }
    public static void main(String[] args){
        Dog goldenRetriever = new GoldenRetriever();
        goldenRetriever.makeSound();
    }
}
