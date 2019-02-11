/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proba;

import java.util.ArrayList;

/**
 *
 * @author vesprada
 */
public class CatalogoAstro {

    private String nombre;

    private ArrayList<Astro> listaAstros = new ArrayList<>();

    public CatalogoAstro() {
    }

    public CatalogoAstro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Astro> getListaAstros() {
        return listaAstros;
    }

    public void setListaAstros(ArrayList<Astro> listaAstros) {
        this.listaAstros = listaAstros;
    }

    @Override
    public String toString() {
        return this.nombre + ":" + this.listaAstros.size();
    }

    private int posicionDe(Astro a) {

        return this.listaAstros.indexOf(a);
    }

    private boolean esEstrellaSimpleVista(int i) {
        Astro astroElegido = listaAstros.get(i);

        return astroElegido.visibleCon().equals("a simple vista");
    }

    public boolean añade(Astro a) {

        for (int i = 0; i < listaAstros.size(); i++) {
            Astro astroElegido = listaAstros.get(i);

            if (astroElegido.equals(a)) {

                return true;

            }
        }
        this.listaAstros.add(a);
        return false;
    }

    public ArrayList<Astro> filtraEstrellasSimpleVista() {
        ArrayList<Astro> listaEstrellasSimpleVista = new ArrayList<>();

        for (int i = 0; i < listaEstrellasSimpleVista.size(); i++) {
            Astro astroElegido = listaEstrellasSimpleVista.get(i);

            if (astroElegido.visibleCon().equals("a simple vista")) {
                listaEstrellasSimpleVista.add(astroElegido);
            }
        }
        return listaEstrellasSimpleVista;
    }

    Astro brillaMas() {
        Astro astroCompara = listaAstros.get(0);

        for (int i = 0; i < listaAstros.size(); i++) {
            Astro astroElegido = listaAstros.get(i);

            if (astroElegido.masBrillante(astroCompara) == -1) {
                astroCompara = listaAstros.get(i);

            }

        }
        return astroCompara;
    }
}
