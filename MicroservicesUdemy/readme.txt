source
https://inglearn.udemy.com/course/master-microservices-with-spring-docker-kubernetes/learn/lecture/39943182#overview

h2 console
http://localhost:8080/h2-console/login.do?jsessionid=5b374438a0c421678501990f58705b85

GET call from browser
http://localhost:8080/api/fetch

documentation interface
http://localhost:8080/swagger-ui/index.html#/

to recover a deleted branch from github or elese
https://stackoverflow.com/questions/4674226/does-github-keep-deleted-remote-branches-in-history-if-so-can-those-be-restore
Steps:
1.Find your Commit ID: Search for a branch using git reflog
git reflog -> then Search for the branch name in the reflog and note the HEAD{x} point or the commit ID.
2. Re-create the branch from the Reflog HEAD point:
git checkout -b branch_name HEAD@{27}
2.alternative
Re-create the branch from the commit ID:
You can checkout the commit ID and create a branch off of that commit point:
git checkout -b branch_name <commit id>

docker commands:
docker images
docker image inspect <image id>
docker image rm <image name>
docker build . -t <image name>  -> generate image based on a docker file ex: C:\Users\ZH07FO\Documents\MicroservicesUdemy\accounts\Dockerfile
docker run -p <host port>:<container port> <image name>
docker ps
docker ps -a
docker container start <container id>
docker container pause <container id>
docker container unpause <container id>
docker container stop <container id>
docker container kill <container id>
docker container restart <container id>
docker container inspect <container id>
docker container logs <container id>

