// RDD BASICS

val coronaRdd = sc.textFile("./corona/covid_19_data.csv")

// print rdd
coronaRdd.take(10).foreach(println)

// filter
val gansuRdd = coronaRdd.filter(line => line.contains("Gansu"))

// union
coronaRdd.union(gansuRdd)

// map

// flatMap
val lines = sc.parallelize(List("Hello Spark", "Hi"))
val words = lines.flatMap(line => line.split(" "))

// distinct
words.distinct().foreach(println)

// intersection, subtract
val sampleRdd1 = sc.parallelize(List("coffee", "tea", "milk"))
val sampleRdd2 = sc.parallelize(List("water", "coffee", "coke"))
sampleRdd1.intersection(sampleRdd2).foreach(println)
sampleRdd1.subtract(sampleRdd2).foreach(println)

// collect
sampleRdd1.collect()

// countByValue
sampleRdd1.countByValue()

// reduce
val data = sc.parallelize(List(1,2,3,4,4))
data.reduce((x,y) => x+y)
data.reduce(_+_)

// RDD key value examples
val lines = sc.parallelize(List("holden likes coffee","panda likes long strings and coffee"))
val pair = lines.map(row => (row.split(" ")(0), row))
pair.first()
pair.filter{case(key, value) => value.length>20}.first()

// reduceByKey: group key-value pair RDD with same keys, make value group,
// and reduce (sum, max, min)
// whatever the sequence is, thereshould be coherent result.
val sampleData = Seq(("a", 3), ("b", 4), ("a", 1))
sc.parallelize(sampleData).reduceByKey((x,y)=>x+y).take(2)

// combineByKey