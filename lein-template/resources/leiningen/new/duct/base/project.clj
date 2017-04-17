(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [duct/core "0.1.1"]
                 [duct/module.logging "0.1.1"]
                 [duct/module.web "0.1.1"]{{#cljs?}}
                 [duct/module.cljs "0.1.0"]{{/cljs?}}{{#jdbc?}}
                 [duct/module.sql "0.1.1"]{{/jdbc?}}{{#postgres?}}
                 [org.postgresql/postgresql "9.4.1212"]{{/postgres?}}{{#sqlite?}}
                 [org.xerial/sqlite-jdbc "3.16.1"]{{/sqlite?}}]
  :plugins [[duct/lein-duct "0.9.0-SNAPSHOT"]]
  :main ^:skip-aot {{namespace}}.main{{#uberjar-name}}
  :uberjar-name "{{uberjar-name}}"{{/uberjar-name}}
  :duct {:config-paths ["resources/{{dirs}}/config.edn"]}
  :profiles
  {:default [:leiningen/default :plugin.lein-duct/default{{#cljs?}} :plugin.lein-duct/cljs{{/cljs?}}]
   :dev     [:plugin.lein-duct/dev :project/dev :profiles/dev]
   :uberjar [:plugin.lein-duct/uberjar]
   :profiles/dev {}
   :project/dev  {:dependencies [[integrant/repl "0.2.0"]
                                 [eftest "0.3.0"]
                                 [kerodon "0.8.0"]]}})
