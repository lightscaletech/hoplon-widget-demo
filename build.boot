(set-env!
 :project       'hoplon-widget-demo
 :version       "0.0.1"
 :dependencies '[[org.clojure/clojurescript "1.7.228"]
                 [adzerk/boot-cljs          "1.7.228-2"]
                 [cljsjs/jquery                  "2.2.4-0"]
                 [hoplon                    "6.0.0-alpha17"]

                 [org.clojure/tools.nrepl   "0.2.12"]
                 [pandeiro/boot-http        "0.7.6"]]
 :source-paths #{"src"}
 :resource-paths #{"res"})

(require
 '[adzerk.boot-cljs   :refer [cljs]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev
  "Build development"
  []
  (comp
   (watch)
   (speak)
   (cljs :compiler-options {:source-map true})
   (serve :port 8000)
   (target :dir #{"target"})))

(deftask prod
  "Build prod"
  []
  (comp
   (watch)
   (speak)
   (cljs :optimizations :advanced)
   (serve :port 8000)
   (target :dir #{"target"})))
