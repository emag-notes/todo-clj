(ns todo-clj.db
  (:require [clojure.java.jdbc :as jdbc]
            [environ.core :refer [env]]))

(def db-spec
  (:db env))

(defn migrated? []
  (pos? (count (jdbc/query db-spec "SELECT tablename FROM pg_tables WHERE schemaname = 'public'"))))

(defn migrate []
  (when-not (migrated?)
    (jdbc/db-do-commands
      db-spec
      (jdbc/create-table-ddl :todo [:id :serial] [:title :varchar]))))
