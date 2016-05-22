# analytics-template

A Leiningen template for creating a fresh new analytics project. It uses my basic analytics engine also available at  [GitHub](https://github.com/umutgokbayrak/analytics-engine) and [Clojars](https://clojars.org/org.clojars.umutgokbayrak/analytics-engine)

## Usage

To start working on a new analytics project with Clojure, just install [Leiningen](http://leiningen.org) and run


```bash
lein new analytics-template <your-project-name>
```

Your new analytics project is ready. Run it with 

```bash
lein ring server
```

on console and you are done. It will create a h2 database by default. It is useful with small amounts of data. If you wish to use MySQL instead, modify the db.clj file in analytics.config namespace. A sample configuration is

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

Obviously, you'll need to create a MySQL database named "analytics" in order to run the configuration above. Lastly, you'll need to run migration scripts to start using the engine with MySQL. To do so, run

```bash
lein run migrate
```

from the console. 

Engine, will collect lots of information and store all data passed to it. In most cases you don't need that. Modify the analytics.config/analytics.clj and analytics.config/metrics.clj files to configure what to track and store into the database. 
TODO: DB Indexes

Once you run the app with lein ring server there is a sample web page at **http://localhost:3000/test.html** Point your browser to that page and on the development console you'll see that Analytics Engine is loaded. 

If you wish to send an event to the engine just run the Javascript:

```javascript
analytics.event('Event', {"key1": "value1", "key2": 122});
```

To track a pageview run Javascript

```javascript
analytics.page('Index', {"title": document.title, "attribute": "test"});
```

If you wish to identify user with an identity or unify it through devices

```javascript
analytics.identify('12391273979', {"fullname": "Umut Gokbayrak", "age": 39, "visit-count": 12, "email": "hebelek@pismail.com"})
```
## Running in Production

If you wish to run the generated analytics app in production you'll need to supply 6 System variables such as

```bash
ENV=prod
DB_NAME=analytics
DB_USER=root
DB_PASS=supersecret
DB_HOST=127.0.0.1
DB_PORT=3306
export ENV DB_NAME DB_USER DB_PASS DB_HOST DB_PORT
```

If you'll place the analytics.js file on another server than you'll also need to modify the :api-url parameter at cljs/analytics/env.cljs file to point to the full url of your production server.

```clojure
(ns analytics.env)

(def js-map {:app-name "Foo"
             :app-version "1.0"
             :api-url "http://my.domain.com/api"})

```

## License

Copyright © 2016 Umut Gokbayrak

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
