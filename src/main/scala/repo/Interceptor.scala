package repo

import javax.persistence.PostPersist
import javax.persistence.PrePersist

class Interceptor {
	@PrePersist
	def prePersist(obj: Any):Unit = {
		println(obj.toString());
	}
	@PostPersist
	def postPersist(obj: Any){
		println(obj.toString());
	}
}