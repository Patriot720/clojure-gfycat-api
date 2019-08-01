(ns gfycat-api.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [gfycat-api.core :as core]
            [clojure.core.async :refer [go <! <!! >! >!! alt! alt!! chan]]))

(deftest get-token-test
  (is (= (:expires-in (<!! (core/get-token))) 3600)))
