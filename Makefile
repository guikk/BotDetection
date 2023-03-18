.DEFAULT_GOAL := build

SRC_DIR := src/main/java
OUT_DIR := target

downloadDataset:
	@mkdir -p input_data
	wget http://www.almhuette-raith.at/apache-log/access.log -O input_data/access.log

build:
	@mkdir -p target
	javac -d $(OUT_DIR)/ -cp $(SRC_DIR)/ $(SRC_DIR)/*.java

run:
	java -cp $(OUT_DIR)/ BotDetector

clean:
	@rm $(OUT_DIR)/*.class