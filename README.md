In Local  (non-docker env)
-
After cloning the repo,
Build using the below commands:
- `mvn clean install`
- `mvn clean package`

Bring the service up by executing the command
- `mvn spring-boot:run`

Run api tests by running the command 
- `mvn test -Papi-tests`


In Docker env
-

To build the docker image
- `docker-compose build`

The above command will run all the unit test cases and build the project.

To attach the image to the container and bring the change password service up
- `docker-compose up`

Run api tests by running the command inside a container
- `mvn test -Papi-tests`

To Test from postman
-

Once the service is up Hit the uri from postman or any service testing tool
- `http://localhost:7134/changepassword`  [Post Request]

with request body in JSON format like below
- `{
   		"newPassword": "ABCDEFGHabcdefgh24356554!$",
    	"oldPassword": "abcdefghijABCDEFGHsdasd@$!&"
   }`
   
To know the oldPassword
- 
- `http://localhost:7134/changepassword`  [Get Request]  

After every hit, make sure you interchange old and new password (in this example)

Response will be true or false with appropriate status code



<b> Note: </b> <br> <br>
~ current_password.json will store the current password. Everytime, a request is made with old and new password, the old password is validated against the value in this file.

~ ChangePasswordUnitTest has the unit tests for the change password functionality
