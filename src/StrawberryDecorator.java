public class StrawberryDecorator implements IceDecorator {
    private IceDecorator iceDecorator;

    public StrawberryDecorator(IceDecorator iceDecorator){
        this.iceDecorator = iceDecorator;
    }

    @Override
    public void add(IceCream iceCream) {
        System.out.println("Strawberry added");

        if(iceDecorator != null)
            iceDecorator.add(iceCream);
    }
}
