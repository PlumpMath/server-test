(defproject server-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [http-kit "2.1.19"]
                 [org.immutant/web "2.1.3"]
                 [ring-undertow-adapter "0.2.2"]
                 ]
  :main server-test.core)
