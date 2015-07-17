import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.Persistence
import model.Person
import model.Home
import model.Car
import repo.BaseRepository

object Demo {

  def main(args: Array[String]) {
			
	var person =  Person.apply("mojtaba")
	var person2 = Person.apply("DD")
			
	var car = Car.apply("141u4")
	var car2 = Car.apply("12k123")
			
	var home = Home.apply("235 sherebrook")
	var home2 = Home.apply("2480 sherbrook")
	var home3 = Home.apply("150 Sherebrook")
			
	person.addHome(home)
	person.addHome(home2)
	person2.addHome(home3)
			
	person.addCar(car)
	person.addCar(car2)
	person2.addCar(car)
			
	var repo = new BaseRepository();
	repo.save(person, person2)
  }
}