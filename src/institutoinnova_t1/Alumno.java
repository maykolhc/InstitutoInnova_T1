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

    //nombre s y g
    public void setNombre(String nombre) {
         if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    //tipo doc
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        if (tipoDocumento == null) {
            throw new IllegalArgumentException(
                    "El tipo de documento es obligatorio");
        }

        if (!tipoDocumento.equalsIgnoreCase("DNI")
                && !tipoDocumento.equalsIgnoreCase("RESIDENCIA")) {

            throw new IllegalArgumentException(
                    "El tipo de documento debe ser DNI o RESIDENCIA.");
        }

        this.tipoDocumento = tipoDocumento.toUpperCase();
    }

    //identidad
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
         if (numeroDocumento == null ||
                !numeroDocumento.matches("\\d+")) {

            throw new IllegalArgumentException(
                    "El documento debe contener solamente numero");
        }

        if (tipoDocumento.equals("DNI")
                && numeroDocumento.length() != 8) {

            throw new IllegalArgumentException(
                    "El DNI debe tener 8 dijitos");
        }

        if (tipoDocumento.equals("RESIDENCIA")
                && numeroDocumento.length() != 11) {

            throw new IllegalArgumentException(
                    "La Residencia Temporal debe tener exactamente 11 digitos");
        }

        this.numeroDocumento = numeroDocumento;
    }

    //socieco...
    public char getNivelSocioeconomico() {
        return nivelSocioeconomico;
    }

    public void setNivelSocioeconomico(char nivelSocioeconomico) {
        nivelSocioeconomico =
                Character.toUpperCase(nivelSocioeconomico);

        if (nivelSocioeconomico != 'A'
                && nivelSocioeconomico != 'B'
                && nivelSocioeconomico != 'C') {

            throw new IllegalArgumentException(
                    "El nivel socioeconómico debe ser A, B o C.");
        }

        this.nivelSocioeconomico = nivelSocioeconomico;
    }

    //tipobeca
    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        if (tipoBeca == null) {
            throw new IllegalArgumentException(
                    "La beca es obligatoria");
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
                + "\nNumero de documento: " + numeroDocumento
                + "\nNivel socioeconómico: " + nivelSocioeconomico
                + "\nTipo de beca: " + tipoBeca
                + "\nTarifa base: S/ " + tarifaBase
                + "\nPensión final: S/ " + pensionFinal;
    }
}
