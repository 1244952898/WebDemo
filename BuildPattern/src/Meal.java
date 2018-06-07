import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2018-4-16.
 */
public class Meal {
    private List<IItem> items=new ArrayList<>();

    public void AddItem(IItem iItem){
        items.add(iItem);
    }

    public void GetPrice(){
        if (items.size()>0){
            float totalPrice=0f;
            for (IItem item :
                    items) {
                System.out.println("订餐："+item.GetName()+" "+item.GetPacking().GetPacking()+" "+item.GetPrice());
                totalPrice+=item.GetPrice();
            }
            System.out.println("一共收费："+totalPrice);
        }else
            System.out.println("未添加任何事物！");
    }
}
