import grails.converters.*
class DashboardController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def list() {
			[requirementInstanceList: Requirement.getAll()]
			
		
    }
	
	
	
	def nonDatabaseDomain() {
		def project = Project.find("from Project as p where p.id = 1")
		def newSnap = new Snapshot(id: '2', username: '856-9325', password: 8564259987 , email: 'whatever' ,project: project)

		def responseData = [
			'results': newSnap,
			'status': newSnap ? "OK" : "Nothing present"
		]
		render responseData as JSON
		
	}
	
	
	def ajax(){
		def results = Requirement.getAll()
		
		def responseData = [
		    'results': results,
		    'status': results ? "OK" : "Nothing present"
		]
		render responseData as JSON
	}
	
	def createNewSkeletonProject(){
		
		def project = new Project(name: "Stephen King 2",description:"",url:"")
	
		
		project.addToStories(name: "story title", description: "new description")
		project.addToStories(name: "Sample bootstrpped story", description: "a story description has been added")
		project.addToStories(name: "Sample bootstrpped story 2", description: "a story description has been added")
		project.addToStories(name: "Sample bootstrpped story 3", description: "a story description has been added")
		project.addToStories(name: "Sample bootstrpped story 4", description: "a story description has been added")
		
		project.addToUsers(username: "hooked username", password: "new password",email:"")
		project.addToUsers(username: "bootstrappedUser1", password: "newpassword",email:"admin@agile.com")
		project.addToUsers(username: "bootstrappedUser2", password: "newpassword",email:"admin1@agile.com")
		project.addToUsers(username: "bootstrappedUser3", password: "newpassword",email:"admin2@agile.com")
		
		project.save(flush:true)
		
		/*def story = Story.find("from Story as s where s.name = 'story title'")
		story.addToRequirements(title: "Requirement1", description: "Requirement Description")
		story.addToRequirements(title: "Requirement2", description: "Requirement Description")
		story.addToRequirements(title: "Requirement3", description: "Requirement Description")
		story.addToRequirements(title: "Requirement4", description: "Requirement Description")
		story.addToRequirements(title: "Requirement5", description: "Requirement Description")
		story.save(flush:true)
		*/
		
		
		def responseData = [
			'results': project,
			'status': project ? "OK" : "Nothing present"
		]
		render responseData as JSON
		
		
	}
	
	
}
