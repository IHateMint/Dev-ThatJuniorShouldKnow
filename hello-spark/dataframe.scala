val df = spark.read.option("header", "true").option("inferSchema", "true").csv("./corona/covid_19_data.csv")

df.printSchema()
df.show()

// map
val observationdate_mdy = df.select(col("ObservationDate")).map(row => row.getString(0))
val observationdate_ymd = observationdate_mdy.map(row => row.substring(6,10) + "/" + row.substring(0,2) + "/" + row.substring(3,5))
