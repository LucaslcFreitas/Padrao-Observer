import java.util.Observable;
import java.util.Observer;

public class Morador implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Morador(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void cadastrar(DefesaCivil defesaCivil) {
        defesaCivil.addObserver(this);
    }

    @Override
    public void update(Observable defesaCivil, Object arg) {
        this.ultimaNotificacao = this.nome + ", alerta de risco lançada na " + defesaCivil.toString();
    }
}
