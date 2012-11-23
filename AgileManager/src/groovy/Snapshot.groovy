/**
 * The User entity.
 *
 * @author    
 *
 *
 */
class Snapshot {
	
	def isAttached() 
		{
		   return false
		}
	
    Integer id
    String username
    String password
    String email
	Project project
	

    String toString() {
        return "Snapshot page" 
    }
}
