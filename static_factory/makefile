JAVAC=javac
JAVAC_FLAGS=-g
JAVA=java

SOURCES = \
	Main.java \
	Circle.java \
	IntPoint.java \
	DoublePoint.java \
	GeometryFactory.java

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) $(JAVAC_FLAGS) $*.java

all: compile

compile: $(SOURCES:.java=.class)

run: compile
	$(JAVA) Main

clean:
	$(RM) *.class

.PHONY: run clean
