/**
 * Created by zy on 2018-4-16.
 */
public abstract class Burger implements IItem {
    @Override
    public IPacking GetPacking() {
        return new WrapperIPacking();
    }
}
