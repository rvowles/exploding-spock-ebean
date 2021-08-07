package org.example

import io.ebean.DB
import org.example.models.DbSample
import org.example.models.query.QDbSample
import spock.lang.Specification

class SampleSpec extends Specification {
  def "i save a new record"() {
    given: "i have a database"
      def database = DB.getDefault()
    when: "I save a new record"
        new DbSample(name: "fred").save()
    then:
    // this line NPEs
        //new QDbSample().name.eq("fred").findCount() == 1
    //   this line works
        database.find(DbSample).where().eq("name", "fred").findCount() == 1
  }
}
