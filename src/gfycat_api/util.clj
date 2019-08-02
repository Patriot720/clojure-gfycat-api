(ns gfycat-api.util)

(defn clojure-stylify [key]
  (keyword (clojure.string/replace key #"_" "-")))

(defn get-gfycats-with [keys search-result]
  "returns list of gfycats with selected parameters,
   removes all other parameters
   possible params:
     :title
   gifs urls:
     :gif100px
     :max2mbgif
     :gifurl
     :mp4url
     :webmurl
     :max1mbgif
  other:
     :framerate
     :gfynumber
     :width
     :gatekeeper
     :mobileposterurl
     :source
     :likes
     :curated
     :createdate
     :languagetext2
     :nsfw
     :extralemmas
     :hasaudio
     :max5mbgif
     :languagecategories
     :mp4size
     :url
     :mobileurl
     :gfyid
     :gfyname
     :posterurl
     :hastransparency
     :webpurl
     :username
     :published
     :rating
     :height
     :views
     :description
     :tags
     :webmsize
     :gfyslug
     :miniurl
     :numframes
     :dislikes
     :avgcolor
     :miniposterurl
     :thumb100posterurl
     :domainwhitelist
"
  (map #(select-keys % keys) (:gfycats search-result)))
