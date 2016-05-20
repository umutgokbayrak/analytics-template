(ns {{name}}.routes.home
  (:require [compojure.core :refer :all]
            [{{name}}.db.core :refer :all]))


(defn home []
  ;; TODO: test.html should be served from here via hiccup

  (str "It works. Here is the users table...<br/>&nbsp;<br/>"
       (db-get-users)))

(defroutes home-routes
  (GET "/" [] (home)))
