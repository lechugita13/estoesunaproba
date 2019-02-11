/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proba;

/**
 *
 * @author vesprada
 */
public class Astro {

    private String nombre;
    private int tipo;
    private double brillo;
    private double distanciaAñosLuz;

    public final int ESTRELLA = 0;
    public final int NEBULOSA = 1;
    public final int GALAXYA = 2;

    public Astro() {

        nombre = "Sirius";
        tipo = 1;
        brillo = 1.42;
        distanciaAñosLuz = 8.7;

    }

    public Astro(String nombre, int tipo, double brillo, double distanciaAñosLuz) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.brillo = brillo;
        this.distanciaAñosLuz = distanciaAñosLuz;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getBrillo() {
        return brillo;
    }

    public void setBrillo(double brillo) {
        this.brillo = brillo;
    }

    public double getDistanciaAñosLuz() {
        return distanciaAñosLuz;
    }

    public void setDistanciaAñosLuz(double distanciaAñosLuz) {
        this.distanciaAñosLuz = distanciaAñosLuz;
    }

    @Override
    public boolean equals(Object obj) {
        //Primer verifico si el objeto recibido es un astro
        if (!(obj instanceof Astro)) {
            return false;
        } else {
            return this.nombre.equals(((Astro) obj).nombre) && this.brillo == ((Astro) obj).brillo && this.tipo == ((Astro) obj).tipo && this.distanciaAñosLuz == ((Astro) obj).distanciaAñosLuz;
        }

    }

    @Override
    public String toString() {
        String cadenaAretornar = "";
        switch (this.tipo) {

            case 0:
                cadenaAretornar = this.nombre + ":" + "ESTRELLA" + "(" + this.brillo + "," + this.distanciaAñosLuz + ")";
                return cadenaAretornar;

            case 1:
                cadenaAretornar = this.nombre + ":" + "GALAXIA" + "(" + this.brillo + "," + this.distanciaAñosLuz + ")";
                return cadenaAretornar;
            case 2:
                cadenaAretornar = this.nombre + ":" + "NEBULOSA" + "(" + this.brillo + "," + this.distanciaAñosLuz + ")";
                return cadenaAretornar;
            default:
                throw new AssertionError();
        }

    }

    public double maginitudAbsoulta() {

        double magnitud;

        magnitud = this.brillo + (5 * (Math.log(distanciaAñosLuz)));

        return magnitud;

        //return this.brillo + (5*(Math.log(distanciaAñosLuz)));
    }

    public int masBrillante(Astro rhea) {
        if (rhea.maginitudAbsoulta() == this.maginitudAbsoulta()) {
            return 0;
        } else if (rhea.maginitudAbsoulta() > this.maginitudAbsoulta()) {
            return 1;
        } else {
            return -1;
        }

    }

    public String visibleCon() {

        if (this.brillo < 5) {
            return "a simple vista";
        } else if (this.brillo >= 5 && this.brillo < 7) {
            return "con prismáticos";

        } else if (this.brillo >= 7 && this.brillo <= 25) {
            return "con telescopio";

        } else {
            return "con grandes telescopios";
        }
    }

}
