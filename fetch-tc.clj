#! /usr/bin/env clojure

(import java.io.File)
(require '[clojure.java.io :as io])

(let [dirs 
      (->> (File. "..")
           (.listFiles)
           (filter #(.isDirectory %))
           (filter #(.. % getName (endsWith "-java"))))
      already-copied (set (map #(.getName %)
                               (.listFiles (File. "."))))
      fnames (set (map #(.toUpperCase
                         (str (.getPath %) \/
                              (.. % getName (replace \- \.)))) dirs))]
  (->> dirs
       (mapcat #(.listFiles %))
       (filter #(contains? fnames (.. % getPath toUpperCase)))
       (remove #(contains? already-copied (.getName %)))
       (mapv (fn [f] (with-open [r (io/reader f)]
                      (with-open [w (io/writer (.getName f))]
                        (io/copy r w)))))))

