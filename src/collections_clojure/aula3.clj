(ns collections-clojure.aula3
  (:require [collections-clojure.db :as cc.db]))

(defn item-total
  [[_ details]]
  (* (get details :quantity 0) (get details :price 0)))

(defn order-total
  [order]
  (->> order
       (map item-total)
       (reduce +)))

(defn orders-total
  [orders]
  (->> orders
       (map :items)
       (map order-total)
       (reduce +)))

(defn order-summary
  [[user orders]]
  {:user           user
   :order-quantity (count orders)
   :total-price    (orders-total orders)})


(->> (cc.db/all-orders)
     (group-by :user)
     (map order-summary)
     println)

