(ns server-test.core
  (:require [ring.adapter.jetty :as jetty]
            [org.httpkit.server :as http-kit]
            [ring.adapter.undertow :as undertow]
            [immutant.web :as immutant]
            ))
  ;(:import java.nio.charset.Charset))

(def html
"<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=%s;\">
  </head>
<body>
  <h1> Can you see the hangul below? </h1>
  <h1> 한글</h1>
</body>
</html>
")

(defn make-response-by-enc [enc]
  {:status 200
   :headers {"Content-Type" (format "text/plain; charset=%s" enc)}
   ;:body (format html enc)})
   :body "가"})

(defn make-response [enc]
  (if (#{"euc-kr" "utf-8"} enc)
    (make-response-by-enc enc)))

(defn iso-8859-1-> [s enc]
  (if s
    (String. (.getBytes s "ISO-8859-1") enc)))

(defn check-query-string [qs]
  (println (str "query string: " qs))
  (println (str "is-8859-1 ==> euc-kr: " (iso-8859-1-> qs "euc-kr")))
  (println (str "is-8859-1 ==> utf-8: " (iso-8859-1-> qs "utf-8")))
  )

(defn app [{:keys [uri query-string] :as request}]
  (if (= "/" uri)
    (do (check-query-string query-string )
        (make-response query-string ))
    {:status 404}))

(defn start-server [opt]
   ;(jetty/run-jetty app opt)
;  (http-kit/run-server app opt)
;   (undertow/run-undertow app opt)
  (immutant/run app opt)
  )

(defn -main [& args]
  (println args)
  (start-server {:port 3001})
  )

;(-main)

