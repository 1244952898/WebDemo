/**
 * Created by zy on 2018-4-16.
 */
public class BuilderPatternDemo {
    //Item
    //午餐 Meal
    //食物包装Packing Wrapper Bottle
    //冷饮（Cold drink）
    //可口可乐（coke）
    // 百事可乐（pepsi
    //汉堡（Burger）
    //素食汉堡（Veg Burger）
    // 鸡肉汉堡（Chicken Burger）
    public static void main(String[] args) {
        System.out.println("开始==================:输入订单1");
        Meal meal1=new Meal();
        meal1.AddItem(new ChickenBurger());
        meal1.AddItem(new CokeDrink());
        meal1.GetPrice();

        System.out.println("开始==================:输入订单2");
        Meal meal2=new Meal();
        meal2.AddItem(new VegBurger());
        meal2.AddItem(new ChickenBurger());
        meal2.AddItem(new PepsiDrink());
        meal2.AddItem(new PepsiDrink());
        meal2.GetPrice();
    }
}
