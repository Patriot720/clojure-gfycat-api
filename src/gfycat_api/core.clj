(ns gfycat-api.core
  (:require [clojure.data.json :as json]
            [clj-http.client :as client]
            [gfycat-api.util :as util]
            )
  (:gen-class))


(defn- gfycat-request [path query-params]
  (-> (client/get (str "https://api.gfycat.com/v1/" path)
                  {:content-type :json
                   :accept "text/html"
                   :query-params query-params})
      :body
      (json/read-str :key-fn util/clojure-stylify)))

(defn get-token [client-id client-secret]
      (try
        (gfycat-request "oauth/token"
                                       {"grant_type" "client_credentials"
                                        "client_id" client-id
                                        "client_secret" client-secret})
        (catch Exception e (prn (ex-data e)  ))))

(defn search
  ([token query & [count cursor]]
   (gfycat-request "gfycats/search" {"search_text" query
                                     "count" count
                                     "cursor" cursor})))
