package com.example.herrdone.config.logging;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P6spyPrettySqlFormatter implements MessageFormattingStrategy {

    @Override
    public String formatMessage(
            int connectionId,
            String now,
            long elapsed,
            String category,
            String prepared,
            String sql,
            String url
    ) {
        String formatSql = formatSql(category, sql);
        Date curDate = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
        return format1.format(curDate) + " | " + "OperationTime : " + elapsed + "ms" + formatSql;
    }

    private String formatSql(String category, String sql){
        String reqsql = sql;
        if(reqsql == null || reqsql.trim() == ""){
            return reqsql;
        }

        if(Category.STATEMENT.getName().equals(category)){
            String tmpsql = reqsql.trim().toLowerCase();
            if(tmpsql.startsWith("create") || tmpsql.startsWith("alter") || tmpsql.startsWith("comment")){
                reqsql = FormatStyle.DDL.getFormatter().format(reqsql);
            } else {
                reqsql = FormatStyle.BASIC.getFormatter().format(reqsql);
            }
            reqsql = " | HeFormatSql(P6Spy sql,Hibernate format):\n" + reqsql + "\n";
        }
        return reqsql;
    }
}
