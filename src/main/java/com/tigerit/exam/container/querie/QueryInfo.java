package com.tigerit.exam.container.querie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rimon Mostafiz on 3/26/2016.
 */
public class QueryInfo {
    private String firstTableName = null;
    private String firstTableShortName = null;

    private String secondTableName = null;
    private String secondTableShortName = null;

    private List<String> resultingColList;
    private String[] operationMarker;

    public QueryInfo() {
        resultingColList = new ArrayList<String>();
    }

    public String getFirstTableName() {
        return firstTableName;
    }

    public void setFirstTableName(String firstTableName) {
        this.firstTableName = firstTableName;
    }

    public String getFirstTableShortName() {
        return firstTableShortName;
    }

    public void setFirstTableShortName(String firstTableShortName) {
        this.firstTableShortName = firstTableShortName;
    }

    public String getSecondTableName() {
        return secondTableName;
    }

    public void setSecondTableName(String secondTableName) {
        this.secondTableName = secondTableName;
    }

    public String getSecondTableShortName() {
        return secondTableShortName;
    }

    public void setSecondTableShortName(String secondTableShortName) {
        this.secondTableShortName = secondTableShortName;
    }

    public List<String> getResultingColList() {
        return resultingColList;
    }

    public void setResultingColList(List<String> resultingColList) {
        this.resultingColList = resultingColList;
    }

    public String[] getOperationMarker() {
        return operationMarker;
    }

    public void setOperationMarker(String[] operationMarker) {
        this.operationMarker = operationMarker;
    }
}