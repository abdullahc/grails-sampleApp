import com.xlnc.agile.*

class BootStrap {

    def init = { servletContext ->
        // Check whether the test data already exists.
        if (!Project.count()) {
		def project = new Project(name: "Stephen King 2",description:"",url:"")
	
		def storyDate = new Date()
		
		project.addToStories(name: "story title", description: "new description", startDate: storyDate)
		project.addToStories(name: "Sample bootstrpped story", description: "a story description has been added",startDate: storyDate)
		project.addToStories(name: "Sample bootstrpped story 2", description: "a story description has been added",startDate: storyDate)
		project.addToStories(name: "Sample bootstrpped story 3", description: "a story description has been added",startDate: storyDate)
		project.addToStories(name: "Sample bootstrpped story 4", description: "a story description has been added",startDate: storyDate)
		
		project.addToUsers(username: "hooked username", password: "new password",email:"")
		project.addToUsers(username: "bootstrappedUser1", password: "newpassword",email:"admin@agile.com")
		project.addToUsers(username: "bootstrappedUser2", password: "newpassword",email:"admin1@agile.com")
		project.addToUsers(username: "bootstrappedUser3", password: "newpassword",email:"admin2@agile.com")
		
		project.save(flush:true)
		
		def story = Story.find("from Story as s where s.name = 'story title'")
		story.addToRequirements(title: "Requirement1", description: "Requirement Description")
		story.addToRequirements(title: "Requirement2", description: "Requirement Description")
		story.addToRequirements(title: "Requirement3", description: "Requirement Description")
		story.addToRequirements(title: "Requirement4", description: "Requirement Description")
		story.addToRequirements(title: "Requirement5", description: "Requirement Description")
		story.save(flush:true)
		
		
	
        }
    }

    def destroy = {
    }
}

