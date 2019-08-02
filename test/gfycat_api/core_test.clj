(ns gfycat-api.core-test
  (:require [clojure.test :refer [deftest is testing]]
        [clojure.data.json :as json]
            [gfycat-api.core :as core]
[gfycat-api.util :as util]
            ))

(def client-info (json/read-str (slurp ".client_info.json")
                                :key-fn util/clojure-stylify))

(deftest get-token-test
    (let [token (core/get-token (:client-id client-info) (:client-secret client-info))]
      (is (not (nil? token)))
      (is (= (:expires-in token) 3600))))

(def token (:access-token (core/get-token (:client-id client-info) (:client-secret client-info))))
(deftest search-test
    (testing "should return one gfycat search result"
      (let [search-result (core/search token "thanos power up" 1)]
        (is (= (:cursor search-result) ""))))
    (testing "searchnig with cursor"))
