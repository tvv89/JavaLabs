package google.service.controller;

import google.service.entity.TrackParameters;

import java.util.*;

/**
 * Created by Admin on 10.03.2017.
 */
public class ControllerCollections {
    public ControllerCollections() {
    }
    public List<TrackParameters> Matrix_reduct(List<List<TrackParameters>> matrix)
    {
        List<TrackParameters> res = new ArrayList<>();
        while (matrix.size()>1)
        {
            PrintMatrix(matrix);
            for (int i = 0; i < matrix.size() ; i++) {
                int minRow = MinOfRow(matrix.get(i));
                matrix.get(i).forEach(a->a.setDistance(a.getDistance()-minRow));
            }
            for (int i = 0; i <matrix.size() ; i++) {
                int minCol = MinOfCol(matrix,i);
                for (int j = 0; j<matrix.size(); j++) {
                    TrackParameters tmp_tr = matrix.get(j).get(i);
                    tmp_tr.setDistance(tmp_tr.getDistance()-minCol);
                }
            }
            List<Integer> del = new ArrayList<>();
            del = MaxOfGrate(GrateOfZero(matrix));
            res.add(matrix.get(del.get(0).intValue()).get(del.get(1).intValue()));
            matrix.get(del.get(1)).get(del.get(0)).setDistance(10000000);
            matrix.remove(del.get(0).intValue());
            for (int i = 0; i <matrix.size() ; i++) {
                matrix.get(i).remove(del.get(1).intValue());
            }

            System.out.println();

        }
        return res;
    }
    private int MinOfRow(List<TrackParameters> row)
    {
        return row.stream().min(Comparator.comparing(TrackParameters::getDistance)).get().getDistance();
    }
    private int MinOfCol(List<List<TrackParameters>> AllCol, int col)
    {
        List<TrackParameters> tmp = new ArrayList<>();
        for (int i = 0; i <AllCol.size() ; i++) {
            tmp.add(AllCol.get(i).get(col));
        }
        return tmp.stream().min(Comparator.comparing(TrackParameters::getDistance)).get().getDistance();
    }
    public int MinOfRowWithoutCol(List<TrackParameters> row, int col)
    {
        List<TrackParameters> tmp = new ArrayList<>();
        tmp.addAll(row);
        tmp.remove(col);
        return tmp.stream().min(Comparator.comparing(TrackParameters::getDistance)).get().getDistance();
    }
    private int MinOfColWithoutRow(List<List<TrackParameters>> AllCol, int row)
    {
        List<TrackParameters> tmp = new ArrayList<>();
        for (int i = 0; i <AllCol.size() ; i++) {
            if (i!=row) tmp.add(AllCol.get(i).get(row));
        }
        return tmp.stream().min(Comparator.comparing(TrackParameters::getDistance)).get().getDistance();
    }
    private Map<List<Integer>,Integer> GrateOfZero(List<List<TrackParameters>> matrix)
    {
        Map<List<Integer>,Integer> result = new HashMap<>();
        Integer res=0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j <matrix.size() ; j++) {
                if (matrix.get(i).get(j).getDistance()==0) {
                    res = MinOfRowWithoutCol(matrix.get(i),j)+MinOfColWithoutRow(matrix,i);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.put(tmp,res);
                }
            }
        }
        return result;
    }
    public List<Integer> MaxOfGrate(Map<List<Integer>,Integer> input)
    {
        Integer res = input.values().stream().max(Integer::compareTo).get();
        for (Map.Entry<List<Integer>,Integer> pair : input.entrySet()) {
            if (res.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }
        return null;
    }
    public void PrintMatrix(List<List<TrackParameters>> matrix)
    {
        for (int i = 0; i <matrix.size() ; i++) {
            for (int j = 0; j <matrix.size() ; j++) {
                System.out.print(matrix.get(i).get(j).getDistance()+"     ");

            }
            System.out.println();
        }
    }
}
