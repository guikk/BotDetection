# BotDetection
Simple bot detection project made in Java.

[📝**Notes about the subject**](Notes.md)
[📓**Implementation Journal**](Journal.md)

## Data Source
Apache's access log at http://www.almhuette-raith.at/apache-log/access.log

## Instructions
~~~bash
$ make help
~~~


## Future work and improvements
- Solve to-do tasks (see list with `make todo`)
- Set up an open-source metrics provider
- Detect junk conversions and blocklist IPs
- Benchmark execution time for the function `public boolean detect(Request request)`

## Scalability & Architecture 
When changing from the log file to a real streaming source, the detect function would be called based on the arrival of new data instead of imperatively reading the next request and so on.

To scale the system, my approach would be scaling the detector out to multiple worker nodes that would be served from the streaming source with load balancing to optimize response time. This would also raise complexity on the synchronization side, maybe creatinhg a need to change the metrics API.

## Requirements
**Java Default JRE/JDK (v11.0.18)**
~~~bash
$ sudo apt install default-jre
...
$ java --version
openjdk 11.0.18 2023-01-17
OpenJDK Runtime Environment (build 11.0.18+10-post-Ubuntu-0ubuntu122.04)
OpenJDK 64-Bit Server VM (build 11.0.18+10-post-Ubuntu-0ubuntu122.04, mixed mode, sharing)
~~~
~~~bash
$ sudo apt install default-jdk
...
$ javac --version
javac 11.0.18
~~~
**GNU Make (v4.3)**
~~~bash
$ sudo apt install make
~~~

## References
- [DataDome - How to Detect Bots on Your Website, Apps, & APIs](https://datadome.co/bot-management-protection/bot-detection-how-to-identify-bot-traffic-to-your-website/)
- [DataDome - 4 Ways to Block Bad Bots from Your Website, Apps, and APIs](https://datadome.co/bot-management-protection/how-to-block-bots-on-your-website-and-server/)
- [DataDome - What is an anti-bot solution](https://datadome.co/bot-management-protection/what-is-anti-bot-solution/)
- [Radware - Bot Detection](https://www.radware.com/cyberpedia/bot-management/bot-detection/)
