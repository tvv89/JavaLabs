import javafx.scene.input.InputMethodTextRun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tvv89 on 08.02.2017 for JavaLabs.
 */
public class PostmanTrack {
   private TrackParameters mass[][];

    public PostmanTrack(TrackParameters[][] mass) {
        this.mass = mass;
    }
    public void Tracks(){
       // while(mass.length>1)
        printMass();
        System.out.println();
        {
            for (int i = 0; i <mass.length ; i++) {
                Integer minROW = min_of_row(mass,i);
                for (int j = 0; j <mass.length ; j++) {
                    if (i!=j) mass[i][j].setDistance(mass[i][j].getDistance()-minROW);
                }
            }

            printMass();
            System.out.println();
            for (int j = 0; j <mass.length ; j++) {
                Integer minCOL = min_of_col(mass,j);
                for (int i = 0; i < mass.length; i++) {
                    if (i!=j) mass[i][j].setDistance(mass[i][j].getDistance() - minCOL);
                }
            }
        }
        printMass();


    }
    public void printMass()
    {
        for (int i = 0; i <mass.length ; i++) {
            for (int j = 0; j <mass.length ; j++) {
                System.out.print(mass[i][j].getDistance()+"     ");
            }
            System.out.println();
        }
    }
    private Integer min_of_row(TrackParameters[][] massiv, int k)
    {
        Integer res=1000000000;
        for (int j = 0; j <massiv.length ; j++) {
            if (j!=k)
                if (massiv[k][j].getDistance()<res) res = massiv[k][j].getDistance();
        }
        return res;
    }
    private Integer min_of_col(TrackParameters[][] massiv, int k)
    {
        Integer res=1000000000;
        for (int j = 0; j <massiv.length ; j++) {
            if (j!=k)
                if (massiv[j][k].getDistance()<res) res = massiv[j][k].getDistance();
        }
        return res;
    }
    private Integer min_of_row_without(TrackParameters[][] massiv, int k, int l)
    {
        Integer res = 10000000;
        for (int i = 0; i <massiv.length ; i++) {
                if (i!=l && massiv[k][i].getDistance()<res) res = massiv[k][i].getDistance();
        }
        return res;
    }
    private Integer min_of_col_without(TrackParameters[][] massiv, int k, int l)
    {
        Integer res = 10000000;
        for (int j = 0; j <massiv.length ; j++) {
            if (j!=k && massiv[j][l].getDistance()<res) res = massiv[j][l].getDistance();
        }
        return res;
    }
    private Map<TrackParameters,Integer> grate_for_zero()
    {
        Map<TrackParameters,Integer> result = new HashMap<>();
        Integer res=0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j <mass.length ; j++) {
                 if (mass[i][j].getDistance()==0) {
                     res = min_of_col_without(mass,i,j)+min_of_row_without(mass,i,j);
                     result.put(mass[i][j],res);
                 }
            }
        }
        return result;
    }
}
