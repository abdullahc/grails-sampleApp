class BootStrap {

    def init = { servletContext ->
		
		
		
		

		def project = new Project(name: "Bootstrapped project",description:"This project has been generated by bootstrapping",url:"project.com")		
		project.save(flush:true)


		

    }
    def destroy = {
    }
}