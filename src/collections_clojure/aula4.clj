(ns collections-clojure.aula4
  (:require [collections-clojure.db :as cc.db]
            [collections-clojure.logic :as cc.logic]))

(defn ordered-by-price [summary]
  (->> summary
       (sort-by :total-price)))

(defn top-2
  [summary]
  (take 2 summary))

(defn spent-more-than-500
  [summary]
  (filter #(> (:total-price %) 500) summary))

(defn some-spent-more-than-500
  [summary]
  (some #(> (:total-price %) 500) summary))

(let [summary (cc.logic/summary-by-user (cc.db/all-orders))]
  (println "Summary ->" summary)
  (println "Ordered by price ->" (ordered-by-price summary))
  (println "Ordered by price reversed ->" (reverse (ordered-by-price summary)))
  (println "Ordered by id ->" (sort-by :user summary))
  (println "Top 2 from summary ->" (top-2 summary))
  (println "Spent more than 500 ->" (spent-more-than-500 summary))
  (println "Some spent more than 500 ->" (some-spent-more-than-500 summary)))