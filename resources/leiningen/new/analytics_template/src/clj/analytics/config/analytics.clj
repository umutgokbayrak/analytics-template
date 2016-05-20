(ns analytics.config.analytics
  (:gen-class))

(def analytics-map
  {
    ;; contexts
    :app.context.saved true
    :campaign.context.saved true
    :device.context.saved true
    :location.context.saved true
    :network.context.saved true
    :os.context.saved true
    :page.context.saved true
    :properties.saved true
    :screen.context.saved true
    :browser.context.saved true

    ;; ops
    :session.op.saved true
    :event.op.saved true
    :identify.op.saved true
    :page.op.saved true
    :screen.op.saved true
    :start.op.saved true
    :stop.op.saved true

    ;; Metrics date prefixes
    :all.time.prefix.saved true
    :yearly.prefix.saved true
    :monthly.prefix.saved true
    :daily.prefix.saved true
    :hourly.prefix.saved true})
