TARGET = print_key
CFLAGS = -Wall -O2
PYTHON ?= python3

all: $(TARGET)

$(TARGET): print_key.c key.c

key.c:
	$(PYTHON) gen_data.py

clean:
	rm -f *.o $(TARGET) key.c

PHONY: all clean
