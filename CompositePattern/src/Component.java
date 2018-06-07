/**
 * Created by zy on 2018-4-19.
 */
public interface Component {
    public void Add(Component component);
    public void Remove(Component component);
    public Component Get(int i);
    public void KillVirus();
}
