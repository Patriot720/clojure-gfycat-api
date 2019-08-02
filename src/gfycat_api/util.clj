(ns gfycat-api.util)

(defn clojure-stylify [key]
  (keyword (clojure.string/replace key #"_" "-")))

(defn get-gfycats-with [keys search-result]
  "returns list of gfycats with selected parameters,
   removes all other parameters"
  (map #(select-keys % keys) (:gfycats search-result)))
