package com.tigerit.exam.work;

import com.tigerit.exam.container.querie.QueryInfo;
import com.tigerit.exam.container.table.Table;
import com.tigerit.exam.container.table.TableContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rimon Mostafiz on 3/25/2016.
 */
public class Operation {

    public Table Join(QueryInfo qInfo, TableContainer tContainer) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        Table table1 = tContainer.getTable(qInfo.getFirstTableName());
        Table table2 = tContainer.getTable(qInfo.getSecondTableName());

        int[][] data1 = table1.getData();
        int[][] data2 = table2.getData();

        int c1 = table1.getColNameAndNumMp().get(qInfo.getOperationMarker()[1]);
        int c2 = table2.getColNameAndNumMp().get(qInfo.getOperationMarker()[3]);

        for (int i = 0; i < table1.getRowNum(); i++) {
            list1.add(data1[i][c1]);
        }
        for (int i = 0; i < table2.getRowNum(); i++) {
            list2.add(data2[i][c2]);
        }

        int[][] data;
        Table resultTable = new Table();
        resultTable.setColEntity(qInfo.getResultingColList());

        List<int[]> tmp = new ArrayList<int[]>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    int c[] = onlyResCol(data1[i], data2[j], table1, table2, resultTable);
                    tmp.add(c);
                }
            }
        }

        data = new int[tmp.size()][qInfo.getResultingColList().size()];

        for (int i = 0; i < tmp.size(); i++) {
            data[i] = tmp.get(i);
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                for (int i = 0; i < a.length && i < b.length; i++)
                    if (a[i] != b[i])
                        return a[i] - b[i];
                return a.length - b.length;
            }
        });
        resultTable.setData(data);
        return resultTable;
    }

    public int[] onlyResCol(int[] data1, int[] data2, Table table1, Table table2, Table resultTable) {
        List<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < resultTable.getColEntity().size(); i++) {
            String s1 = resultTable.getColEntity().get(i);
            for (int j = 0; j < table1.getColEntity().size(); j++) {
                String s2 = table1.getColEntity().get(j);
                if (s1.equals(s2)) {
                    lst.add(data1[table1.getColNameAndNumMp().get(s2)]);
                }
            }

            for (int j = 0; j < table2.getColEntity().size(); j++) {
                String s2 = table2.getColEntity().get(j);
                if (s1.equals(s2)) {
                    lst.add(data2[table2.getColNameAndNumMp().get(s2)]);
                }
            }
        }

        int[] ret = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ret[i] = lst.get(i);
        }
        return ret;
    }
}