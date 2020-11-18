
public class Apple extends Food {
    private String size;
    private Double calories = null;
    public Apple (String size) {
        super("Яблоко");
        this.size = size;
    }
    public Double calculateCalories()
    {
        if(size.equals("маленькое"))
        {
            calories = 100.0;
        }
        else if(size.equals("среднее"))
        {
            calories = 120.0;
        }
        else if(size.equals("большое"))
        {
            calories = 140.0;
        }
        else return 0.0;
        return calories;
    }
    public void consume(){

        System.out.println(this+ " съедено");
    }
    public String getSize() {

        return size;
    }
    public void setSize(String number) {
        this.size = size;
    }
    public boolean equals(Object arg0) {if(super.equals(arg0)) {
        if(!(arg0 instanceof Apple)) return false;
        return size.equals(((Apple)arg0).size);
    }
    else return false;
    }
    public String toString() {

        return super.toString() + " размера '"+ size.toUpperCase() + "'";
    }

}