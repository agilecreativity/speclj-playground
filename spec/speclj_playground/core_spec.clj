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

(run-specs)
