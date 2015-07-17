package model

import java.util.ArrayList
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.GenerationType
import repo.Interceptor
import javax.persistence.CascadeType

@Entity
@EntityListeners(value = Array(classOf[Interceptor]))
class Person extends Serializable{
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long =_;
	var name: String =_;
	@ManyToMany(cascade = Array(CascadeType.ALL))
	var cars: java.util.List[Car] = new ArrayList[Car]()
	@OneToMany(mappedBy = "owner", cascade= Array(CascadeType.ALL))
	var homes : java.util.List[Home] = new java.util.ArrayList[Home]()
	
	def addCar(car: Car){
	  this.cars.add(car)
	}
	def addHome(home: Home){
	  home.owner = this
	  this.homes.add(home)
	}
	//def this() = this (null)
	override def toString = id + " --> " + name
}
object Person {
  def apply(name: String) = {
    val p = new Person
    p.name = name;
    p
  }
}
    
 
  