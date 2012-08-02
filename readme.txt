README     

Copyright (C) 2011 David Milward
Openlink METADATA REGISTRY

The Metadata registry consists of a number of applications.  

This code is the main java application code, to get a working repository one also needs a sql database, a triple store and possibly a hadoop  instance.

This code runs under Maven. It also works under eclipse, the easiest setup is to import the project to eclipse and then run the maven tools from eclipse.
I've added the eclipse project file so it should be straightforward, just import as general project, then run Maven clean/install/test as required, it will build a .war file which 
can be run in a Tomcat 6 (or equivalent) web server.

At some point I'll add in the db scripts.

