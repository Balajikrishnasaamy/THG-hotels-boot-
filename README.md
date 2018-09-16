# THG-hotels-boot-

This system records the energy and water usage records for every branch for every month.
This system got enabled with restfull services connecting mongo db.


The services prodived are:

1. Creating a hotel record 

   Url: POST: http://localhost:8080/hotels/create
	 
   This method takes a hotel object in json format.
   
2. Showing all hotel entries

	Url: GET: http://localhost:8080/hotels/getall
	
	This method will show all the hotel entries from the mongodb
	
3. Show hotel by branch_code

	Url: GET: http://localhost:8080/hotels/code={Id}
	
	This method will show all the entries for a specific hotel
	
4. show hotel by city

	Url: GET: http://localhost:8080/hotels/city={}
	
	This method will show all the hotel entries with in the city
	
5. Show hotel by date

	Url: GET: http://localhost:8080/hotels/{Id}/{date}
	
	This method will show the one entry of the specific hotel agains the given date
	
6. Update hote

	Url: PUT: http://localhost:8080/update
	
	This method will update the hotel entry
	
7. Get usage statistics

	Url: GET: http://localhost:8080/statistics/{Id}
	
	This method will calculates the usage percentage compares with the months old data and produce the result.
	
	
	# How to run this project:
	
	To run this project:
	
	Clone the project into the local repository or download as a zip and extract to a local path
	
	1. Open eclipse and import this project as Maven existing project
	2. Run the ThghotelsApplicaiton.java as "run as java application" and make sure the project starts with tomcat and port is 8080
	3. Open any restclient application and invoke any services mentioned in above section.
	
	
for feedback please drop a mail at balajikrishnasaamy@gmail.com
