import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.Imports._
import scalaj.http._

object find extends App {
    val collection = MongoFactory.collection
    

    // find all pbdb_ocr
    //println("\n __All PBDB OCR__")
    //var pbdb = collection.find
    //pbdb.foreach(println)

    // Find with limit
    println("\n Find 2")
    //var pbdb = collection.findOne() match {
    //  case Some(result) => {
    //      var pbref = result.get("ref")
    //      for(name <- pbref("sci_names")) {
    //        var parts = name.split(" ")
    //        println("first part: " + parts(0))
    //      }
    //  }
    //  case None => println("Not Found")
    //}

    var pbdb = collection.find().limit(2)
    for (pb <- pbdb) {
       //println(pb)

       var ref = pb.get("ref")
       val dbref: MongoDbObject = DBObject(ref)

       val sci_names = dbref.as[DbObject]("sci_names")
       println("sci_names" + sci_names)

       //println("ref Class: " + ref.getClass)
       //println("ref: " + ref)

       //var sci_names = ref.get("sci_names")             
       //println("sci_names: " + sci_names)
       //for (name <- sci_names) {
       //    println("\nName: " + name)
       //}
    }

    // TODO:
    // Step through ref:sci_names [], break names on space
    // query IDB "scientiif_name": "parts[0]"

    
    // HTTP Request for iDigBio Data
    //val result = Http("https://search.idigbio.org/v2/search/records").postData("""{"order":"canidae"}""")
    //  .header("Content-Type", "application/json")
    //  .header("Charset", "UTF-8")
    //  .option(HttpOptions.readTimeout(10000)).asString


    //println("\n what did we get?")
    //println(result)
}
