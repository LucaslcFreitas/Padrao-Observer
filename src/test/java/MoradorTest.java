import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoradorTest {

    @Test
    void deveNotificarUmMorador() {
        DefesaCivil defesaCivil = new DefesaCivil("Sul", "Juiz de Fora");
        Morador morador = new Morador("Lucas");
        morador.cadastrar(defesaCivil);
        defesaCivil.lancarAlertaDeRisco();
        assertEquals("Lucas, alerta de risco lançada na DefesaCivil{Regiao='Sul', Cidade='Juiz de Fora'}", morador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMoradores() {
        DefesaCivil defesaCivil = new DefesaCivil("Norte", "Juiz de Fora");
        Morador morador1 = new Morador("Alice");
        Morador morador2 = new Morador("Carlos");
        morador1.cadastrar(defesaCivil);
        morador2.cadastrar(defesaCivil);
        defesaCivil.lancarAlertaDeRisco();
        assertEquals("Alice, alerta de risco lançada na DefesaCivil{Regiao='Norte', Cidade='Juiz de Fora'}", morador1.getUltimaNotificacao());
        assertEquals("Carlos, alerta de risco lançada na DefesaCivil{Regiao='Norte', Cidade='Juiz de Fora'}", morador2.getUltimaNotificacao());

    }

    @Test
    void naoDeveNotificarMorador() {
        DefesaCivil defesaCivil = new DefesaCivil("Leste", "Juiz de Fora");
        Morador morador = new Morador("Mariana");
        defesaCivil.lancarAlertaDeRisco();
        assertEquals(null, morador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMoradorRegiaoSul() {
        DefesaCivil defesaCivilSulJF = new DefesaCivil("Sul", "Juiz de Fora");
        DefesaCivil defesaCivilNorteJF = new DefesaCivil("Norte", "Juiz de Fora");
        Morador morador1 = new Morador("Matheus");
        Morador morador2 = new Morador("Carla");
        morador1.cadastrar(defesaCivilSulJF);
        morador2.cadastrar(defesaCivilNorteJF);
        defesaCivilSulJF.lancarAlertaDeRisco();
        assertEquals("Matheus, alerta de risco lançada na DefesaCivil{Regiao='Sul', Cidade='Juiz de Fora'}", morador1.getUltimaNotificacao());
        assertEquals(null, morador2.getUltimaNotificacao());
    }
}