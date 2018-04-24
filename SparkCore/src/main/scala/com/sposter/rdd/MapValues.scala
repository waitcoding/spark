package com.sposter.rdd

import org.apache.spark.SparkContext
//同基本转换操作中的map，只不过mapValues是针对[K,V]中的V值进行map操作。
object MapValues {
  def main(args: Array[String]) {

    val sc = new SparkContext("local", "ReduceByKeyToDriver Test")
    val data1 = Array[(String, Int)](("K", 1), ("T", 2),
      ("T", 3), ("W", 4),
      ("W", 5), ("W", 6)
    )
    val pairs = sc.parallelize(data1, 3)
    //val result = pairs.reduce((A, B) => (A._1 + "#" + B._1, A._2 + B._2))
    //val result = pairs.fold(("K0",10))((A, B) => (A._1 + "#" + B._1, A._2 + B._2))
    //val result = pairs.partitionBy(new RangePartitioner(2, pairs, true))
    val result = pairs.mapValues(V => 10 * V)
    result.foreach(println)
  }
}