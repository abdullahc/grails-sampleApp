class Requirement {

	
	static mapping = {
		table 'requirement'
		// version is set to false, because this isn't available by default for legacy databases
		version false
		id generator:'identity', column:'id'
   }
	
	
	static belongsTo = Story
	static hasMany = [stories:Story]  //can have requirements part of multiple stories
	
	Integer id
	String title
	String description
	
    static constraints = {
        id(max: 2147483647)
        title(size: 0..45)
        description(size: 0..45)
    }
	
	
	String toString() {
		return "${title}"
	}
}
