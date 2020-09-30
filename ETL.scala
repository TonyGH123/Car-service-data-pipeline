//Load the data and count the number of times “United States” appear in file:
val sqlContext = new org.apache.spark.sql.SQLContext(sc) 
val df = sqlContext.read.format("csv").option("header", "true").option("inferSchema", "true").load("testData
.csv")  
df.filter(df("Country") === "United States").count()

//Load the same file as a DataFrame:
//	Calculate the total Price in the table
val total_price=df.select(col("Price")).map(_(0).asInstanceOf[Int]).reduce(_+_)
total_price: Int = 39600
//	Filter the country column for “United States”
val US=df.filter(df("Country") === "United States");
//	To the above dataframe, add a current date column as “load_date”
val currentdate= US.withColumn("load_date", current_date());

// To the above dataframe, add a new column as “new_Price” where you have divided the value Price column by 100
Val newprice=currentdate.withColumn("new_price",col("Price")/100);
//	Select the columns in the final data frame in this order:
// Column Order: "Account_Created", "Payment_Type", "State", "Country", "new_Price", "load_date"
val reorder=newprice.select("Account_Created", "Payment_Type", "State", "Country", "new_Price", "load_date");
