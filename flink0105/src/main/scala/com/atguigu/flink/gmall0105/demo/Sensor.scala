package com.atguigu.flink.gmall0105.demo

import org.apache.flink.streaming.api.scala._
/** 从集合读取数据
  * Created by kelvin on 2019/7/3.
  */
case class SensorReading(id:String,timestamp:Long,temperature:Double)
object Sensor {

  def main(args: Array[String]): Unit = {

    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val stream1 = env
      .fromCollection(List(
        SensorReading("sensor_1", 1547718199, 35.80018327300259),
        SensorReading("sensor_6", 1547718201, 15.402984393403084),
        SensorReading("sensor_7", 1547718202, 6.720945201171228),
        SensorReading("sensor_10", 1547718205, 38.101067604893444)
      ))

    stream1.print("stream1:").setParallelism(1)

   // val stream2=env.readFile("sensor.txt");


    env.execute()













  }






}
