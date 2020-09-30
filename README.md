# Car-service-data-pipeline
Build a data pipeline using AWS and Spark

### AWS Architecture
**S3 -- EMR -- GLUE -- Redshift -- SNS**

### Overview
Use this data pipeline to grab the data from car dealers. Do ELT on this data and move the clean data to data warehouse Redshift.

### ETL Flow
* Copied shared S3 bucket from different Subaru retailer, and landed them in a Private S3 bucket sorted by dates and copied S3 data into Amazon EMR using Spark and Scala.
*	Used Spark to build ETL and to land the data into Amazon Glue table from cluster.
*	Inserted the data into the Amazon Redshift table from the Glue table, managed ETL service that makes it easy to prepare and load their data for analytics.
*	Used Amazon Redshift table as Data warehouse, which contain pure data for data analysis and data reporting.

### Scenarios
* DAG start at 7AM daily.
* Clean and do ETL on data every morning.
* Start data analysis and data reporting at 2PM.
