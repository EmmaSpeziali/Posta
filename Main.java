public class Main {

    public static void main(String[] args) {
        ListaClienti listaClienti = new ListaClienti();
        Thread arriviThread = new Thread(new Arrivi(listaClienti));
        Thread sportelloThread = new Thread(new Sportello(listaClienti));
        arriviThread.start();
        sportelloThread.start();
    }
}