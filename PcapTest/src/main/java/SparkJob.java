import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.pcap4j.core.PcapPacket;

import java.util.List;

public class SparkJob {
    public static void initialize(List<PcapPacket> packets) {
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaSparkContext sparkContext = new JavaSparkContext(conf);
////        JavaPairDStream<PcapPacket,Integer> packetJavaRDD = JavaPairDStream.fromJavaDStream(Stream.of(packets));
////        packetJavaRDD.filter(pc -> pc.length()>100);
//        System.out.println( packetJavaRDD.toString());
//        packetJavaRDD.();
    }

}
