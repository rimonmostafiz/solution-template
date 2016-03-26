package com.tigerit.exam.container.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rimon Mostafiz on 3/25/2016.
 */
public class TableContainer {
    Map<String, Table> tableContainer;

    public TableContainer() {
        tableContainer = new HashMap<>();
    }

    public void addTable(Table table) {
        String name = table.getTableName();
        tableContainer.put(name, table);
    }

    public Table getTable(String tableName) {
        Table table = tableContainer.get(tableName);
        return table;
    }
}