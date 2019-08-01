(ns gfycat-api.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [gfycat-api.core :as core]
            ))

#_(deftest get-token-test
    (let [token (<!! (core/get-token))]
      (is (not (nil? token)))
      (is (= (:expires-in token) 3600))))
(def token (:access-token (<!! (core/get-token))))
#_(deftest search-test
    (testing "should return one gfycat search result"
      (let [search-result (core/search token "wow" 1)]
        (is (= search-result {}))))
    (testing "searchnig with cursor"))
