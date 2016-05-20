(ns {{name}}.db.core
  (:require [analytics.db.core :as db-core]
            [conman.core :as conman])
  (:gen-class))


(def db (db-core/get-db))
(def bound (atom nil))

(if (nil? @bound)
  (do
    (conman/bind-connection
      db
      "sql/test.sql")
    (reset! bound "YES")))
