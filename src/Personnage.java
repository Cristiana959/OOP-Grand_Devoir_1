import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : Nae Sebastian-Ion
 * Sectia : IS
 * Grupa : 313AC
 */
public class Personnage extends Object {
    private String name;
    private int Health;
    private int MaxHealth;
    private int MaxCarry = 10;
    private int currentCarry = 0;
    public ArrayList<Object> objList = new ArrayList<>();
    private int AttackPower = 1;

    public int getAttackPower() {
        return AttackPower;
    }

    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    @Override
    public types getType() {
        return super.getType().PERSONAGE;
    }

    public Personnage(String name, int health, int maxHealth) {
        this.name = name;
        Health = health;
        MaxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        MaxHealth = maxHealth;
    }

    @Override
    public String getDescription() {
        if (MaxHealth > Health)
            return ("Name : " + getName() + " Health : " + getHealth() + " Max Health: " + getMaxHealth() + " Type :" + super.getType().PERSONAGE);
        else
            return "Error";
    }

    public String afficheInventarie() {
        String all_items = "";
        Map<Object, Integer> my_hash_map = new HashMap<Object, Integer>();

        for (Object obj : objList) {
            Integer number = my_hash_map.get(obj);
            my_hash_map.put(obj, (number == null) ? 1 : number + 1);
        }
        for (Map.Entry<Object, Integer> val : my_hash_map.entrySet()) {
            all_items += val.getKey().getDescription() + " X" + val.getValue() +" ";
        }
        return all_items;
    }

    public void showInventoryWithIndices()
    {
        for(int i=0;i<objList.size();i++)
        {
            System.out.println(i + " " + objList.get(i).getDescription());
        }
    }

    /*Doesn't work outputs ThrowException */
    /*v2 It works now*/
    public void ajouterObject(Object object) {
        try {
            if (currentCarry < MaxCarry) {
                objList.add(object);
            } else
                System.out.print("Too Many Items");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    /*Doesn't work outputs ThrowException*/
    /*v2 It works now*/
    public void retireObject(int numero) {
        try {
            objList.remove(numero);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    public Personnage() {
    }
}
