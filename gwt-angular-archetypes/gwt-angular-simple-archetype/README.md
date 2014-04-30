### Check out the Archetype

git clone 


### Build the Archetype

cd gwt-angular-simple
make all


### Generate a New Project from Locally Generated Archetype

To generate a new project from this archetype, execute the below command with appropriate version number.


```
mvn archetype:generate \
  -DarchetypeGroupId=com.asayama.gwt.angular.archetype \
  -DarchetypeArtifactId=gwt-angular-simple-archetype \
  -DarchetypeVersion=0.0.1-SNAPSHOT
```
