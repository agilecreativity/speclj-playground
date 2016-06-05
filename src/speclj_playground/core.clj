(ns speclj-playground.core)

;; Simulate the build-in reduce function
(defn my-reduce
  ([f coll]
   (if (empty? coll)
     (f)
     (my-reduce f (first coll) (rest coll))))
  ([f val coll]
   (if (empty? coll)
     val
     (my-reduce f (f val (first coll)) (rest coll)))))
