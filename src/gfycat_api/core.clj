(ns gfycat-api.core
  (:require [clojure.data.json :as json]
            [clj-http.client :as client]
            [clojure.core.async :refer [close!  go <! <!! >! >!! alt! alt!! chan]])
  (:gen-class))

(defn- clojure-stylify [key]
  (keyword (clojure.string/replace key #"_" "-")))
(def client-info (json/read-str (slurp ".client_info.json")
                                :key-fn clojure-stylify))
(defn get-token []
  (let [token-chan (chan)] (go
                             (>! token-chan (-> (client/get "https://api.gfycat.com/v1/oauth/token"
                                                            {:content-type :json
                                                             :accept "text/html"
                                                             :query-params {"grant_type" "client_credentials"
                                                                            "client_id" (:client-id client-info)
                                                                            "client_secret" (:client-secret client-info)}})
                                                :body
                                                (json/read-str :key-fn clojure-stylify))))
       token-chan))
