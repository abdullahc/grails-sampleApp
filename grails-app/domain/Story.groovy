/**
 * The Story entity.
 *
 * @author    
 *
 *
 */
class Story {
    static mapping = {
         table 'story'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'id'
    }
	
	static hasMany = [requirements:Requirement]
	
    Integer id
    String name
    String description
	Date startDate


	


    static constraints = {
        id(max: 2147483647)
        name(size: 0..45)
        description(size: 0..45)
    }
    String toString() {
        return "${name}" 
    }
}
