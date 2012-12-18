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
		
			
		def responseData = [
			'results': project,
			'status': project ? "OK" : "Nothing present"
		]
		render responseData as JSON
		
		
	}
	
	
}
