TARGET = lhello
CFLAGS += -Wall -O2
LDLIBS = -lhello

all: ${TARGET}

${TARGET}: ${TARGET}.o

install:
	install -d ${DESTDIR}/usr/bin/
	install ${TARGET} ${DESTDIR}/usr/bin/

clean:
	rm -f ${TARGET} ${TARGET}.o
