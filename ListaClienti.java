import java.util.ArrayList;

public class ListaClienti {

    private final ArrayList<Integer> listaNumeri;
    private int ultimoArrivo;
    private int ultimoServito;
    private final int numeroMassimo = 100;

    public ListaClienti() {
        listaNumeri = new ArrayList<>();
        ultimoArrivo = 0;
        ultimoServito = 0;
    }

    public synchronized Integer rimuoviCliente() throws InterruptedException {
        while (ultimoServito >= ultimoArrivo)
            wait();
        ultimoServito++;
        return ultimoServito;
    }

    public synchronized Integer addCliente() {
        if (ultimoArrivo < numeroMassimo) {
            ultimoArrivo++;
            listaNumeri.add(ultimoArrivo);
            notifyAll();
            return ultimoArrivo;
        }
        return null;
    }
}