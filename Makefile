.DEFAULT_GOAL := help

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

todo:
	@git grep TODO $(SRC_DIR)/

clean:
	@rm $(OUT_DIR)/*.class

help:
	@echo "\
Type 'make <command>' to run a command.\n\\n\
downloadDataset		Download Apache's access log file (~1.7GB)\n\
build			Compile Java sources\n\
run			Launch main application\n\
todo			Show to-do list (exit with 'q')\n\
clean			Delete compiled files\n\
help			Show command intructions\n"