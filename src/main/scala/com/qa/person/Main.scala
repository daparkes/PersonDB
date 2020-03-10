package com.qa.person

import org.mongodb.scala._
import com.qa.person.Helpers._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._

object Main {
  def main(args: Array[String]): Unit = {
    val client: MongoClient = MongoClient("mongodb://localhost")
    val database: MongoDatabase = client.getDatabase("person")
    val collection: MongoCollection[Document] = database.getCollection(("test"))

    val person: Document = Document("first_name" -> "fred",
      "last_name" -> "durst", "age" -> 49)

    collection.insertOne(person).results()

    //collection.deleteOne(equal("first_name",
    //  "fred")).printHeadResult("Delete Result: ")
  }
}
