(ns speclj-playground.core-spec
  (:require [speclj.core :refer :all]
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

(run-specs)
