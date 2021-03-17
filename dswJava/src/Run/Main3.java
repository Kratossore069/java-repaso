package Run;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.PartidoFutbol;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<PartidoFutbol> equipos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PartidoFutbol pf = new PartidoFutbol();
            pf.setEquipoLocal("Tenerife");
            pf.setEquipoVisitante("Madrid");
            pf.setGolesLocal(5);
            pf.setGolesVisitante(2);
            equipos.add(pf);
        }

        Iterator<PartidoFutbol> it=equipos.iterator();
        while(it.hasNext()){
            PartidoFutbol partido=it.next();
            System.out.println(partido.getEquipoLocal()+" "+
            partido.getEquipoVisitante()+" "+
            partido.getGolesLocal()+" "+
            partido.getGolesVisitante());
        }
    }
}
