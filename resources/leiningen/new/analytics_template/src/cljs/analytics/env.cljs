(ns analytics.env)

(def js-map {:app-name "Foo"
             :app-version "1.0"
             :api-url "/api"})

(defn js [k]
  (get js-map k))
