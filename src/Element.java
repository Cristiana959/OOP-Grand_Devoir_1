/** Author : Nae Sebastian-Ion
 * Sectia : IS
 * Grupa : 313AC*/
enum types{
    OBJECT,
    PERSONAGE,
    DECOR
}

public abstract class Element {
    private String description;
    private types type ;
    public String getDescription() {
        return description;
    }

    public Element() {
    }

    public types getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
