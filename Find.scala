import com.mongodb.casbah.Imports._
import scalaj.http._

object find extends App {

    val collection = MongoFactory.collection
    
    // find all pbdb_ocr
    //println("\n __All PBDB OCR__")
    //var pbdb = collection.find
    //pbdb.foreach(println)

    // Find with limit
    println("\n Find 2")
    //var refs = scala.collection.mutable.ArrayBuffer()
    var pbdb = collection.find().limit(5)
    for (pb <- pbdb) {
      
        /*val id = pb.getAs[String]("_id")
        val ocr_text = pb.getAs[String]("ocr_text")
        val ref = pb.getAs[MongoDBObject]("ref")
        val doi = pb.getAs[String]("ref.doi")
        val other_auth = pb.getAs[String]("ref.otherauth")
        val sci_names = pb.getAs[BasicDBList]("ref.sci_names")
        val pid  = pb.getAs[String]("ref.pid")
        val pubtitle = pb.getAs[String]("ref.pubtitle")
        val volume = pb.getAs[String]("ref.volume")
        val countries = pb.getAs[BasicDBList]("ref.countries")
        val states = pb.getAs[BasicDBList]("ref.states")
        val author1 = pb.getAs[String]("ref.author1")
        val author2 = pb.getAs[String]("ref.author2")
        val pubyear = pb.getAs[String]("ref.pubyear")
        val issue = pb.getAs[String]("ref.issue")
        val counties = pb.getAs[BasicDBList]("ref.counties")*/

        val id            = pb.get("_id")
        val ocr_text      = pb.get("ocr_text")
        val ref_title     = pb.getAs[MongoDBObject]("ref").get("title")
        val ref_doi       = pb.getAs[MongoDBObject]("ref").get("doi")
        val ref_otherauth = pb.getAs[MongoDBObject]("ref").get("otherauth")
        val ref_scinames  = pb.getAs[MongoDBObject]("ref").get("sci_names")
        val ref_pid       = pb.getAs[MongoDBObject]("ref").get("pid")
        val ref_pubtitle  = pb.getAs[MongoDBObject]("ref").get("pubtitle")
        val ref_volume    = pb.getAs[MongoDBObject]("ref").get("volume")
        val ref_countries = pb.getAs[MongoDBObject]("ref").get("countries")
        val ref_states    = pb.getAs[MongoDBObject]("ref").get("states")
        val ref_author1   = pb.getAs[MongoDBObject]("ref").get("author1")
        val ref_author2   = pb.getAs[MongoDBObject]("ref").get("author2")
        val ref_pubyear   = pb.getAs[MongoDBObject]("ref").get("pubyear")
        val ref_issue     = pb.getAs[MongoDBObject]("ref").get("issue")
        val ref_counties  = pb.getAs[MongoDBObject]("ref").get("counties")

        println("ID: " + id)
        println("PID: " + ref_pid)
        println("doi: " + ref_doi)

        println("ref title: " + ref_title )
        println("ref pubtitle: " + ref_pubtitle )
        println("ref author1: " + ref_author1)
        println("ref author2: " + ref_author2)
        println("sci names: " + ref_scinames.toString())
        //println("OCR TEXT: " + ocr_text)
        println("\n\n")
    }

    


    // {
       //var ref = pb.get("ref")
       //var pid = pb.get("ref.pid")

       //println("ID: " + pid);

       //val dbref: MongoDbObject = DBObject(ref)

       //val sci_names = dbref.as[DbObject]("sci_names")
       //println("sci_names" + sci_names)

       //println("ref Class: " + ref.getClass)
       //println("ref: " + ref)

       //var sci_names = ref.get("sci_names")             
       //println("sci_names: " + sci_names)
       //for (name <- sci_names) {
       //    println("\nName: " + name)
       //}
    //}

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
