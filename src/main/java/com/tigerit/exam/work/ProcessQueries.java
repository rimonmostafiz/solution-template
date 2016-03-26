package com.tigerit.exam.work;

import com.tigerit.exam.container.querie.QueryInfo;
import com.tigerit.exam.container.table.Table;
import com.tigerit.exam.container.table.TableContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rimon Mostafiz on 3/25/2016.
 */

public class ProcessQueries {
    public QueryInfo queryInfo = new QueryInfo();

    public QueryInfo infoMaker(String[] queries, TableContainer tableContainer) {
        queryInfo = new QueryInfo();
        processSecondLine(queries[1].split(" "));
        processThirdLine(queries[2].split(" "));
        processFirstLine(queries[0], tableContainer);
        processLastLine(queries[3]);
        return queryInfo;
    }

    private void processFirstLine(String line, TableContainer tc) {
        String pattern = "[a-z\\_0-9]*\\.[a-z\\_0-9]*";
        List<String> ret = new ArrayList<String>();
        if (!line.endsWith("*")) {
            List<String> matchList = regexChecker(pattern, line);
            for (int i = 0; i < matchList.size(); i++) {
                ret.add(Table.getColByName(matchList.get(i)));
            }
        } else {
            ret.addAll(tc.getTable(queryInfo.getFirstTableName()).getColEntity());
            ret.addAll(tc.getTable(queryInfo.getSecondTableName()).getColEntity());
        }
        queryInfo.setResultingColList(ret);
    }

    private void processSecondLine(String[] split) {
        if (split.length > 2) {
            queryInfo.setFirstTableName(split[1]);
            queryInfo.setFirstTableShortName(split[2]);
        } else {
            queryInfo.setFirstTableName(split[1]);
        }
    }

    private void processThirdLine(String[] split) {
        if (split.length > 2) {
            queryInfo.setSecondTableName(split[1]);
            queryInfo.setSecondTableShortName(split[2]);
        } else {
            queryInfo.setSecondTableName(split[1]);
        }
    }

    private void processLastLine(String line) {
        String pattern = "[a-z\\_0-9]*\\.[a-z\\_0-9]*";
        List<String> matchList = regexChecker(pattern, line);
        String[] matchStr = new String[5];
        for (int i = 0; i < matchList.size(); i++) {
            matchStr[i] = (matchList.get(i));
        }
        queryInfo.setOperationMarker(makeOperationMarker(matchStr, queryInfo.getFirstTableShortName(), queryInfo.getSecondTableShortName()));
    }

    private String[] makeOperationMarker(String[] matchStr, String name1, String name2) {
        String[] ret = new String[4];
        String DOT = "\\.";
        if (name1 != null && name2 != null) {
            String[] parse = matchStr[0].split(DOT);
            ret[0] = Table.sAndLNameMp.get(parse[0]);
            ret[1] = parse[1];
            parse = matchStr[1].split(DOT);
            ret[2] = Table.sAndLNameMp.get(parse[0]);
            ret[3] = parse[1];
        } else {
            String[] parse = matchStr[0].split(DOT);
            ret[0] = parse[0];
            ret[1] = parse[1];
            parse = matchStr[1].split(DOT);
            ret[2] = parse[0];
            ret[3] = parse[1];
        }
        return ret;
    }

    private List<String> regexChecker(String theRegex, String str2Check) {
        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(str2Check);
        List<String> regList = new ArrayList<>();

        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                regList.add(regexMatcher.group().trim());
            }
        }
        return regList;
    }
}