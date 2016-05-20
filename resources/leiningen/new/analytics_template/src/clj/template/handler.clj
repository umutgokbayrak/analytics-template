(ns {{name}}.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.not-modified :refer [wrap-not-modified]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [analytics.routes.api :refer [api-routes]]
            [{{name}}.routes.home :refer [home-routes]])
  (:gen-class))

(defn init []
  (println "{{name}} is starting"))

(defn destroy []
  (println "{{name}} is shutting down"))

(defroutes app-routes
  (route/not-found "Not Found"))

(def app
  (-> (routes api-routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)
      (wrap-resource "public")
      (wrap-content-type)
      (wrap-not-modified)))

