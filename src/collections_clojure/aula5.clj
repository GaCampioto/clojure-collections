(ns collections-clojure.aula5
  (:require [collections-clojure.db :as cc.db]
            [collections-clojure.logic :as cc.logic]))

(defn spent-more-than-500
  [user-summary]
  (if (> (:total-price user-summary) 500)
    user-summary))

(let [summary (cc.logic/summary-by-user (cc.db/all-orders))]
  ;keep is equivalent to filter + map
  (println "Spent more than 500 ->" (keep spent-more-than-500 summary)))