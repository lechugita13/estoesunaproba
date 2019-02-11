/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proba;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vesprada
 */
public class TestCatalogo {

    public static void main(String[] args) {
        CatalogoAstro catalogo = new CatalogoAstro("Catálogo");
        Scanner entrada = new Scanner(System.in);
        int OPC;
        do {
            System.out.println("3.-Introducir Astros. Pedirá el nombre, el tipo, el brillo y la distancia.");
            System.out.println("4.-Visualizar el catálogo");
            System.out.println("5.-Visualizar las estrellas visibles a simple vista");
            System.out.println("6.-Muestra el Astro más brillante ");
            System.out.println("7.-Dado el nombre de un Astro devuelvo uno que brilla más que él.");
            OPC = entrada.nextInt();
            switch (OPC) {
                case 3:
                    Astro astroUsuario = new Astro();
                    System.out.println("Introduece el nombre de tu estrella");
                    astroUsuario.setNombre(entrada.next());
                    System.out.println("Introduece el tipo de tu astro");
                    astroUsuario.setTipo(entrada.nextInt());
                    System.out.println("Introduece el brillo de tu estrella");
                    astroUsuario.setBrillo(entrada.nextDouble());
                    System.out.println("Introduece la distancia en años luz de tu estrella");
                    astroUsuario.setDistanciaAñosLuz(entrada.nextDouble());
                    catalogo.añade(astroUsuario);

                    System.out.println("Los valores del astro son " + astroUsuario.toString());
                    break;
                case 4:

                    System.out.println(catalogo.toString());
                    for (int i = 0; i < catalogo.getListaAstros().size(); i++) {
                        System.out.println(catalogo.getListaAstros().get(i));

                    }

                    break;
                case 5:
                    ArrayList<Astro> listaAstro;

                    listaAstro = catalogo.filtraEstrellasSimpleVista();

                    for (int i = 0; i < listaAstro.size(); i++) {
                        System.out.println(listaAstro.get(i).toString());

                    }

                    break;
                case 6:

                    Astro astroBrillaMas;

                    astroBrillaMas = catalogo.brillaMas();

                    break;
                case 7:
                    Astro astroBrilla = new Astro();
                    System.out.println("Introduece el nombre de tu estrella");
                    String nombre;
                    nombre = entrada.next();
                    for (int i = 0; i < catalogo.getListaAstros().size(); i++) {
                        if (nombre.equals(catalogo.getListaAstros().get(i).getNombre())) {
                            astroBrilla = catalogo.getListaAstros().get(i);
                            break;
                        }

                    }

                    for (int i = 0; i < catalogo.getListaAstros().size(); i++) {

                        if (astroBrilla.masBrillante(catalogo.getListaAstros().get(i)) == 1) {
                            astroBrilla = catalogo.getListaAstros().get(i);
                            break;
                        }

                    }
                    System.out.println("este es el astro mas brillante: " + astroBrilla.getNombre());

                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

}
