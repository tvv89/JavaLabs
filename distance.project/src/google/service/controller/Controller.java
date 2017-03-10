package google.service.controller;

import google.service.entity.TrackParameters;

import java.util.*;

/**
 * Created by tvv89 on 08.02.2017 for JavaLabs.
 */
public class Controller {
   private TrackParameters mass[][];
   public List<TrackParameters> result_track;

    public Controller(TrackParameters[][] mass) {
        this.mass = mass;
    }

    public void Tracks()
    {
        List<TrackParameters> tmp_track= new ArrayList<>();
        while(mass.length>1) {
            printMass();
            System.out.println();
            {
                for (int i = 0; i < mass.length; i++) {
                    Integer minROW = min_of_row(mass, i);
                    for (int j = 0; j < mass.length; j++) {
                        if (i != j) mass[i][j].setDistance(mass[i][j].getDistance() - minROW);
                    }
                }
                printMass();
                System.out.println();
                for (int j = 0; j < mass.length; j++) {
                    Integer minCOL = min_of_col(mass, j);
                    for (int i = 0; i < mass.length; i++) {
                        if (i != j) mass[i][j].setDistance(mass[i][j].getDistance() - minCOL);
                    }
                }
            }
            printMass();
            TrackParameters[][] mass_tmp = new TrackParameters[mass.length - 1][mass.length - 1];
            int k = 0;
            int l = 0;
            Integer del_row = max_of_grade(grate_for_zero()).get(0);
            Integer del_col = max_of_grade(grate_for_zero()).get(1);
            tmp_track.add(mass[del_row][del_col]);
            for (int i = 0; i < mass.length; i++) {
                if (i != del_row) {
                    l = 0;
                    for (int j = 0; j < mass.length; j++) {
                        if (j != del_col) {
                            mass_tmp[k][l] = mass[i][j];
                            if (i == del_col && j == del_row) mass_tmp[k][l].setDistance(10000000);
                            l++;
                        }
                    }
                    k++;
                }
            }
            mass = mass_tmp;
            System.out.println();
            printMass();
            System.out.println();
        }
        tmp_track.add(mass[0][0]);
        result_track=tmp_track;
    }
    public void printMass()
    {
        for (int i = 0; i <mass.length ; i++) {
            for (int j = 0; j <mass.length ; j++) {
                System.out.print(mass[i][j].getDistance()+";");
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
    public Map<List<Integer>,Integer> grate_for_zero()
    {
        Map<List<Integer>,Integer> result = new HashMap<>();
        Integer res=0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j <mass.length ; j++) {
                 if (i!=j && mass[i][j].getDistance()==0) {
                     res = min_of_col_without(mass,i,j)+min_of_row_without(mass,i,j);
                     List<Integer> tmp = new ArrayList<>();
                     tmp.add(i);
                     tmp.add(j);
                     result.put(tmp,res);
                 }
            }
        }
        return result;
    }
    public List<Integer> max_of_grade(Map<List<Integer>,Integer> input)
    {
        Integer res = input.values().stream().max(Integer::compareTo).get();
        for (Map.Entry<List<Integer>,Integer> pair : input.entrySet()) {
            if (res.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        return null;
    }
    public List<TrackParameters> sorted_track(String first)
    {
        List<TrackParameters> tmp = new ArrayList<>();
        Optional<TrackParameters> remove_object = result_track.stream()
                .filter(a -> a.getOrigin().equals(first))
                .findFirst();
        tmp.add(remove_object.get());
        result_track.remove(remove_object.get());
        while (!result_track.isEmpty()) {
            remove_object = result_track.stream().filter(a -> a.getOrigin()
                    .contains(tmp.get(tmp.size()-1)
                            .getDestination())).findFirst();
            tmp.add(remove_object.get());
            result_track.remove(remove_object.get());
        }
        return tmp;
    }
}
