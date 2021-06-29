public class MainDriver {
    public static void main(String[] args) {
        IceMaker iceMaker = new IceMaker(new StrawberryDecorator(new VanillaDecorator(new CoconutDecorator(null))));

        System.out.println(iceMaker.make());
    }
}
