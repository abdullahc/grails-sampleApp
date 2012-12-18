package com.xlnc.agile
/**
 * The User entity.
 *
 * @author    
 *
 *
 */
class User {
    static mapping = {
         table 'user'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'id'
    }
    Integer id
    String username
    String password
    String email
	
	static hasMany = [projects:Project]
	static belongsTo = Project

    static constraints = {
        id(max: 2147483647)
        username(size: 0..45)
        password(size: 0..45)
        email(size: 0..45)
    }
    String toString() {
        return "${username}" 
    }
}
