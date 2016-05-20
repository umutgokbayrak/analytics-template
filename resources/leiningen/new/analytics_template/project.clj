(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [migratus "0.8.13"]
                 [ring-server "0.4.0"]
                 [hiccup "1.0.5"]
                 [org.clojars.umutgokbayrak/analytics-engine "0.1.2"]
                 [org.clojure/clojurescript "1.8.51"]
                 [prismatic/dommy "1.1.0"]
                 [com.lucasbradstreet/cljs-uuid-utils "1.0.2"]]
  :plugins [[migratus-lein "0.2.6"]
            [lein-cljsbuild "1.1.3"]
            [lein-ring "0.9.7"]]
  :ring {:handler {{name}}.handler/app
         :init {{name}}.handler/init
         :destroy {{name}}.handler/destroy}
  :source-paths ["src/clj"]
  :main ^:skip-aot {{name}}.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :production
             {:ring
              {:open-browser? false, :stacktraces? false, :auto-reload? false}}
             :dev
             {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}}
  :resource-paths ["resources"]
  :hooks [leiningen.cljsbuild]
  :jvm-opts ["-server"
             "-Xmx2g"
             "-XX:-OmitStackTraceInFastThrow"
             "-Djava.net.preferIPv4Stack=true"]
  :cljsbuild
  {:builds
   [{:id "dev"
     :compiler
     {:output-to "resources/public/js/analytics.js"
      :optimizations :whitespace
      :externs []
      :pretty-print true
      :libs ["analytics.parsers.useragent"]
      :warnings {:single-segment-namespace false}}
     :source-paths ["src/cljs"]
     :jar true}]})
