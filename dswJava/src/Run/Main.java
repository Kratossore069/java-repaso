package Run;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Main {
    public static void main(String[] args) {

        String mochila[] = { "Manzanas", "Peras", "Plátanos" };
        String marcas[]={"Alcampo","Mercadona","Hiperdino"};
        for(int i=0; i<mochila.length; i++){
            System.out.println(mochila[i]);
            for(int z=0; z<marcas.length; z++){
                System.out.println(marcas[z]);
            }
        }
    }
}
