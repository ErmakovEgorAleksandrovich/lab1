
public class Coffee extends Food {
    private String aroma;
    private Double calories = null;
    public Coffee (String aroma) {
        super("Кофе");
        this.aroma = aroma;
    }

    public Double calculateCalories()
    {
        if(aroma.equals("насыщенный"))
        {
            calories = 100.0;
        }
        else if(aroma.equals("горький"))
        {
            calories = 200.0;
        }
        else if(aroma.equals("восточный"))
        {
            calories = 300.0;
        }
        else return 0.0;
        return calories;
    }
    public void consume(){
        System.out.println(this+ " съедено");
    }
    public String getNumber() {
        return aroma;
    }
    public void setNumber(String aroma) {
        this.aroma = aroma;
    }
    public boolean equals(Object arg0) {
        if(super.equals(arg0)) {
            if(!(arg0 instanceof Coffee)) return false;
            return aroma.equals(((Coffee)arg0).aroma);
        } else
            return false;
    }
    public String toString() {
        return super.toString() + " номера '"+ aroma.toUpperCase() + "'";
    }

}
