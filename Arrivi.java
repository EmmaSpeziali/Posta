public class Arrivi implements Runnable {

    private final ListaClienti listaClienti;
    private final int attesaArrivi = 2000;

    public Arrivi(ListaClienti listaClienti) {
        this.listaClienti = listaClienti;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(attesaArrivi);
                Integer clienteArrivato = listaClienti.addCliente();
                if (clienteArrivato == null) break;
                System.out.println("Arrivo Cliente Numero \t " + clienteArrivato);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Posta Chiusa");
        }
    }
}