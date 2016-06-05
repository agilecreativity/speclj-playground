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

(defn my-count [coll]
  (loop [coll coll result 0]
    (if (empty? coll)
      result
      (recur (rest coll) (inc result)))))

;; refactor when we get the green result
(defn my-count [coll]
  (loop [coll coll result 0]
    (if (empty? coll)
      result
      (recur (rest coll) (inc result)))))

;; More refactoring
(defn my-count [coll]
  (my-reduce (fn [result _] (inc result)) 0 coll))
