package com.tigerit.exam.container.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rimon Mostafiz on 3/24/2016.
 */
public class Table {
    public static Map<String, String> sAndLNameMp;
    private int[][] data;
    private int colNum;
    private int rowNum;
    private String tableName;
    private List<String> colEntity;
    private Map<String, Integer> colNameAndNumMp;

    public Table() {
        sAndLNameMp = new HashMap<String, String>();
        colNameAndNumMp = new HashMap<String, Integer>();
    }

    public Table(String tableName, int colNum, int rowNum) {
        this.colNum = colNum;
        this.rowNum = rowNum;
        this.tableName = tableName;
        sAndLNameMp = new HashMap<String, String>();
        colNameAndNumMp = new HashMap<String, Integer>();
    }

    public static String getColByName(String s) {
        String st[] = s.split("\\.");
        return st[1];
    }

    public void mapTableName(String tableFullName, String tableShortName) {
        this.sAndLNameMp.put(tableShortName, tableFullName);
    }

    public void printTable() {
        for (int x = 0; x < getColEntity().size(); x++) {
            if (x == 0) System.out.print(getColEntity().get(x));
            else {
                System.out.print(" " + getColEntity().get(x));
            }
        }
        System.out.println();
        for (int[] row : getData()) {
            for (int x = 0; x < row.length; x++) {
                if (x == 0) System.out.print(row[x]);
                else {
                    System.out.print(" " + row[x]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public List<String> getColEntity() {
        return colEntity;
    }

    public void setColEntity(List<String> colEntity) {
        this.colEntity = colEntity;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Integer> getColNameAndNumMp() {
        return colNameAndNumMp;
    }
}