(ns speclj-playground.expect-spike
  (:use expectations))

(expect nil? nil)

(expect 3 (+ 1 2))

(expect "foo" "foo")

;; test if regex is in a string
(expect #"foo" "boofooar")

(expect ArithmeticException (/ 12 0))

;; expect a value in a collection (k/v for maps)
(expect {:foo 1} (in {:foo 1 :cat 4}))

(expect :foo (in #{:foo :bar}))

(expect :foo (in [:bar :foo]))

(expect empty? (list))

(expect (more vector? not-empty) [1 2 3])

(expect 2 (+ 1 1))

(expect [1 2] (conj [] 1 2))

(expect #{1 2} (conj #{} 1 2))

(expect {1 2} (assoc {} 1 2))
