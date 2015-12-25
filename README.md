# todo-clj

http://ayato-p.github.io/clojure-beginner/intro_web_development/index.html

## Setup PostgreSQL

``` sh
$ docker run -it -d \
  --name todo_clj_dev \
  -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=todo_clj_dev \
  -p 5432:5432 \
  postgres:9.4.5
```

### psql

``` sh
$ docker run -it --rm \                                                                      
  --link todo_clj_dev:db \
  postgres:9.4.5 \
  sh -c 'exec psql -h "$DB_PORT_5432_TCP_ADDR" -p "$DB_PORT_5432_TCP_PORT" -d todo_clj_dev -U username'
```