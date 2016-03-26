package com.tigerit.exam.work;

import com.tigerit.exam.container.querie.QueryInfo;
import com.tigerit.exam.container.table.Table;
import com.tigerit.exam.container.table.TableContainer;
import com.tigerit.exam.io.InputReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rimon Mostafiz on 3/26/2016.
 */
public class Solver {
    private TableContainer tableContainer;

    public void solve(InputReader inputReader) {
        int testCase = inputReader.nextInt();
        for (int tc = 1; tc <= testCase; tc++) {
            System.out.println("Test: " + tc);

            tableContainer = new TableContainer();
            int tableNumber = inputReader.nextInt();

            for (int tn = 1; tn <= tableNumber; tn++) {
                String tableName = inputReader.nextLine();
                int colNum = inputReader.nextInt();
                int rowNum = inputReader.nextInt();

                Table table = new Table(tableName, colNum, rowNum);
                int[][] data = new int[rowNum][colNum];
                List<String> colEntity = new ArrayList<String>(colNum);

                for (int i = 0; i < colNum; i++) {
                    String str = inputReader.next();
                    colEntity.add(str);
                    table.getColNameAndNumMp().put(str, i);
                }

                for (int i = 0; i < rowNum; i++) {
                    for (int j = 0; j < colNum; j++) {
                        data[i][j] = inputReader.nextInt();
                    }
                }
                table.setColEntity(colEntity);
                table.setData(data);
                tableContainer.addTable(table);
            }
            int numberOfQueries = inputReader.nextInt();
            String[] queries = new String[4];
            for (int i = 0; i < numberOfQueries; i++) {
                queries[0] = inputReader.nextLine(); // SELECT
                queries[1] = inputReader.nextLine(); // FROM
                queries[2] = inputReader.nextLine(); // JOIN
                queries[3] = inputReader.nextLine(); // IN
                inputReader.nextLine();
                ProcessQueries processor = new ProcessQueries();
                QueryInfo queryInfo = processor.infoMaker(queries, tableContainer);

                Operation newOperation = new Operation();
                Table resultTable = newOperation.Join(queryInfo, tableContainer);

                resultTable.printTable();
            }
        }
    }
}
