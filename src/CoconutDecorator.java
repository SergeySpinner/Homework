public class CoconutDecorator implements IceDecorator{
    private IceDecorator iceDecorator;

    public CoconutDecorator(IceDecorator iceDecorator){
        this.iceDecorator = iceDecorator;
    }

    @Override
    public void add(IceCream iceCream) {
        System.out.println("Coconut added");

        if(iceDecorator != null)
            iceDecorator.add(iceCream);
    }
}
