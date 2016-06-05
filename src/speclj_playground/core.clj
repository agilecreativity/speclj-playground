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

;; Filter
(defn my-filter
  [pred coll]
  (lazy-seq coll))

;; Build function up recursively
(defn my-filter
  [pred coll]
  (loop [input coll result []]
    (if (empty? input)
      (lazy-seq result)
      (recur (rest input)
             (if (pred (first input))
               (conj result (first input))
               result)))))

;; Note: conj depends on the collection type, so is realized immediately
;; where cons adds an item to the start of a collection, and can be evalulated lazily

;; Time for refactoring
(defn my-filter [pred coll]
  (lazy-seq (when (seq coll)
     (if (pred (first coll))
       (cons (first coll) (my-filter pred (rest coll)))
       (my-filter pred (rest coll))))))

;; to get the vector containing just the even numbers given an input of [0 1 2 3 4 5]?
(into [] (my-filter even? [0 1 2 3 4 5])) ;; [0 2 4]

;; Map (TBC)
