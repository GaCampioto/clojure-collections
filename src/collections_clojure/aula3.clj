(ns collections-clojure.aula3
  (:require [collections-clojure.db :as cc.db]
            [collections-clojure.logic :as cc.logic]))

(println (cc.logic/summary-by-user (cc.db/all-orders)))

