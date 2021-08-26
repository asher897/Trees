SRCDIR = src
BINDIR = bin
DOCDIR = docs
JAVAFILES = src/BinaryNode.java src/BinarySearchTree.java src/AVLTree.java

JC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)

vpath %.java $(SRCDIR)
vpath %.class $(BINDIR)

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $<

all: BinaryNode.class BinarySearchTree.class AVLTree.class

.PHONY: doc

doc:
	@javadoc -d doc $(JAVAFILES)

cleandoc:
	@rm -rf| $(DOCDIR)
	@mkdir $(DOCDIR)

clean:
	@rm -f $(BINDIR)/*.class
