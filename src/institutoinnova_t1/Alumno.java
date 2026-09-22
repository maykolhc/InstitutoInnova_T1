package institutoinnova_t1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class Alumno {
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private char nivelSocioeconomico;
    private String tipoBeca;

    public Alumno() {
    }

    public Alumno(String nombre, String tipoDocumento, String numeroDocumento, char nivelSocioeconomico, String tipoBeca) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nivelSocioeconomico = nivelSocioeconomico;
        this.tipoBeca = tipoBeca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public char getNivelSocioeconomico() {
        return nivelSocioeconomico;
    }

    public void setNivelSocioeconomico(char nivelSocioeconomico) {
        this.nivelSocioeconomico = nivelSocioeconomico;
    }

    
    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        if (tipoBeca == null) {
            throw new IllegalArgumentException(
                    "La beca es obligatoria.");
        }

        if (!tipoBeca.equalsIgnoreCase("NINGUNA")
                && !tipoBeca.equalsIgnoreCase("PARCIAL")
                && !tipoBeca.equalsIgnoreCase("TOTAL")) {

            throw new IllegalArgumentException(
                    "La beca debe ser NINGUNA, PARCIAL o TOTAL.");
        }
        this.tipoBeca = tipoBeca.toUpperCase();
    }
    
    //Metodo para pension
    public double calcularPension(double tarifaBase) {

        if (tipoBeca.equals("PARCIAL")) {
            return tarifaBase * 0.50;
        }

        if (tipoBeca.equals("TOTAL")) {
            return 0;
        }

        return tarifaBase;
    }
    
    // Método para obtener la tarifa 
    public double obtenerTarifaBase() {

        switch (nivelSocioeconomico) {

            case 'A':
                return 500.00;

            case 'B':
                return 350.00;

            case 'C':
                return 250.00;

            default:
                return 0;
        }
    }
    
    @Override
    public String toString() {

        double tarifaBase = obtenerTarifaBase();
        double pensionFinal = calcularPension(tarifaBase);

        return "\nNombre: " + nombre
                + "\nTipo de documento: " + tipoDocumento
                + "\nNúmero de documento: " + numeroDocumento
                + "\nNivel socioeconómico: " + nivelSocioeconomico
                + "\nTipo de beca: " + tipoBeca
                + "\nTarifa base: S/ " + tarifaBase
                + "\nPensión final: S/ " + pensionFinal;
    }
}
