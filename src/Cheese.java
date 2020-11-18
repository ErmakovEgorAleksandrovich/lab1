

public class Cheese extends Food {
    public Cheese(){
        super("Сыр");
    }
    public void consume() {
        System.out.println(this+ " съеден");
    }
    public Double calculateCalories()
    {
        calories = 100.0;
        return calories;
    }
}