import javax.validation.metadata.Scope;

class GrailsNgTagLib {
	static namespace = "xlnc" 
	def simple = { 

		
		out << """
            <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.3/angular.min.js"></script>
        """
		}

}
