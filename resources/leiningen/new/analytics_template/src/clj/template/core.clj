(ns {{name}}.core
  (:require [migratus.core :as migratus]
            [analytics.db.core :refer :all]
            [ring.server.standalone :refer :all])
  (:import [java.sql BatchUpdateException PreparedStatement])
  (:gen-class))


(defn -main [& args]
  (cond
    (some #{"migrate"} args)
      (migratus/migrate conn-edn)
    (some #{"rollback"} args)
      (migratus/rollback conn-edn)))

