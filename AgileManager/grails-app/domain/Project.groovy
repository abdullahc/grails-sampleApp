/**
 * The Project entity.
 *
 * @author    
 *
 *
 */
class Project {
    static mapping = {
         table 'project'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'id'
    }
    Integer id
    String name
    String description
    String url
    User creator

	
	
	static hasMany = [stories:Story,users:User] 

    static constraints = {
        id(max: 2147483647)
        name(size: 0..45)
        description(size: 0..45)
        url(size: 0..45)
}
    String toString() {
        return "${name}" 
    }
}
