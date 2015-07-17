package model

import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.ManyToMany
import javax.persistence.CascadeType
import repo.Interceptor

@Entity
@EntityListeners(value = Array(classOf[Interceptor]))
class Car extends Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long =_;
  var plate_number:String =_;
  @ManyToMany(mappedBy = "cars")
  var people : java.util.List[Person] = new java.util.ArrayList[Person]();
  def addPerson(person: Person){
    this.people.add(person)
  }
  	override def toString = id + " --> car plate number is: " + plate_number 
}
object Car{
  def apply(plate_number:String): Car ={
    var car = new Car
    car.plate_number  = plate_number
    car
  }
}