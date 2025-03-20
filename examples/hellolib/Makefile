NAME = libhello.so
CFLAGS += -Wall -O2

MAJOR = 1
MINOR = 0
PATCH = 0
SONAME = ${NAME}.${MAJOR}
TARGET = ${SONAME}.${MINOR}.${PATCH}

all: ${TARGET}

${TARGET}: hello.o
	$(CC) $(CFLAGS) $(CPPFLAGS) $(LDFLAGS) \
		-shared -fPIC -Wl,-soname,${SONAME} -o $@ $^

install:
	install -d ${DESTDIR}/usr/lib/
	install ${TARGET} ${DESTDIR}/usr/lib/
	ln -rs ${DESTDIR}/usr/lib/${TARGET} ${DESTDIR}/usr/lib/${SONAME}
	ln -rs ${DESTDIR}/usr/lib/${SONAME} ${DESTDIR}/usr/lib/${NAME}

clean:
	rm -f ${TARGET} *.o
