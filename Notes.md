# Strategies

- Keep block/allow lists for bad/good bots by the public IP address used
- Take a closer look at analytics for signs:
    - higher than normal pageviews
    - abnormally high bounce rate
    - session duration outliers
    - high traffic volume from unexpected locations
    - junk conversion

- Feature measures:
    - CAPTCHAs
    - Web Application Firewalls
    - Multi-factor Authentication

# Insights

Detecting and restricting bot traffict is important to identify and prevent many different security threats on the internet, but also to avoid losing precious bandwidth because of unwanted bot accesses to your website.

Bot traffic is not always a bad thing, there are many bots that provide useful monitoring or analytics information for example. This is why completely blocking off bots from your system is not the best option.

It is a common strategy to obliviate malicious bot traffic by alternating between good/bad bot traffic.

From 2014 to 2021, the bad bot traffic has increased in percentage compared to human and good bot traffic. In 2021, roughly 2/3 of bot traffic is malicious, and that makes more than 1/4 of all web traffic. ([Statista](https://www.statista.com/statistics/1264226/human-and-bot-web-traffic-share/))

# Bot Detection Advantages

- Reduce costs related to bad bot bandwidth
- Having a more stable UX, avoiding traffic spikes
- Protect your application from web scrappers that scan application features

# Definitions

> **Bounce Rate** ([*Wikipedia*](https://en.wikipedia.org/wiki/Bounce_rate)): It represents the percentage of visitors who enter the site and then leave ("bounce") rather than continuing to view other pages within the same site.
> 
> Bounce rate (%) = Visits that access only a single page (#) ÷ Total visits (#) to the website.

> **Conversion** ([*Google Ads Help*](https://support.google.com/google-ads/answer/6365?hl=en#:~:text=An%20action%20that's%20counted%20when,business%20from%20a%20mobile%20phone.)): An action that's counted when someone interacts with your ad or free product listing (for example, clicks a text ad or views a video ad) and then takes an action that you’ve defined as valuable to your business, such as an online purchase or a call to your business from a mobile phone.

> **WAF** ([*Wikipedia*](https://en.wikipedia.org/wiki/Web_application_firewall#:~:text=A%20web%20application%20firewall%20(WAF,and%20from%20a%20web%20service.))): A WAF is a specific form of application firewall that filters, monitors, and blocks HTTP traffic to and from a web service.