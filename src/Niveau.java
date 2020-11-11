import java.util.ArrayList;
/** Author : Nae Sebastian-Ion
 * Sectia : IS
 * Grupa : 313AC*/
public class Niveau {
    Element[][] carte = new Element[10][10];
    private Personnage PJ;
    private String titre;

    public void setElement(int i, int j, Element element)
    {
        carte[i][j] = element;
    }

    public Element getElement(int i, int j)
    {
        return carte[i][j];
    }

    public void deleteElement(int i,int j)
    {
        carte[i][j] = null;
    }

    public String decritCarte(int i,int j)
    {
        Element element = carte[i][j];
        if(element == null)
            return "case vide";
        else
            return element.getDescription();
    }

    public Personnage getPersonnagePrincipal()
    {
        return PJ;
    }
    public String getTitre()
    {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Niveau(Personnage PJ) {
        this.PJ = PJ;
    }

    public Niveau() {
    }

}
