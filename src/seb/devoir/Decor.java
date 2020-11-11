package seb.devoir;

public class Decor extends Element {
    public Decor() {
    }

    @Override
    public types getType() {
        return super.getType().DECOR;
    }
}
