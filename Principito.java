// Definición de la clase
public class Principito {

    // Atributos de la clase
    private String actitud;
    private String apariencia;
    private String personalidad;
    private Flor miFlor;

    public Principito() {}

    // Constructor de la clase
    public Principito(String actitud, String apariencia, String personalidad,Flor miFlor) {
        this.actitud = actitud;
        this.apariencia = apariencia;
        this.personalidad = personalidad;
        this.miFlor=miFlor;
    }

    // Método para obtener la actitud
    public String getActitud() {
        return actitud;
    }

   
    //Obtengo la flor Getter
    public Flor getmiFlor() {
        return miFlor;
    }

    //Setter
    public void setMiFlor(Flor miFlor) {
        this.miFlor = miFlor;
    }

    

    // Método para establecer la actitud
    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    // Método para obtener la apariencia
    public String getApariencia() {
        return apariencia;
    }

    // Método para establecer la apariencia
    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }

    // Método para obtener la personalidad
    public String getPersonalidad() {
        return personalidad;
    }

    // Método para establecer la personalidad
    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public Flor getMiFlor(){
        return miFlor;
    }


}
