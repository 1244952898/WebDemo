import java.util.ArrayList;

/**
 * Created by zy on 2018-4-19.
 */
public class Composite implements Component {
    ArrayList<Component> list = new ArrayList<>();

    private String name;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void Add(Component component) {
        list.add(component);
    }

    @Override
    public void Remove(Component component) {
        list.remove(component);
    }

    @Override
    public Component Get(int i) {
        return list.get(i);
    }

    @Override
    public void KillVirus() {
        for (Component con :
                list) {
            con.KillVirus();
        }
    }
}
