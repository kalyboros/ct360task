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
* Has ability to retrieve ‘Hello World’ translations from an external API (eg. Systran Translation API) :heavy_check_mark:
* Has ability to switch between DB and external API retrieval by using spring profiles :x:
* Use standalone DB instead of in-memory H2 :heavy_check_mark:
* Dockerize the application :o:
* Run 2 instances of application (one that uses DB and another that uses external API) and put an reverse proxy in front of them, so when user access /api/db/hello or /api/external/hello it get routed to proper instance of the application :interrobang:


# Personal task explanation and notes

#### Unfinished tasks
* spring profiles have to be manually managed in application.properties before runtime (didnt finish)
* I built the artifact, created a .jar, successfully built a docker image, but when i run it, the following error ocurrs: "no main manifest attribute", yet i package the whole thing and manifest.mf is included.

#### MySQL db
* name ct
* table user for users/admins for adding pairs with secure point, has the following columns: id, active, password, roles, user_name
* table helloworlds has columns: id, lang, translation, language

#### Endpoints 
* /hello which returns html page with hello world headings
* /hello-rest which receives a text (language) and returns hello world in that language
* /secure/hello which reroutes user to a login page. After a successful login, user can add a new language pair
* /insertPair which receives a json object of a language pair (auto id, language, text) and writes it to db. This api is available only to logged in users.
* /externalTranslation which receives a json object (language from, language to, text) and returns a translation

#### Reroutes 
* /addPair successfully logged in user gets redirected to this html page for gui pair insertion
* /login for users to login, its from a secure service provider built in spring

#### AOP logger can be found in logging
* it is applied to all endpoints that exist and provides info before and after the db operations

#### Rest controller is in controller MainResource.java

#### GUI html page for adding pairs is in templates
