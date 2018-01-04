/*package com.thinksys.bpm.utility;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import java.util.ArrayList;

import org.apache.flink.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		
		  JDBCInputFormat inputFormat = JDBCInputFormat.buildJDBCInputFormat()
				    .setDrivername("org.apache.derby.jdbc.EmbeddedDriver")
				    .setDBUrl(sqlserver)
				    .setUsername(username)
				    .setPassword(password)
				    .setQuery(query)
				    .finish();
	        
	        env.execute("Window WordCount");
	}
	  public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
	        @Override
	        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
	            for (String word: sentence.split(" ")) {
	                out.collect(new Tuple2<String, Integer>(word, 1));
	            }
	        }
	    }
}
*/