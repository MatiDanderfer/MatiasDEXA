import java.time.LocalDate;
import java.util.ArrayList;

public class Servicio {
    private String origen;
    private String destino;
    private LocalDate fechaViaje;
    private ArrayList<Asiento> asientos;
    private double costo;
   // private Transporte micro;

    public Servicio(String origen, String destino, LocalDate fechaViaje, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.costo = costo;
        asientos = new ArrayList<>();
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.add(asiento);
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public ArrayList<Asiento> getAsientos() {
        return (ArrayList<Asiento>)asientos.clone();
    }

    public double getCosto() {
        return costo;
    }
    public void setCosto(double c){
        costo = c;
    }

    public int getAsientosDisponibles(){
        int result = 0;
        for (int i = 0 ; i < asientos.size(); i++){
            if(asientos.get(i).isDisponible()){
                result++;
            }
        }
        return result;
    }
    public int getCantAsientos(){
        return asientos.size();
    }

    public void reservar(Pasajero p1){
        int i=0;
        while(i<asientos.size()){
            if(asientos.get(i).isDisponible()){
                asientos.get(i).reservar(p1);
                i=asientos.size();
            }
            i++;
        }
    }
}
