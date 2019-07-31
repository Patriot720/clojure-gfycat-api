(ns gfycat-api.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [gfycat-api.core :as core]))

(deftest get-token-test
  (is (= (:expires-in (core/get-token)) 3600)))
