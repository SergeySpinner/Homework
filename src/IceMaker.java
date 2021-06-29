public class IceMaker {

    private IceDecorator iceDecorator;

    public IceMaker(IceDecorator iceDecorator){
        this.iceDecorator = iceDecorator;
    }

    public IceCream make() {
        IceCream iceCream = new IceCream();
        iceDecorator.add(iceCream);
        return iceCream;
    }
}
