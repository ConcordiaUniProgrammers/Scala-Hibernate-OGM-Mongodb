package repo

import javax.persistence.Persistence

class BaseRepository {
  def save(obj :Any, obj2 :Any):Unit = {
    
    var tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
	var emf = Persistence.createEntityManagerFactory("MyPersistence");
	var em = emf.createEntityManager();
	try{
	  tm.begin();
	  em.joinTransaction();
	  em.persist(obj);
	  em.persist(obj2);
	  
	}catch{
	  case exp:Exception => println(exp.getMessage())
	  tm.rollback();
	}
	  em.clear();
	  em.close();
	  emf.close();
	
  }
  
}