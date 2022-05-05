### CT360 interview tasks

#Tasks status
* Empty working Spring Boot App built with Maven :heavy_check_mark:
* Has /hello-rest REST endpoint which returns ‘Hello World’ string :heavy_check_mark:
* Has /hello endpoint which returns a HTML page with ‘Hello World’ string displayed :heavy_check_mark:
* Has in-memory H2 database started with initial set of 10 different strings per language (‘Hello World’ in 10 different languages) and /hello endpoints return the string determined by language parameter passed inside the query :heavy_check_mark:
* Has /secure/hello endpoint that requires user to log in with username and password :heavy_check_mark:
* Has a secured ‘Admin’ page that allows the user to add new Language-Message pairs into the database :heavy_check_mark:
* Has an aspect (AOP) that performs logging for different endpoints with useful information included into logs :heavy_check_mark:
* Uses a standalone DB instead of in-memory H2 DB :heavy_check_mark:
* Has ability to retrieve ‘Hello World’ translations from an external API (eg. Systran Translation API) :x:
* Has ability to switch between DB and external API retrieval by using spring profiles :x:
* Use standalone DB instead of in-memory H2 :heavy_check_mark:
* Dockerize the application :x:
* Run 2 instances of application (one that uses DB and another that uses external API) and put an reverse proxy in front of them, so when user access /api/db/hello or /api/external/hello it get routed to proper instance of the application :x:


# Personal task explanation and notes 
Todo