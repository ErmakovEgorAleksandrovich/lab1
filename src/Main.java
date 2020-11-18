
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        int i = 0;
        boolean cal, sort;  // случаи для спец параметров, начинающихся с дефиса
        cal = sort = false;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Сыр")) {
                breakfast[i] = new Cheese();
            } else if (parts[0].equals("Яблоко")) {
                breakfast[i] = new Apple(parts[1]);
            } else if (parts[0].equals("Кофе")) {
                breakfast[i] = new Coffee(parts[1]);
            } else if (parts[0].startsWith("-") && parts[1].equals("sort")) {
                sort = true;
                i--;

            } else if (parts[0].startsWith("-") && parts[1].equals("calories")) {
                cal = true;
                i--;
            } else {
                System.out.println("Cannot find class " + parts[0] + ".\nContinue...\n");
            }
            i++;
        }




        if(sort == true){
            Arrays.sort(breakfast, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    if (o1 == null) {
                        return 1;
                    }
                    else if (o2 == null) {
                        return -1;
                    }
                    else if (o1 instanceof Coffee && o2 instanceof Coffee) {
                        return -(((Coffee) o1).getNumber().compareTo(((Coffee) o2).getNumber()));
                    }
                    else if (o1 instanceof Apple && o2 instanceof Apple) {
                        return -(((Apple) o1).getSize().compareTo(((Apple) o2).getSize()));
                    }
                    else{
                        return 0;
                    }

                }
            });
        }
        for(int j =0; j<breakfast.length; j++) {
            if(breakfast[j]!=null)
                breakfast[j].consume();
            else break;
        }
        int counter = 0;

        Coffee check = new Coffee("насыщенный");
        Coffee check2 = new Coffee("горький");
        Coffee check3 = new Coffee("восточный");
        System.out.println("Аромат кофе " + ": ");
        for (int k = 0; k < breakfast.length; k++) {
            if (breakfast[k] != null) {
                if (breakfast[k].equals(check)) {
                    System.out.println(check.getNumber() + " ");
                }
                if(breakfast[k].equals(check2)){
                    System.out.println(check2.getNumber() + " ");
                }
                if(breakfast[k].equals(check3)){
                    System.out.println(check3.getNumber() + " ");
                }
                ;
            }
        }
        counter = 0;
        for (int j = 0; j < breakfast.length;j++){

            if (breakfast[j] != null){
                if (breakfast[j].equals(check2)){
                    counter++;
                }


            }
        }
        System.out.println("Количество чашек заданного типа " + "'" +check2.getName() + "'" +check2.getNumber()+ ": " + counter);
        counter = 0;
        for (int j = 0; j < breakfast.length;j++){

            if (breakfast[j] != null){
                if (breakfast[j].equals(check)){
                    counter++;
                }


            }
        }
        System.out.println("Количество чашек заданного типа " + "'" +check.getName() + "'" +check.getNumber()+ ": " + counter);
        counter = 0;
        for (int j = 0; j < breakfast.length;j++){

            if (breakfast[j] != null){
                if (breakfast[j].equals(check3)){
                    counter++;
                }


            }
        }
        System.out.println("Количество чашек заданного типа " + "'" +check3.getName() + "'" +check3.getNumber()+ ": " + counter);
        int calories = 0;

        if (cal == true){

            for (int j = 0; j < breakfast.length;j++){

                if (breakfast[j] != null){
                    calories += breakfast[j].calculateCalories();
                }
                else{
                    break;
                }
            }
            System.out.println("Каллории " + calories + '\n');
        }

    }
}
