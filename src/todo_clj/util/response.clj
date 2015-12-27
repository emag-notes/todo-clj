(ns todo-clj.util.response
  (:require [ring.util.http-response :as res]
            [potemkin :as p]))

(defmacro import-ns [ns-sym]
  (do
    `(p/import-vars
       [~ns-sym
        ~@(map first (ns-publics ns-sym))])))

(import-ns ring.util.http-response)

(defn html [res]
  (res/content-type res "text/html; charset=utf-8"))
