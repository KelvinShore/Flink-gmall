package com.atguigu.flink.gmall0105.demo

import org.apache.flink.api.scala._

/**
  * Created by kelvin on 2019/7/3.
  */
object WordCount {

  //批处理wordcount
  def main(args: Array[String]): Unit = {

    //创建执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    //从文件中读取数据
    val inputPath="F:\\data\\flinkdata\\hello.txt"

    val inputDS: DataSet[String] = env.readTextFile(inputPath)

    //分词之后,对单词进行groupby 分组,然后用sum进行聚合
    val wordCountDS: AggregateDataSet[(String, Int)] = inputDS.flatMap(_.split(" ")).map((_,1)).groupBy(0).sum(1)

    //打印输出
    wordCountDS.print()








  }


}
