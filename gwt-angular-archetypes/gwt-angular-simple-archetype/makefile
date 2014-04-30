template=gwt-angular-simple

all: clean build

clean:
	rm -fr src target

generate:
	mvn archetype:create-from-project -f $(template)/pom.xml

copy: generate
	cp -R $(template)/target/generated-sources/archetype/src .

copy-pom: generate
	cp -R $(template)/target/generated-sources/archetype/pom.xml .

build: copy
	mvn clean install -f $(template)/pom.xml
