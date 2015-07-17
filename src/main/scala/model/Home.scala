package model

import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.CascadeType
import repo.Interceptor

@Entity
@EntityListeners(value = Array(classOf[Interceptor]))
class Home extends Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long =_;
  var address : String =_;
  @ManyToOne(cascade = Array(CascadeType.ALL))
  var owner: Person =_;
  	override def toString = id + " --> home address: " + address
}
object Home{
  def apply(address:String): Home = {
    var home = new Home
    home.address  = address
    home
  }
}
