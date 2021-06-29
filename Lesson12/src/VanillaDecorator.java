public class VanillaDecorator implements IceDecorator{

    private IceDecorator iceDecorator;

    public VanillaDecorator(IceDecorator iceDecorator){
        this.iceDecorator = iceDecorator;
    }

    @Override
    public void add(IceCream iceCream) {
        System.out.println("Vanilla added");

        if(iceDecorator != null)
            iceDecorator.add(iceCream);
    }
}
