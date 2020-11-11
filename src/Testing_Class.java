import java.util.Random;

public class Testing_Class {
    public static void main(String[] args) {
        Random rng = new Random();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print("i " +rng.nextInt(7) + " j "+rng.nextInt(7));
            }
            System.out.println();
        }
    }
}
