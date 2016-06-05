(ns speclj-playground.core-spec
  (:require [clojure.test.check :as tc]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [speclj.core :refer :all]
            [speclj-playground.core :refer :all]))

(describe "simple test"
  (it "validates simple test"
    (should= 4 (+ 3 1))))

(describe "Truth"
  (it "is true"
    (should true))

  (it "is not false"
      (should-not false)))

;; from InfoQ
(describe "test my-reduce function"
   (it "returns the intial value for empty list"
       (should= 1 (my-reduce + 1 '())))

   (it "adds initial value with one element in the list"
       (should= 2 (my-reduce + 1 '(1))))

   (it "returns correct value when more than one element in the list"
       (should= 4 (my-reduce + 1 '(1 2))))

   (it "returns 0 if input is empty"
       (should= 0 (my-reduce + [])))

   (it "returns 0 for multiplication on empty list"
       (should= 1 (my-reduce * []))))

;; Property-based tests
(def colls
  (gen/one-of [(gen/vector gen/any)
               (gen/list gen/any)
               (gen/set gen/any)
               (gen/map gen/any gen/any)
               gen/bytes
               gen/string]))

(defn red-fn
  ([] true)
  ([a b] b))

(defspec my-reducer-property-test 1000
  (prop/for-all [c colls v gen/any]
    (and
      (= (reduce red-fn c) (my-reduce red-fn c))
      (= (reduce red-fn v c) (my-reduce red-fn v c)))))

;; Let's do another TDD again
(describe "my-count"
  (it "return 0 for an empty list"
      (should= 0 (my-count '())))

  (it "returns 0 for nil"
      (should= 0 (my-count nil)))

  (it "returns 1 for a list of one item"
      (should= 1 (my-count '(1))))

  (it "returns correct result for more than on element in the list"
      (should= 3 (my-count '(1 2 3)))))

(run-specs)
