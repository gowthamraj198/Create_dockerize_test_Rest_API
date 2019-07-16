After cloning the repo, go to pom.xml. This will install all the dependencies


current_password.json will store the current password. Everytime, a request is made with old and new password, the old password is validated against the value in this file.

ChangePasswordUnitTest has the unit tests for the change password functionality

To build the docker image
- `docker-compose build`

To attach the image to the container and bring the change password service up
- `docker-compose up`

Once the service is up Hit the uri from postman or any service testing tool
- `http://localhost:9999/changepassword` 

with request body in JSON format like below
- `{
   		"newPassword": "ABCDEFGHabcdefgh24356554!$",
    	"oldPassword": "abcdefghijABCDEFGHsdasd@$!&"
   }`

After every hit, make sure you interchange old and new password (in this example)

Response will be true or false with appropriate status code