(ns gfycat-api.core
  (:require [clojure.data.json :as json])
  (:gen-class))
(def client-info (json/read-str (slurp ".client_info.json")
                                :key-fn #(keyword (clojure.string/replace % #"_" "-"))))
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
