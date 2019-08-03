(ns gfycat-api.util)

(defn clojure-stylify [key]
  (keyword (clojure.string/replace key #"_" "-")))
