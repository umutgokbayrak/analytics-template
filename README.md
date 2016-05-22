# analytics-template

A Leiningen template for creating a fresh new analytics project.

## Usage

To start working on a new analytics project with Clojure, just install [Leiningen](http://leiningen.org) and run


```bash
lein new analytics-template <your-project-name>
```

Your new analytics project is ready. Run it with 

```bash
lein ring server
```

on console and you are done. It will create a h2 database by default. It is useful in small amounts of data. If you wish to use MySQL instead, modify the db.clj file in analytics.config namespace. A sample configuration is

```clojure
(ns analytics.config.db
  (:gen-class))

(def db-map
  {:dev  {:database-name "analytics"
          :database-pass "<PASSWORD>"
          :database-user "root"
          :database-host "localhost"
          :database-port 3306}
   :test {:database-name "analytics"
          :database-pass "<PASSWORD>"
          :database-user "root"
          :database-host "localhost"
          :database-port 3306}
   :prod {:database-name (System/getenv "DB_NAME")
          :database-user (System/getenv "DB_USER")
          :database-pass (System/getenv "DB_PASS")
          :database-host (System/getenv "DB_HOST")
          :database-post (System/getenv "DB_PORT")}})
```

Obviuosly, you'll need to create a MySQL database named analytics in order to run the configuration above. Lastly, you'll need to run migration scripts to start using the engine with MySQL. To do so, run

```bash
lein run migrate
```

from the console. 

Engine, will collect lots of information and store all data passed to it. In most cases you don't need that. Modify the analytics.config/analytics.clj and analytics.config/metrics.clj files to configure what to track and store into the database. 
TODO: DB Indexes


## License

Copyright © 2016 Umut Gokbayrak

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
