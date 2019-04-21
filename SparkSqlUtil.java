package com.packt.mytest;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.spark.sql.catalyst.parser.SqlBaseLexer;
import org.apache.spark.sql.catalyst.parser.SqlBaseParser;

public class SparkSqlUtil {
	   public static void main(String[] args){
		   String sql01 = "select abc,bcd from tbl where abc = 123";
		   test01(sql01);


	    }

    public static Map<String, Set<String>> getDataBaseTablenameAndOper(String sql){
        SqlBaseLexer lexer = new SqlBaseLexer(new ANTLRNoCaseStringStream(sql));

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokenStream);
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlBaseBaseListener mySqlBaseBaseListener = new MySqlBaseBaseListener();

        walker.walk(mySqlBaseBaseListener, parser.statement());

        return mySqlBaseBaseListener.getDataBaseTablenameAndOper();
    }

    public static void test01(String sql){
        SqlBaseLexer lexer = new SqlBaseLexer(new ANTLRNoCaseStringStream(sql));

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokenStream);



        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlBaseBaseListener mySqlBaseBaseListener = new MySqlBaseBaseListener();

        walker.walk(mySqlBaseBaseListener, parser.statement());
//        System.out.println(mySqlBaseBaseListener.toString());

//        System.out.println(parser.constantList());

    }

}