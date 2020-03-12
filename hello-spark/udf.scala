// Using UDF will make us lose up all the optimization Spark does on our Dataframe and Dataset.

// UDF example
import org.apache.spark.sql.functions.{col, udf}

val sampleData = spark.createDataFrame(Seq(
                    (1, "Chandler", "Pasadena", "US"),
                    (2, "Monica", "New york", "USa"),
                    (3, "Phoebe", "Suny", "USA"),
                    (4, "Rachael", "St louis", "United states of America"),
                    (5, "Joey", "LA", "Ussaa"),
                    (6, "Ross", "Detroit", "United states")
                )).toDF("id", "name", "city", "country")

def cleanCountry(country: String) => {
    val allUSA = Seq("US", "USa", "USA", "United states", "United states of America")
    if (allUSA.contains(country)) {
        "USA"
    }
    else {
        "unknown"
    }
}

val countryNormalize = spark.udf.register("countryNormalized", cleanCountry)

val newdf = sampleData.withColumn("countryNormalized", countryNormalize(col("country")))
newdf.show()
