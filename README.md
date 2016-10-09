# stories-in-kitchen-service
RESTful web service for managing recipe

# setup
## git clone source code
git clone git@github.com:foodiecamp/stories-in-kitchen-service.git

## download and setup maven 3.0.4
- download and unzip http://archive.apache.org/dist/maven/maven-3/3.0.4/binaries/apache-maven-3.0.4-bin.zip
- set MAVEN_HOME to the path where apache-maven-3.0.4/bin located
- make sure JAVA_HOME is also set
- set both MAVEN_HOME and JAVA_HOME to PATH
- mvn -v to check if maven setup is successful
- also check the reference for help https://maven.apache.org/install.html

## mvn eclipse:eclipse
- at the source code root directory where pom.xml presents, run "mvn eclipse:eclipse" from command line
- the mvn build should be successful

## mysql setup
- download and install mysql
- download and install mysql workbench
- run database schema create script https://github.com/npu-tiger/db-schema/blob/master/recipe_schema_creation.sql
- run user data seed script https://github.com/npu-tiger/db-schema/blob/master/user_data_seed.sql
- run recipe data seed script https://github.com/npu-tiger/db-schema/blob/master/recipe_data_seed.sql
- run rank data seed script https://github.com/npu-tiger/db-schema/blob/master/rank_data_seed.sql

## update mysql connection
- go to src/main/webapp/WEB-INF/jetty-env.xml
- edit the following to match the mysql db schema in your local environment
<Set name="Url">jdbc:mysql://localhost:3306</Set>
<Set name="User">your-username</Set>
<Set name="Password">your-password</Set>

## start jetty server
- at the source code root directory where pom.xml presents, run "mvn jetty:run"
- "[INFO] Started Jetty Server" should be seen for a successful launch

## test endpoints
- use browser or curl to hit the endpoint: http://localhost:8080/recipe/rest/api
- if you see "welcome to recipe!" then your web service is running fine

# User Resource
## GET - get all
http://localhost:8080/recipe/rest/api/users
<br>Sample response:
{"users":[{"id":1,"username":"admin","email":"admin@recipe.com","nickname":"fun","createdBy":"admin","createdDate":1446175992000,"updatedBy":"adimn","updatedDate":1446176000000},{"id":3,"username":"user1","email":"user1@recipe.com","nickname":"fun","createdBy":"admin","createdDate":1446176035000,"updatedBy":"admin","updatedDate":1446176035000},{"id":4,"username":"dummyuser1","email":"dummyuser1@recipe.com","nickname":"fun","createdBy":"admin","createdDate":1446179244000,"updatedBy":"admin","updatedDate":1446179244000},{"id":5,"username":"dummyuser2","email":"dummyuser2@recipe.com","nickname":"too much fun","createdBy":"admin","createdDate":1447381140000,"updatedBy":"admin","updatedDate":1447381140000}]}

## GET - get by id
GET: http://localhost:8080/recipe/rest/api/users/1
<br>sample response: {"user":{"id":1,"username":"admin","email":"admin@recipe.com","nickname":"fun","createdBy":"admin","createdDate":1446175992000,"updatedBy":"adimn","updatedDate":1446176000000}}

## POST: create user
http://localhost:8080/recipe/rest/api/users
<br>sample request payload for post: {"id":null,"username":"dummyuser1","password":"password123","email":"dummyuser1@recipe.com","nickname":"fun"}
<br>sample response: {"user":{"id":5}}

# Auth Resource
## login
### Sample Request:
POST: http://localhost:8080/recipe/rest/api/auth/login
<br>Content-Type: application/x-www-form-urlencoded
<br>username=admin
<br>password=password123
### Sample Response:
{"user":{"id":1,"username":"admin","email":"admin@recipe.com","nickname":"fun","createdBy":"admin","createdDate":1446175992000,"updatedBy":"adimn","updatedDate":1446176000000}}

## logout
sample request: http://localhost:8080/recipe/rest/api/auth/logout
sample response: 200 OK

# reference
http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html