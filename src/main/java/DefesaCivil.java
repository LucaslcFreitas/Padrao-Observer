import java.util.Observable;

public class DefesaCivil extends Observable {

    private String regiao;
    private String cidade;

    public DefesaCivil(String regiao, String cidade) {
        this.regiao = regiao;
        this.cidade = cidade;
    }

    public void lancarAlertaDeRisco() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "DefesaCivil{"+
                "Regiao='"+regiao+"\'"+
                ", Cidade='"+cidade+"\'"+
                "}";
    }
}
