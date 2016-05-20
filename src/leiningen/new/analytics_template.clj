(ns leiningen.new.analytics-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "analytics-template"))

(defn analytics-template
  "Create a new analytics project."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating a fresh new analytics project.")
    (->files data
             [".gitignore" (render "gitignore")]
             [".hgignore" (render "hgignore")]
             ["README.md" (render "README.md")]
             ["CHANGELOG.md" (render "CHANGELOG.md")]
             ["LICENSE" (render "LICENSE")]

             ;; Clojure Files
             ["project.clj" (render "project.clj" data)]
             ["src/clj/{{sanitized}}/core.clj" (render "src/clj/template/core.clj" data)]
             ["src/clj/{{sanitized}}/handler.clj" (render "src/clj/template/handler.clj" data)]
             ["src/clj/{{sanitized}}/routes/home.clj" (render "src/clj/template/routes/home.clj" data)]
             ["src/clj/{{sanitized}}/db/core.clj" (render "src/clj/template/db/core.clj" data)]
             ["src/clj/analytics/config/metrics.clj" (render "src/clj/analytics/config/metrics.clj" data)]
             ["src/clj/analytics/config/analytics.clj" (render "src/clj/analytics/config/analytics.clj" data)]
             ["src/clj/analytics/config/db.clj" (render "src/clj/analytics/config/db.clj" data)]

             ;; ClojureScript Files
             ["src/cljs/analytics.cljs" (render "src/cljs/analytics.cljs" data)]
             ["src/cljs/analytics/utils.cljs" (render "src/cljs/analytics/utils.cljs" data)]
             ["src/cljs/analytics/env.cljs" (render "src/cljs/analytics/env.cljs" data)]
             ["src/cljs/analytics/trackers/core.cljs" (render "src/cljs/analytics/trackers/core.cljs" data)]
             ["src/cljs/analytics/parsers/useragent.js" (render "src/cljs/analytics/parsers/useragent.js" data)]


             ;; Tests
             ["test/{{sanitized}}/core_test.clj" (render "test/template/core_test.clj" data)]

             ;; Migratus Scripts
             ["resources/migrations/20160418201922-device-context.down.sql" (render "resources/migrations/20160418201922-device-context.down.sql")]
             ["resources/migrations/20160418195256-users.down.sql" (render "resources/migrations/20160418195256-users.down.sql")]
             ["resources/migrations/20160418202102-screen-context.down.sql" (render "resources/migrations/20160418202102-screen-context.down.sql")]
             ["resources/migrations/20160424202428-metrics.up.sql" (render "resources/migrations/20160424202428-metrics.up.sql")]
             ["resources/migrations/20160418200003-app-context.up.sql" (render "resources/migrations/20160418200003-app-context.up.sql")]
             ["resources/migrations/20160418195726-property-context.up.sql" (render "resources/migrations/20160418195726-property-context.up.sql")]
             ["resources/migrations/20160418195629-ops.up.sql" (render "resources/migrations/20160418195629-ops.up.sql")]
             ["resources/migrations/20160418195832-location-context.down.sql" (render "resources/migrations/20160418195832-location-context.down.sql")]
             ["resources/migrations/20160418195510-users-custom-traits.up.sql" (render "resources/migrations/20160418195510-users-custom-traits.up.sql")]
             ["resources/migrations/20160418201722-campaign-context.down.sql" (render "resources/migrations/20160418201722-campaign-context.down.sql")]
             ["resources/migrations/20160418202328-page-context.down.sql" (render "resources/migrations/20160418202328-page-context.down.sql")]
             ["resources/migrations/20160418195726-property-context.down.sql" (render "resources/migrations/20160418195726-property-context.down.sql")]
             ["resources/migrations/20160418195510-users-custom-traits.down.sql" (render "resources/migrations/20160418195510-users-custom-traits.down.sql")]
             ["resources/migrations/20160418202428-os-context.up.sql" (render "resources/migrations/20160418202428-os-context.up.sql")]
             ["resources/migrations/20160424202428-metrics.down.sql" (render "resources/migrations/20160424202428-metrics.down.sql")]
             ["resources/migrations/20160418200003-app-context.down.sql" (render "resources/migrations/20160418200003-app-context.down.sql")]
             ["resources/migrations/20160418195629-ops.down.sql" (render "resources/migrations/20160418195629-ops.down.sql")]
             ["resources/migrations/20160418195429-users-traits.up.sql" (render "resources/migrations/20160418195429-users-traits.up.sql")]
             ["resources/migrations/20160418195223-sites-domains.up.sql" (render "resources/migrations/20160418195223-sites-domains.up.sql")]
             ["resources/migrations/20160418202428-os-context.down.sql" (render "resources/migrations/20160418202428-os-context.down.sql")]
             ["resources/migrations/20160418195553-sessions.up.sql" (render "resources/migrations/20160418195553-sessions.up.sql")]
             ["resources/migrations/20160418195103-sites.up.sql" (render "resources/migrations/20160418195103-sites.up.sql")]
             ["resources/migrations/20160418195429-users-traits.down.sql" (render "resources/migrations/20160418195429-users-traits.down.sql")]
             ["resources/migrations/20160506200911-browser-context.up.sql" (render "resources/migrations/20160506200911-browser-context.up.sql")]
             ["resources/migrations/20160418201922-device-context.up.sql" (render "resources/migrations/20160418201922-device-context.up.sql")]
             ["resources/migrations/20160418195256-users.up.sql" (render "resources/migrations/20160418195256-users.up.sql")]
             ["resources/migrations/20160418202025-network-context.up.sql" (render "resources/migrations/20160418202025-network-context.up.sql")]
             ["resources/migrations/20160418195553-sessions.down.sql" (render "resources/migrations/20160418195553-sessions.down.sql")]
             ["resources/migrations/20160418195103-sites.down.sql" (render "resources/migrations/20160418195103-sites.down.sql")]
             ["resources/migrations/20160418195223-sites-domains.down.sql" (render "resources/migrations/20160418195223-sites-domains.down.sql")]
             ["resources/migrations/20160418201722-campaign-context.up.sql" (render "resources/migrations/20160418201722-campaign-context.up.sql")]
             ["resources/migrations/20160506200911-browser-context.down.sql" (render "resources/migrations/20160506200911-browser-context.down.sql")]
             ["resources/migrations/20160418202102-screen-context.up.sql" (render "resources/migrations/20160418202102-screen-context.up.sql")]
             ["resources/migrations/20160418202025-network-context.down.sql" (render "resources/migrations/20160418202025-network-context.down.sql")]
             ["resources/migrations/20160418202328-page-context.up.sql" (render "resources/migrations/20160418202328-page-context.up.sql")]
             ["resources/migrations/20160418195832-location-context.up.sql" (render "resources/migrations/20160418195832-location-context.up.sql")]

             ;; Static Resources
             ["resources/public/js/analytics.js" (render "resources/public/js/analytics.js")]
             ["resources/public/test.html" (render "resources/public/test.html")]
             ["resources/GeoLiteCityv6.dat" (render "resources/GeoLiteCityv6.dat")]
             ["resources/GeoIPASNumv6.dat" (render "resources/GeoIPASNumv6.dat")]
             ["resources/log4j.properties" (render "resources/log4j.properties")]
             ["resources/sql/test.sql" (render "resources/sql/test.sql")]
             ["scripts/UpdateGeoIpFiles.sh" (render "scripts/UpdateGeoIpFiles.sh")]


             )))
